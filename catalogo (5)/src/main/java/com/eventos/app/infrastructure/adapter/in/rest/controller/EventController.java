package com.eventos.app.infrastructure.adapter.in.rest.controller;

import com.eventos.app.application.port.in.ManageEventUseCase;
import com.eventos.app.domain.model.Event;
import com.eventos.app.infrastructure.adapter.in.rest.dto.request.EventRequest;
import com.eventos.app.infrastructure.adapter.in.rest.dto.response.EventResponse;
import com.eventos.app.infrastructure.adapter.in.rest.mapper.EventRestMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final ManageEventUseCase manageEventUseCase;
    private final EventRestMapper restMapper;

    public EventController(ManageEventUseCase manageEventUseCase, EventRestMapper restMapper) {
        this.manageEventUseCase = manageEventUseCase;
        this.restMapper = restMapper;
    }

    @PostMapping
    public ResponseEntity<EventResponse> createEvent(@Valid @RequestBody EventRequest request) {
        Event created = manageEventUseCase.createEvent(restMapper.toDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(restMapper.toResponse(created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventResponse> updateEvent(@PathVariable Long id, @Valid @RequestBody EventRequest request) {
        Event updated = manageEventUseCase.updateEvent(id, restMapper.toDomain(request));
        return ResponseEntity.ok(restMapper.toResponse(updated));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponse> getEvent(@PathVariable Long id) {
        return ResponseEntity.ok(restMapper.toResponse(manageEventUseCase.getEvent(id)));
    }

    @GetMapping
    public ResponseEntity<List<EventResponse>> getAllEvents() {
        return ResponseEntity.ok(manageEventUseCase.getAllEvents().stream()
                .map(restMapper::toResponse).collect(Collectors.toList()));
    }

    @PatchMapping("/{id}/cancel")
    public ResponseEntity<Void> cancelEvent(@PathVariable Long id) {
        manageEventUseCase.cancelEvent(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        manageEventUseCase.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
}