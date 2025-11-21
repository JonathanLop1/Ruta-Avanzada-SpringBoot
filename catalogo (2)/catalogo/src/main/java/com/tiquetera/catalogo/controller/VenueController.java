package com.tiquetera.catalogo.controller;

import com.tiquetera.catalogo.dto.VenueDTO;
import com.tiquetera.catalogo.model.Venue;
import com.tiquetera.catalogo.service.VenueService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/venues")
@Tag(name = "Venues", description = "Gestión de lugares")
public class VenueController {
    private final VenueService service;

    public VenueController(VenueService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<Venue>> getAll(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(service.getAll(pageable));
    }

    @PostMapping
    public ResponseEntity<Venue> create(@Valid @RequestBody VenueDTO dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }
}