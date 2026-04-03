package com.example.reeltemplate.service;

import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private static final Logger log = LoggerFactory.getLogger(NotificationService.class);

    @Async
    public void sendWelcomeEmail(UUID userId) {
        log.info("Scheduling welcome email for userId={}", userId);
    }
}
