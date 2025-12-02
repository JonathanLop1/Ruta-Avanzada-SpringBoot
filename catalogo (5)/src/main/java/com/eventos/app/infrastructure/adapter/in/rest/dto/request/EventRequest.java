package com.eventos.app.infrastructure.adapter.in.rest.dto.request;

import com.eventos.app.infrastructure.adapter.in.rest.validation.StartBeforeEnd;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@StartBeforeEnd(message = "{event.date.range.invalid}")
public record EventRequest(
    @NotBlank(message = "{event.name.required}")
    @Size(min = 3, max = 100, message = "{event.name.size}")
    String name,

    @NotNull(message = "{event.startDate.required}")
    @Future(message = "{event.startDate.future}")
    LocalDateTime startDate,

    @NotNull(message = "{event.endDate.required}")
    LocalDateTime endDate,
    
    @NotBlank(message = "{event.location.required}")
    String location
) {}