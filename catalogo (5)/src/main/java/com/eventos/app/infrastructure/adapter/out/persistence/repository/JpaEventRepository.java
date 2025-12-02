package com.eventos.app.infrastructure.adapter.out.persistence.repository;

import com.eventos.app.infrastructure.adapter.out.persistence.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaEventRepository extends JpaRepository<EventEntity, Long> {}