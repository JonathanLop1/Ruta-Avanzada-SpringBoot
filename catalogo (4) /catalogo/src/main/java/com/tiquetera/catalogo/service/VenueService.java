package com.tiquetera.catalogo.service;

import com.tiquetera.catalogo.dto.VenueDTO;
import com.tiquetera.catalogo.dto.EventDTO;
import com.tiquetera.catalogo.model.Event;
import com.tiquetera.catalogo.model.Venue;
import com.tiquetera.catalogo.repository.VenueRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VenueService {
    private final VenueRepository repository;

    public VenueService(VenueRepository repository) {
        this.repository = repository;
    }

    // Creamos Venue Y sus eventos al mismo tiempo (Gracias a CascadeType.ALL)
    @Transactional
    public VenueDTO createWithEvents(VenueDTO dto) {
        Venue venue = new Venue();
        venue.setName(dto.getName());
        venue.setAddress(dto.getAddress());
        venue.setCapacity(dto.getCapacity());

        // Si vienen eventos en el DTO, los agregamos usando el Helper Method
        if (dto.getEvents() != null) {
            for (EventDTO eDto : dto.getEvents()) {
                Event event = new Event();
                event.setName(eDto.getName());
                venue.addEvent(event); // Esto configura la relación bidireccional
            }
        }

        // AL GUARDAR EL VENUE, SE GUARDAN SOLOS LOS EVENTOS (Cascade)
        Venue savedVenue = repository.save(venue);
        return convertToDTO(savedVenue);
    }

    @Transactional(readOnly = true)
    public List<VenueDTO> getAll() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Método para borrar y probar orphanRemoval / cascade remove
    public void delete(Long id) {
        repository.deleteById(id); 
    }

    // Mapper manual simple
    private VenueDTO convertToDTO(Venue venue) {
        VenueDTO dto = new VenueDTO();
        dto.setId(venue.getId());
        dto.setName(venue.getName());
        dto.setAddress(venue.getAddress());
        dto.setCapacity(venue.getCapacity());
        // Mapeamos eventos también
        if (venue.getEvents() != null) {
            List<EventDTO> eventDTOs = venue.getEvents().stream().map(e -> {
                EventDTO ed = new EventDTO();
                ed.setId(e.getId());
                ed.setName(e.getName());
                ed.setVenueId(venue.getId());
                return ed;
            }).collect(Collectors.toList());
            dto.setEvents(eventDTOs);
        }
        return dto;
    }
}