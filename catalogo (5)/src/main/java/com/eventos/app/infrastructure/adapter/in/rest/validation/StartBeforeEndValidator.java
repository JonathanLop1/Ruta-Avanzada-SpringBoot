package com.eventos.app.infrastructure.adapter.in.rest.validation;

import com.eventos.app.infrastructure.adapter.in.rest.dto.request.EventRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StartBeforeEndValidator implements ConstraintValidator<StartBeforeEnd, EventRequest> {

    @Override
    public boolean isValid(EventRequest request, ConstraintValidatorContext context) {
        // Retornamos true si es null, dejando que @NotNull en los campos individuales maneje la obligatoriedad.
        if (request == null || request.startDate() == null || request.endDate() == null) {
            return true; 
        }

        boolean isValid = request.startDate().isBefore(request.endDate());

        if (!isValid) {
            // Deshabilitamos el mensaje por defecto para asignarlo al campo específico 'endDate'
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                   .addPropertyNode("endDate")
                   .addConstraintViolation();
        }

        return isValid; // Debe retornar true si pasa la validación, false si falla
    }
}