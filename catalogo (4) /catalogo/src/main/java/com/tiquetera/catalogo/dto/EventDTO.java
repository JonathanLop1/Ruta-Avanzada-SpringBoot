package com.tiquetera.catalogo.dto;
import lombok.Data;

@Data
public class EventDTO {
    private Long id;
    private String name;
    private Long venueId; // Solo el ID, no el objeto completo
}