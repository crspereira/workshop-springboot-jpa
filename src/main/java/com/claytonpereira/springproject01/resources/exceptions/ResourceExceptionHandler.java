package com.claytonpereira.springproject01.resources.exceptions;

import com.claytonpereira.springproject01.services.execeptions.ResourceDataViolationIntegrityException;
import com.claytonpereira.springproject01.services.execeptions.ResourceNotFoundException;
import com.claytonpereira.springproject01.services.execeptions.ServiceEntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice //captura as execeções dos controladores/recursos
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class) //captura a execeção específica
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource Not Found!";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ResourceDataViolationIntegrityException.class) //captura a execeção específica
    public ResponseEntity<StandardError> resourceDataVioltationIntegraty(ResourceDataViolationIntegrityException e, HttpServletRequest request) {
        String error = "DataBase Integrity Violation!";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ServiceEntityNotFoundException.class) //captura a execeção específica
    public ResponseEntity<StandardError> entityNotFound(ServiceEntityNotFoundException e, HttpServletRequest request) {
        String error = "Entity Not Found!";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}