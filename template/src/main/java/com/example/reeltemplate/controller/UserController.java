package com.example.reeltemplate.controller;

import com.example.reeltemplate.dto.CreateUserRequest;
import com.example.reeltemplate.dto.UserResponse;
import com.example.reeltemplate.response.ApiResponse;
import com.example.reeltemplate.response.PageResponse;
import com.example.reeltemplate.service.NotificationService;
import com.example.reeltemplate.service.UserService;
import jakarta.validation.Valid;
import java.util.UUID;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;
    private final NotificationService notificationService;

    public UserController(UserService userService, NotificationService notificationService) {
        this.userService = userService;
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<UserResponse>> createUser(@Valid @RequestBody CreateUserRequest request) {
        UserResponse response = userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("User created successfully", response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> getUserById(@PathVariable UUID id) {
        return ResponseEntity.ok(ApiResponse.success(userService.getUserById(id)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<UserResponse>>> listUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String name) {

        Pageable pageable = PageRequest.of(page, size);
        PageResponse<UserResponse> response = userService.listUsers(name, pageable);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @PostMapping("/{id}/welcome-email")
    public ResponseEntity<ApiResponse<Void>> sendWelcomeEmail(@PathVariable UUID id) {
        notificationService.sendWelcomeEmail(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(ApiResponse.success("Welcome email scheduled", null));
    }
}
