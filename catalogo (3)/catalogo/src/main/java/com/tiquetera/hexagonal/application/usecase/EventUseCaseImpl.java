package com.tiquetera.hexagonal.application.usecase;

import com.tiquetera.hexagonal.domain.model.Event;
import com.tiquetera.hexagonal.domain.ports.in.CreateEventUseCase;
import com.tiquetera.hexagonal.domain.ports.out.EventRepositoryPort;
import java.util.List;

public class EventUseCaseImpl implements CreateEventUseCase {

    private final EventRepositoryPort eventRepositoryPort;

    // Inyección de dependencia por constructor (Estándar Java)
    public EventUseCaseImpl(EventRepositoryPort eventRepositoryPort) {
        this.eventRepositoryPort = eventRepositoryPort;
    }

    @Override
    public Event createEvent(Event event) {
        // Aquí irían validaciones de negocio puras
        return eventRepositoryPort.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepositoryPort.findAll();
    }
}