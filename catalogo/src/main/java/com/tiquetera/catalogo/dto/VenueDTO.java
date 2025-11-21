package com.tiquetera.catalogo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class VenueDTO {
    @NotBlank(message = "El nombre del venue es obligatorio")
    private String name;
    
    @NotBlank(message = "La dirección es obligatoria")
    private String address;
    
    @Min(value = 1, message = "La capacidad debe ser mayor a 0")
    private int capacity;
}