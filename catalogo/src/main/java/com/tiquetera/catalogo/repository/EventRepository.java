package com.tiquetera.catalogo.repository;

import com.tiquetera.catalogo.model.Event;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class EventRepository {
    private final List<Event> events = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public List<Event> findAll() {
        return new ArrayList<>(events); // Retorna copia para seguridad
    }

    public Optional<Event> findById(Long id) {
        return events.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    public Event save(Event event) {
        if (event.getId() == null) {
            event.setId(idCounter.getAndIncrement());
            events.add(event);
        } else {
            // Actualización: Borramos el viejo y ponemos el nuevo en su lugar
            deleteById(event.getId());
            events.add(event);
        }
        return event;
    }

    public boolean deleteById(Long id) {
        return events.removeIf(e -> e.getId().equals(id));
    }
}