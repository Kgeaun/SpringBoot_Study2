package com.example.springboot_study2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SpringBootStudy2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStudy2Application.class, args);
    }
}