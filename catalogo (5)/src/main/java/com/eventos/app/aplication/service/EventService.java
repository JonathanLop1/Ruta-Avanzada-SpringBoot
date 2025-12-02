package com.eventos.app.application.service;

import com.eventos.app.application.port.in.ManageEventUseCase;
import com.eventos.app.application.port.out.EventRepositoryPort;
import com.eventos.app.domain.exception.EventNotFoundException;
import com.eventos.app.domain.model.Event;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class EventService implements ManageEventUseCase {

    private final EventRepositoryPort eventRepositoryPort;

    public EventService(EventRepositoryPort eventRepositoryPort) {
        this.eventRepositoryPort = eventRepositoryPort;
    }

    @Override
    @Transactional
    public Event createEvent(Event event) {
        event.setStatus("CREATED");
        return eventRepositoryPort.save(event);
    }

    @Override
    @Transactional
    public Event updateEvent(Long id, Event eventData) {
        Event existingEvent = eventRepositoryPort.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));
        
        existingEvent.setName(eventData.getName());
        existingEvent.setStartDate(eventData.getStartDate());
        existingEvent.setEndDate(eventData.getEndDate());
        existingEvent.setLocation(eventData.getLocation());
        
        return eventRepositoryPort.save(existingEvent);
    }

    @Override
    @Transactional(readOnly = true)
    public Event getEvent(Long id) {
        return eventRepositoryPort.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Event> getAllEvents() {
        return eventRepositoryPort.findAll();
    }

    @Override
    @Transactional
    public void cancelEvent(Long id) {
        Event existingEvent = eventRepositoryPort.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));
        existingEvent.setStatus("CANCELLED");
        eventRepositoryPort.save(existingEvent);
    }

    @Override
    @Transactional
    public void deleteEvent(Long id) {
        if (eventRepositoryPort.findById(id).isEmpty()) {
            throw new EventNotFoundException(id);
        }
        eventRepositoryPort.deleteById(id);
    }
}