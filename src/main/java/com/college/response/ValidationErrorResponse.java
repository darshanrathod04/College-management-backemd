package com.college.response;

import lombok.*;

import java.time.LocalDateTime;

import java.util.Map;

@Data

@Builder

@NoArgsConstructor

@AllArgsConstructor

public class ValidationErrorResponse {

    private boolean success;

    private Integer status;

    private LocalDateTime timestamp;

    private Map<String,String> errors;
}
