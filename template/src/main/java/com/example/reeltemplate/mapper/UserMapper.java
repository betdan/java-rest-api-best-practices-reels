package com.example.reeltemplate.mapper;

import com.example.reeltemplate.dto.CreateUserRequest;
import com.example.reeltemplate.dto.UserResponse;
import com.example.reeltemplate.entity.User;
import com.example.reeltemplate.entity.UserStatus;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(CreateUserRequest request) {
        return new User(
                request.name().trim(),
                request.email().trim().toLowerCase(),
                UserStatus.ACTIVE
        );
    }

    public UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getStatus().name(),
                user.getCreatedAt()
        );
    }
}
