package com.example.reeltemplate.service;

import com.example.reeltemplate.dto.CreateUserRequest;
import com.example.reeltemplate.dto.UserResponse;
import com.example.reeltemplate.entity.User;
import com.example.reeltemplate.entity.UserStatus;
import com.example.reeltemplate.exception.ResourceNotFoundException;
import com.example.reeltemplate.mapper.UserMapper;
import com.example.reeltemplate.repository.UserRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    @Test
    void shouldReturnUserWhenIdExists() {
        UUID userId = UUID.randomUUID();
        User user = new User("Daniel", "daniel@example.com", UserStatus.ACTIVE);
        UserResponse response = new UserResponse(userId, "Daniel", "daniel@example.com", "ACTIVE", LocalDateTime.now());

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(userMapper.toResponse(user)).thenReturn(response);

        UserResponse result = userService.getUserById(userId);

        assertEquals("Daniel", result.name());
        assertEquals("daniel@example.com", result.email());
    }

    @Test
    void shouldThrowWhenUserDoesNotExist() {
        UUID userId = UUID.randomUUID();

        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> userService.getUserById(userId));
    }

    @Test
    void shouldCreateUserWhenEmailIsAvailable() {
        CreateUserRequest request = new CreateUserRequest("Daniel", "daniel@example.com");
        User user = new User("Daniel", "daniel@example.com", UserStatus.ACTIVE);
        User savedUser = new User("Daniel", "daniel@example.com", UserStatus.ACTIVE);
        UserResponse response = new UserResponse(UUID.randomUUID(), "Daniel", "daniel@example.com", "ACTIVE", LocalDateTime.now());

        when(userRepository.findByEmail("daniel@example.com")).thenReturn(Optional.empty());
        when(userMapper.toEntity(request)).thenReturn(user);
        when(userRepository.save(any(User.class))).thenReturn(savedUser);
        when(userMapper.toResponse(savedUser)).thenReturn(response);

        UserResponse result = userService.createUser(request);

        assertEquals("daniel@example.com", result.email());
    }
}
