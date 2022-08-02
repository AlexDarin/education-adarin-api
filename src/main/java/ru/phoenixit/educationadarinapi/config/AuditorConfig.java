package ru.phoenixit.educationadarinapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@Configuration
@EnableMongoAuditing
public class AuditorConfig {

    @Bean
    public CurrentUserAuditorAware auditorProvider(){
        return new CurrentUserAuditorAware();
    }
}
