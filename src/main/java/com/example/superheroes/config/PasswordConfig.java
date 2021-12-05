package com.example.superheroes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        // return new BCryptPasswordEncoder(10); // safer

        return NoOpPasswordEncoder.getInstance(); // NoOpPasswordEncoder is for demo purposes only
    }
}
