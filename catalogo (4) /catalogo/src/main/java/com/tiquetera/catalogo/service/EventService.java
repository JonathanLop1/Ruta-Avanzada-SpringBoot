package com.tiquetera.catalogo.service;
// Este servicio puede ser simple, ya que Venue maneja gran parte de la lógica
import com.tiquetera.catalogo.repository.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    private final EventRepository repository;
    public EventService(EventRepository repository) { this.repository = repository; }
}