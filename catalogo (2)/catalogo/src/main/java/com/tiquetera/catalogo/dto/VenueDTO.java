package com.tiquetera.catalogo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class VenueDTO {
    @NotBlank(message = "El nombre es obligatorio")
    private String name;
    
    @NotBlank(message = "La ciudad es obligatoria")
    private String city;
    
    private String address;
    
    @Min(value = 1, message = "La capacidad debe ser positiva")
    private int capacity;
}