package com.eventos.app.infrastructure.adapter.in.rest.mapper;

import com.eventos.app.domain.model.Event;
import com.eventos.app.infrastructure.adapter.in.rest.dto.request.EventRequest;
import com.eventos.app.infrastructure.adapter.in.rest.dto.response.EventResponse;
import org.springframework.stereotype.Component;

/**
 * Convierte entre DTOs REST y el Modelo de Dominio.
 */
@Component
public class EventRestMapper {

    public Event toDomain(EventRequest request) {
        if (request == null) return null;
        // El ID es null al crear
        return new Event(null, request.name(), request.startDate(), request.endDate(), request.location(), null);
    }

    public EventResponse toResponse(Event domain) {
        if (domain == null) return null;
        return new EventResponse(
            domain.getId(),
            domain.getName(),
            domain.getStartDate(),
            domain.getEndDate(),
            domain.getLocation(),
            domain.getStatus()
        );
    }
}