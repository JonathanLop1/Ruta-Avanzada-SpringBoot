package com.eventos.app.infrastructure.adapter.in.rest.dto.response;

import java.time.LocalDateTime;

/**
 * DTO de respuesta para enviar al cliente.
 */
public record EventResponse(
    Long id,
    String name,
    LocalDateTime startDate,
    LocalDateTime endDate,
    String location,
    String status
) {}