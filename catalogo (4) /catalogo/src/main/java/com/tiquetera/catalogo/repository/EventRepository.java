package com.tiquetera.catalogo.repository;
import com.tiquetera.catalogo.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {}