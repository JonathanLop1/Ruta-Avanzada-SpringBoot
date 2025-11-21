package com.tiquetera.catalogo.controller;

import com.tiquetera.catalogo.dto.VenueDTO;
import com.tiquetera.catalogo.service.VenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/venues")
public class VenueController {
    private final VenueService service;

    public VenueController(VenueService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<VenueDTO> create(@RequestBody VenueDTO dto) {
        return new ResponseEntity<>(service.createWithEvents(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VenueDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}