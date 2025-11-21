package com.tiquetera.hexagonal.infrastructure.adapters.out.jpa;

import com.tiquetera.hexagonal.domain.model.Event;
import com.tiquetera.hexagonal.domain.ports.out.EventRepositoryPort;
import org.springframework.stereotype.Component; // Aquí sí usamos Spring
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventJpaAdapter implements EventRepositoryPort {

    private final JpaEventRepository jpaRepository;

    public EventJpaAdapter(JpaEventRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Event save(Event event) {
        // 1. Convertir Dominio -> Entidad
        EventEntity entity = EventEntity.fromDomain(event);
        // 2. Guardar en DB
        EventEntity saved = jpaRepository.save(entity);
        // 3. Convertir Entidad -> Dominio
        return saved.toDomain();
    }

    @Override
    public List<Event> findAll() {
        return jpaRepository.findAll().stream()
                .map(EventEntity::toDomain) // Convertir cada entidad a dominio
                .collect(Collectors.toList());
    }
}