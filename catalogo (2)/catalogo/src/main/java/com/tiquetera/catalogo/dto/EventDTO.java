package com.tiquetera.catalogo.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class EventDTO {
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, message = "El nombre debe tener al menos 3 letras")
    private String name;

    private String description;
    private String category;

    @NotNull(message = "La fecha es obligatoria")
    @Future(message = "El evento debe ser en el futuro")
    private LocalDateTime date;
}