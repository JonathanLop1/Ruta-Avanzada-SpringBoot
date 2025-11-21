package com.tiquetera.catalogo.service;

import com.tiquetera.catalogo.dto.EventDTO;
import com.tiquetera.catalogo.model.Event;
import com.tiquetera.catalogo.repository.EventRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class EventService {
    private final EventRepository repository;

    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    public Page<Event> getAll(String category, Pageable pageable) {
        if (category != null && !category.isEmpty()) {
            return repository.findByCategory(category, pageable);
        }
        return repository.findAll(pageable);
    }

    public Optional<Event> getById(Long id) {
        return repository.findById(id);
    }

    public Event create(EventDTO dto) {
        if (repository.existsByName(dto.getName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Nombre de evento duplicado");
        }
        Event event = new Event();
        event.setName(dto.getName());
        event.setDescription(dto.getDescription());
        event.setCategory(dto.getCategory());
        event.setDate(dto.getDate());
        event.setActive(true);
        return repository.save(event);
    }

    public Optional<Event> update(Long id, EventDTO dto) {
        return repository.findById(id).map(existing -> {
            existing.setName(dto.getName());
            existing.setDescription(dto.getDescription());
            existing.setCategory(dto.getCategory());
            existing.setDate(dto.getDate());
            return repository.save(existing);
        });
    }

    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}