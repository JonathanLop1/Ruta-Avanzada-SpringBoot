package com.eventos.app.application.port.in;

import com.eventos.app.domain.model.Event;
import java.util.List;

public interface ManageEventUseCase {
    Event createEvent(Event event);
    Event updateEvent(Long id, Event event);
    Event getEvent(Long id);
    List<Event> getAllEvents();
    void cancelEvent(Long id);
    void deleteEvent(Long id);
}