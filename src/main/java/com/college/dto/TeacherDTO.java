package com.college.dto;

import jakarta.validation.constraints.*;

import lombok.*;

@Data

@NoArgsConstructor
@AllArgsConstructor

@Builder

public class TeacherDTO {

    private Long teacherId;

    @NotBlank(
            message =
                    "First Name Required"
    )

    private String firstName;

    @NotBlank(
            message =
                    "Last Name Required"
    )

    private String lastName;

    @Email(
            message =
                    "Invalid Email"
    )

    private String email;

    @NotBlank(
            message =
                    "Specialization Required"
    )

    private String specialization;

    @Positive(
            message =
                    "Salary Must Be Positive"
    )

    private Double salary;

    @NotNull(
            message =
                    "Department ID Required"
    )

    private Long departmentId;
}
