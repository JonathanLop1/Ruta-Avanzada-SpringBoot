package com.tiquetera.hexagonal.infrastructure.config;

import com.tiquetera.hexagonal.application.usecase.EventUseCaseImpl;
import com.tiquetera.hexagonal.domain.ports.in.CreateEventUseCase;
import com.tiquetera.hexagonal.domain.ports.out.EventRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public CreateEventUseCase createEventUseCase(EventRepositoryPort eventRepositoryPort) {
        return new EventUseCaseImpl(eventRepositoryPort);
    }
}