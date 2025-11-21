package com.tiquetera.catalogo.service;

import com.tiquetera.catalogo.dto.VenueDTO;
import com.tiquetera.catalogo.model.Venue;
import com.tiquetera.catalogo.repository.VenueRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VenueService {
    private final VenueRepository repository;

    public VenueService(VenueRepository repository) {
        this.repository = repository;
    }

    public Page<Venue> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<Venue> getById(Long id) {
        return repository.findById(id);
    }

    public Venue create(VenueDTO dto) {
        Venue venue = new Venue();
        venue.setName(dto.getName());
        venue.setCity(dto.getCity());
        venue.setAddress(dto.getAddress());
        venue.setCapacity(dto.getCapacity());
        return repository.save(venue);
    }
    
    // (Puedes agregar update y delete aquí si los necesitas)
}