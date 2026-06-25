package com.example.hyadm.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExists.class)
    public ResponseEntity<String> handleUserAlreadyExistsHandler(UserAlreadyExists ex) {
        return  ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }
    @ExceptionHandler(BadRequest.class)
    public ResponseEntity<String> handleBadRequest(BadRequest ex) {
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> handleInvalidCredentials(InvalidCredentials ex) {
        return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }
}
