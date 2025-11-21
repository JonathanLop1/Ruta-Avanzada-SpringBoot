package com.tiquetera.hexagonal.infrastructure.adapters.out.jpa;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "events")
@Data
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    // Mappers manuales (Para no usar librerías extra)
    public static EventEntity fromDomain(com.tiquetera.hexagonal.domain.model.Event event) {
        EventEntity entity = new EventEntity();
        entity.setId(event.getId());
        entity.setName(event.getName());
        entity.setDescription(event.getDescription());
        return entity;
    }

    public com.tiquetera.hexagonal.domain.model.Event toDomain() {
        return new com.tiquetera.hexagonal.domain.model.Event(this.id, this.name, this.description);
    }
}