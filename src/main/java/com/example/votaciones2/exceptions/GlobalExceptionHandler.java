package com.example.votaciones2.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<?> handleModelNotFoundException(ModelNotFoundException e){
        String errorMsg = e.getMessage();
        return ResponseEntity.status(404).body(errorMsg);
    }
}
