package com.tiquetera.hexagonal.domain.ports.out;
import com.tiquetera.hexagonal.domain.model.Event;
import java.util.List;
import java.util.Optional;

// El dominio dice: "Necesito alguien que guarde esto, no me importa si es SQL, Mongo o un archivo TXT"
public interface EventRepositoryPort {
    Event save(Event event);
    List<Event> findAll();
}