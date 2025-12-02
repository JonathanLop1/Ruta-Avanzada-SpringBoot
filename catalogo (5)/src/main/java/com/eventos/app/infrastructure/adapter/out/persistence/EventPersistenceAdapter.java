package com.eventos.app.infrastructure.adapter.out.persistence;

import com.eventos.app.application.port.out.EventRepositoryPort;
import com.eventos.app.domain.model.Event;
import com.eventos.app.infrastructure.adapter.out.persistence.mapper.EventPersistenceMapper;
import com.eventos.app.infrastructure.adapter.out.persistence.repository.JpaEventRepository;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EventPersistenceAdapter implements EventRepositoryPort {
    private final JpaEventRepository repo;
    private final EventPersistenceMapper mapper;

    public EventPersistenceAdapter(JpaEventRepository repo, EventPersistenceMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override public Event save(Event event) { return mapper.toDomain(repo.save(mapper.toEntity(event))); }
    @Override public Optional<Event> findById(Long id) { return repo.findById(id).map(mapper::toDomain); }
    @Override public List<Event> findAll() { return repo.findAll().stream().map(mapper::toDomain).collect(Collectors.toList()); }
    @Override public void deleteById(Long id) { repo.deleteById(id); }
}