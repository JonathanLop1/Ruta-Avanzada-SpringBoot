package com.tiquetera.hexagonal.domain.ports.in;
import com.tiquetera.hexagonal.domain.model.Event;
import java.util.List;

public interface CreateEventUseCase {
    Event createEvent(Event event);
    List<Event> getAllEvents();
}