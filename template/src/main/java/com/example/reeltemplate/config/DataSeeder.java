package com.example.reeltemplate.config;

import com.example.reeltemplate.entity.User;
import com.example.reeltemplate.entity.UserStatus;
import com.example.reeltemplate.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    public CommandLineRunner loadSampleData(UserRepository userRepository) {
        return args -> {
            if (userRepository.count() > 0) {
                return;
            }

            userRepository.save(new User("Daniel", "daniel@example.com", UserStatus.ACTIVE));
            userRepository.save(new User("Sofia", "sofia@example.com", UserStatus.ACTIVE));
            userRepository.save(new User("Mateo", "mateo@example.com", UserStatus.INACTIVE));
        };
    }
}
