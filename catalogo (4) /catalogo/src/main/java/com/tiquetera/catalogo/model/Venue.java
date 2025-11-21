package com.tiquetera.catalogo.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "venues")
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private int capacity;

    // RELACIÓN ONE-TO-MANY (Un venue, muchos eventos)
    // mappedBy: "Yo no soy dueño de la relación, el dueño es el campo 'venue' en la clase Event"
    // cascade = ALL: Si guardo/borro Venue, guarda/borra sus eventos.
    // orphanRemoval = true: Si saco un evento de esta lista, bórralo de la BD.
    @OneToMany(mappedBy = "venue", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Event> events = new ArrayList<>();

    // HELPER METHOD: Vital para relaciones bidireccionales
    // Mantiene sincronizados ambos lados (Java y BD)
    public void addEvent(Event event) {
        events.add(event);
        event.setVenue(this);
    }

    public void removeEvent(Event event) {
        events.remove(event);
        event.setVenue(null);
    }

    @Override
    public String toString() {
        return "Venue{id=" + id + ", name='" + name + "'}";
    }
}