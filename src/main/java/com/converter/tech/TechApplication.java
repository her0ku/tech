package com.converter.tech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public abstract class TechApplication {
    public static void main(String[] args) {
        SpringApplication.run(TechApplication.class, args);
    }
}
