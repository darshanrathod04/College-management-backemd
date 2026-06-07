package com.college.exception;

import lombok.*;

import java.time.LocalDateTime;

@Data

@NoArgsConstructor
@AllArgsConstructor

@Builder

public class ErrorResponse {

    private boolean success;

    private String message;

    private Integer status;

    private LocalDateTime timestamp;
}