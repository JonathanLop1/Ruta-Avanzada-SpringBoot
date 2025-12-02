package com.eventos.app.infrastructure.adapter.in.rest.advice;

import com.eventos.app.domain.exception.EventNotFoundException;
import org.slf4j.MDC;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.net.URI;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Validación fallida");
        problem.setTitle("Bad Request");
        problem.setProperty("timestamp", Instant.now());
        problem.setProperty("traceId", MDC.get("traceId"));
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(e -> errors.put(((FieldError) e).getField(), e.getDefaultMessage()));
        problem.setProperty("errors", errors);
        return ResponseEntity.badRequest().body(problem);
    }

    @ExceptionHandler(EventNotFoundException.class)
    public ProblemDetail handleNotFound(EventNotFoundException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problem.setTitle("Not Found");
        problem.setProperty("timestamp", Instant.now());
        problem.setProperty("traceId", MDC.get("traceId"));
        return problem;
    }
}