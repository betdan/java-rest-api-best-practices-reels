package com.example.reeltemplate.service;

import com.example.reeltemplate.dto.CreateUserRequest;
import com.example.reeltemplate.dto.UserResponse;
import com.example.reeltemplate.entity.User;
import com.example.reeltemplate.exception.ResourceNotFoundException;
import com.example.reeltemplate.mapper.UserMapper;
import com.example.reeltemplate.repository.UserRepository;
import com.example.reeltemplate.response.PageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional
    @CacheEvict(value = "users", allEntries = true)
    public UserResponse createUser(CreateUserRequest request) {
        log.info("Creating user with email={}", request.email());

        userRepository.findByEmail(request.email().trim().toLowerCase())
                .ifPresent(existingUser -> {
                    throw new IllegalArgumentException("Email already exists");
                });

        User savedUser = userRepository.save(userMapper.toEntity(request));
        return userMapper.toResponse(savedUser);
    }

    @Transactional(readOnly = true)
    @Cacheable(value = "users", key = "#id")
    public UserResponse getUserById(java.util.UUID id) {
        log.info("Fetching user by id={}", id);

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        return userMapper.toResponse(user);
    }

    @Transactional(readOnly = true)
    public PageResponse<UserResponse> listUsers(String name, Pageable pageable) {
        log.info("Listing users with nameFilter={}, page={}, size={}", name, pageable.getPageNumber(), pageable.getPageSize());

        Page<User> page = hasText(name)
                ? userRepository.findByNameContainingIgnoreCase(name.trim(), pageable)
                : userRepository.findAll(pageable);

        return new PageResponse<>(
                page.getContent().stream().map(userMapper::toResponse).toList(),
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages()
        );
    }

    private boolean hasText(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
