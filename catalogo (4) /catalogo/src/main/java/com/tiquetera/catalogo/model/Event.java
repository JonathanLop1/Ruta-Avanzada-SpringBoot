package com.tiquetera.catalogo.model;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // RELACIÓN MANY-TO-ONE (Muchos eventos, un venue)
    // FetchType.LAZY: No traigas el Venue entero a menos que te lo pida.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venue_id", nullable = false) // La columna FK física
    private Venue venue;

    // Override toString para evitar bucles infinitos
    @Override
    public String toString() {
        return "Event{id=" + id + ", name='" + name + "'}";
    }
}