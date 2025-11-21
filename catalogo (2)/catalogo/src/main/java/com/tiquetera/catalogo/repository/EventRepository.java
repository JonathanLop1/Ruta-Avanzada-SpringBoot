package com.tiquetera.catalogo.repository;

import com.tiquetera.catalogo.model.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    boolean existsByName(String name);
    Page<Event> findByCategory(String category, Pageable pageable);
}