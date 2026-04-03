package com.example.reeltemplate.controller;

import com.example.reeltemplate.dto.CreateUserRequest;
import com.example.reeltemplate.dto.UserResponse;
import com.example.reeltemplate.service.NotificationService;
import com.example.reeltemplate.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import com.example.reeltemplate.config.SecurityConfig;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@Import(SecurityConfig.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserService userService;

    @MockBean
    private NotificationService notificationService;

    @Test
    @WithMockUser
    void shouldCreateUser() throws Exception {
        UserResponse response = new UserResponse(
                UUID.randomUUID(),
                "Daniel",
                "daniel@example.com",
                "ACTIVE",
                LocalDateTime.now()
        );

        when(userService.createUser(any(CreateUserRequest.class))).thenReturn(response);

        CreateUserRequest request = new CreateUserRequest("Daniel", "daniel@example.com");

        mockMvc.perform(post("/api/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.email").value("daniel@example.com"));
    }
}
