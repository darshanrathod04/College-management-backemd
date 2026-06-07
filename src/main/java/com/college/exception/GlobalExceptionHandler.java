package com.college.exception;

import org.springframework.http.*;

import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice

public class GlobalExceptionHandler {

    @ExceptionHandler(
            ResourceNotFoundException.class)

    public ResponseEntity<ErrorResponse>
    handleNotFound(
            ResourceNotFoundException ex){

        ErrorResponse response =
                ErrorResponse.builder()

                        .success(false)

                        .message(
                                ex.getMessage())

                        .status(404)

                        .timestamp(
                                LocalDateTime.now())

                        .build();

        return new ResponseEntity<>(
                response,
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(
            DuplicateResourceException.class)

    public ResponseEntity<ErrorResponse>
    handleDuplicate(
            DuplicateResourceException ex){

        ErrorResponse response =
                ErrorResponse.builder()

                        .success(false)

                        .message(
                                ex.getMessage())

                        .status(409)

                        .timestamp(
                                LocalDateTime.now())

                        .build();

        return new ResponseEntity<>(
                response,
                HttpStatus.CONFLICT);
    }

    @ExceptionHandler(
            ValidationException.class)

    public ResponseEntity<ErrorResponse>
    handleValidation(
            ValidationException ex){

        ErrorResponse response =
                ErrorResponse.builder()

                        .success(false)

                        .message(
                                ex.getMessage())

                        .status(400)

                        .timestamp(
                                LocalDateTime.now())

                        .build();

        return new ResponseEntity<>(
                response,
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(
            Exception.class)

    public ResponseEntity<ErrorResponse>
    handleGeneral(
            Exception ex){

        ErrorResponse response =
                ErrorResponse.builder()

                        .success(false)

                        .message(
                                ex.getMessage())

                        .status(500)

                        .timestamp(
                                LocalDateTime.now())

                        .build();

        return new ResponseEntity<>(
                response,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
