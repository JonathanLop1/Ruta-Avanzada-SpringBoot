package com.tiquetera.hexagonal.infrastructure.adapters.out.jpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaEventRepository extends JpaRepository<EventEntity, Long> {
}