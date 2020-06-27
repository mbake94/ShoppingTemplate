package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringSecurityJdbc {
    @Bean
    public CommandLineRunner run(UserRepository userRepository, RoleRepository roleRepository) throws Exception {
        return  (String[]args)->{
            User user = new User("user", "user@user", "user", "Miles", "Baker", "555-555-5555", true);
            Role userRole = new Role("user", "ROLE_USER");

            userRepository.save(user);
            roleRepository.save(userRole);

            User admin = new User("admin", "admin@admin", "admin", "Miles", "Baker", "555-555-5555", true);
            Role adminRole = new Role("admin", "ROLE_ADMIN");

            userRepository.save(admin);
            roleRepository.save(adminRole);
        };
    }
}
