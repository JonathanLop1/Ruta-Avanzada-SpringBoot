package com.tiquetera.catalogo.repository;
import com.tiquetera.catalogo.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue, Long> {}