package com.tiquetera.catalogo.dto;
import lombok.Data;
import java.util.List;

@Data
public class VenueDTO {
    private Long id;
    private String name;
    private String address;
    private int capacity;
    private List<EventDTO> events; // Lista anidada opcional
}