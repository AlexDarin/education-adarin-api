package ru.phoenixit.educationadarinapi.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class CurrentUserAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Test user");
    }
}
