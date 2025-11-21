package com.tiquetera.catalogo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private Long id;
    private String name;
    private String description;
    private boolean isActive;
}