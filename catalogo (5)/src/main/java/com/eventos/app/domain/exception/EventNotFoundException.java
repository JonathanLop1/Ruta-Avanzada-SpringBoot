package com.eventos.app.domain.exception;

public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(Long id) {
        super("No se encontró el evento con ID: " + id);
    }
}