package com.tiquetera.catalogo.service;

import com.tiquetera.catalogo.dto.EventDTO;
import com.tiquetera.catalogo.model.Event;
import com.tiquetera.catalogo.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    
    private final EventRepository repository;

    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    public List<Event> getAll() {
        return repository.findAll();
    }

    public Optional<Event> getById(Long id) {
        return repository.findById(id);
    }

    public Event create(EventDTO dto) {
        Event event = new Event();
        event.setName(dto.getName());
        event.setDescription(dto.getDescription());
        event.setActive(true);
        return repository.save(event);
    }

    public Optional<Event> update(Long id, EventDTO dto) {
        return repository.findById(id).map(existing -> {
            existing.setName(dto.getName());
            existing.setDescription(dto.getDescription());
            return repository.save(existing);
        });
    }

    public boolean delete(Long id) {
        return repository.deleteById(id);
    }
}