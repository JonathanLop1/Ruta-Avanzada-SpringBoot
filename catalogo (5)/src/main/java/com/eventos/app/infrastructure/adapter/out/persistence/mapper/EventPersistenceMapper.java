package com.eventos.app.infrastructure.adapter.out.persistence.mapper;

import com.eventos.app.domain.model.Event;
import com.eventos.app.infrastructure.adapter.out.persistence.entity.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventPersistenceMapper {
    public EventEntity toEntity(Event d) {
        if (d == null) return null;
        return new EventEntity(d.getId(), d.getName(), d.getStartDate(), d.getEndDate(), d.getLocation(), d.getStatus());
    }
    public Event toDomain(EventEntity e) {
        if (e == null) return null;
        return new Event(e.getId(), e.getName(), e.getStartDate(), e.getEndDate(), e.getLocation(), e.getStatus());
    }
}