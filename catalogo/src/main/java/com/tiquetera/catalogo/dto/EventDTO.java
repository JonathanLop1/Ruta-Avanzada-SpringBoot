package com.tiquetera.catalogo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EventDTO {
    @NotBlank(message = "El nombre del evento es obligatorio")
    private String name;
    private String description;
}