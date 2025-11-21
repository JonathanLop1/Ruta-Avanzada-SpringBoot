package com.tiquetera.catalogo.repository;

import com.tiquetera.catalogo.model.Venue;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class VenueRepository {
    private final List<Venue> venues = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public List<Venue> findAll() {
        return new ArrayList<>(venues);
    }

    public Optional<Venue> findById(Long id) {
        return venues.stream().filter(v -> v.getId().equals(id)).findFirst();
    }

    public Venue save(Venue venue) {
        if (venue.getId() == null) {
            venue.setId(idCounter.getAndIncrement());
            venues.add(venue);
        } else {
            deleteById(venue.getId());
            venues.add(venue);
        }
        return venue;
    }

    public boolean deleteById(Long id) {
        return venues.removeIf(v -> v.getId().equals(id));
    }
}