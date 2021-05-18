package com.example.academy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//import org.springframework.data.jpa.repositotry.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Application {      // Java Persistence API
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
