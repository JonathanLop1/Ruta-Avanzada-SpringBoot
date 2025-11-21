package com.tiquetera.hexagonal.infrastructure.adapters.in.web;

import com.tiquetera.hexagonal.domain.model.Event;
import com.tiquetera.hexagonal.domain.ports.in.CreateEventUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final CreateEventUseCase createEventUseCase;

    // Inyectamos la INTERFAZ (El puerto de entrada), no la implementación
    public EventController(CreateEventUseCase createEventUseCase) {
        this.createEventUseCase = createEventUseCase;
    }

    @PostMapping
    public ResponseEntity<Event> create(@RequestBody Event event) {
        return ResponseEntity.ok(createEventUseCase.createEvent(event));
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAll() {
        return ResponseEntity.ok(createEventUseCase.getAllEvents());
    }
}