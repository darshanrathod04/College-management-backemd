package com.college.dto;

import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data

@NoArgsConstructor
@AllArgsConstructor

@Builder

public class StudentDTO {

    private Long studentId;

    @NotBlank(message = "First Name Required")
    @Schema(description = "Student First Name", example = "Darshan")
    private String firstName;

    @NotBlank(message = "Last Name Required")
    private String lastName;

    @Email(message = "Invalid Email Format")
    @NotBlank(message = "Email Required")
    @Schema(description = "Student Email", example = "darshan@gmail.com")
    private String email;

    @Min(value = 18, message = "Age Must Be At Least 18")
    private Integer age;

    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile Number Must Be 10 Digits")
    private String mobile;

    @NotNull(message = "Department ID Required")
    @Schema(description = "Department Identifier", example = "1")
    private Long departmentId;
}
