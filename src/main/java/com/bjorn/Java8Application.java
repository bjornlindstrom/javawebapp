package com.bjorn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Java8Application {
    public static void main(String[] args) {
        SpringApplication.run(Java8Application.class, args);
    }
}
