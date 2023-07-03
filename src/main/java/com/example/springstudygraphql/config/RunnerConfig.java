package com.example.springstudygraphql.config;

import com.example.springstudygraphql.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RunnerConfig {
    private final SchoolService schoolService;

    //generate schools and save it on running the application
    @Bean
    ApplicationRunner applicationRunner() {
        return args -> {
            schoolService.saveSchools();
        };
    }
}
