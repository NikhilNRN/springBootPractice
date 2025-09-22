package com.example.spring_boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.spring_boot.repository.UserRepository;
import com.example.spring_boot.model.User;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository userRepository) {
        return (args) -> {
            // Create a new user
            User user = new User();
            user.setUsername("testuser");
            user.setEmail("test@example.com");
            user.setPassword("password123");

            // Save user
            userRepository.save(user);

            // Fetch all users
            System.out.println("All users:");
            for (User u : userRepository.findAll()) {
                System.out.println(u.getId() + " - " + u.getUsername() + " - " + u.getEmail());
            }
        };
    }
}
