package com.tiquetera.catalogo.service;

import com.tiquetera.catalogo.dto.VenueDTO;
import com.tiquetera.catalogo.model.Venue;
import com.tiquetera.catalogo.repository.VenueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VenueService {

    private final VenueRepository repository;

    public VenueService(VenueRepository repository) {
        this.repository = repository;
    }

    public List<Venue> getAll() {
        return repository.findAll();
    }

    public Optional<Venue> getById(Long id) {
        return repository.findById(id);
    }

    public Venue create(VenueDTO dto) {
        Venue venue = new Venue();
        venue.setName(dto.getName());
        venue.setAddress(dto.getAddress());
        venue.setCapacity(dto.getCapacity());
        return repository.save(venue);
    }

    public Optional<Venue> update(Long id, VenueDTO dto) {
        return repository.findById(id).map(existing -> {
            existing.setName(dto.getName());
            existing.setAddress(dto.getAddress());
            existing.setCapacity(dto.getCapacity());
            return repository.save(existing);
        });
    }

    public boolean delete(Long id) {
        return repository.deleteById(id);
    }
}