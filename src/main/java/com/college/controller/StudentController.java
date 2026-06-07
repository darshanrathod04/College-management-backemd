package com.college.controller;

import com.college.dto.StudentDTO;
import com.college.response.ApiResponse;
import com.college.service.StudentService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.tags.Tag;

import io.swagger.v3.oas.annotations.Operation;

@Tag(
        name = "Student APIs",
        description =
                "Operations Related To Students"
)
@RestController

@RequestMapping("/api/students")

@RequiredArgsConstructor

public class StudentController {

    private final StudentService service;

    @PostMapping

    public ResponseEntity<ApiResponse<StudentDTO>>
    createStudent(@Valid @RequestBody StudentDTO dto){

        StudentDTO student = service.createStudent(dto);

        return ResponseEntity.ok(ApiResponse.<StudentDTO>builder()

                        .success(true)

                        .message("Student Created Successfully")

                        .data(student)

                        .build()
        );
    }

    @GetMapping("/{id}")

    @Operation(

            summary =
                    "Get Student By ID",

            description =
                    "Fetch Student Using ID"
    )
    public ResponseEntity<ApiResponse<StudentDTO>>
    getStudentById(@PathVariable Long id){

        StudentDTO student = service.getStudentById(id);

        return ResponseEntity.ok(ApiResponse.<StudentDTO>builder()

                        .success(true)

                        .message("Student Found")

                        .data(student)

                        .build()
        );
    }

    @GetMapping

    public ResponseEntity<ApiResponse<Page<StudentDTO>>>
    getAllStudents(@RequestParam(defaultValue = "0") int page,
                   @RequestParam(defaultValue = "5") int size){

        Page<StudentDTO> students =

                service.getAllStudents(page, size);

        return ResponseEntity.ok(ApiResponse.<Page<StudentDTO>>builder()

                        .success(true)

                        .message("Students Retrieved")

                        .data(students)

                        .build()
        );
    }

    @PutMapping("/{id}")

    public ResponseEntity<ApiResponse<StudentDTO>>
    updateStudent(@PathVariable Long id,
                  @Valid
                  @RequestBody StudentDTO dto){

        StudentDTO student = service.updateStudent(id, dto);

        return ResponseEntity.ok(ApiResponse.<StudentDTO>builder()

                        .success(true)

                        .message("Student Updated")

                        .data(student)

                        .build()
        );
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<ApiResponse<String>>
    deleteStudent(@PathVariable Long id){

        service.deleteStudent(id);

        return ResponseEntity.ok(ApiResponse.<String>builder()

                        .success(true)

                        .message("Student Deleted")

                        .data("Deleted Successfully")

                        .build()
        );
    }

    @GetMapping("/search")

    @Operation(

            summary =
                    "Search Students",

            description =
                    "Search Students By First Name"
    )
    public ResponseEntity<ApiResponse<Page<StudentDTO>>>
    searchStudents(@RequestParam String keyword,
                   @RequestParam int page,
                   @RequestParam int size){

        Page<StudentDTO> students = service.searchStudents(
                        keyword, page, size);

        return ResponseEntity.ok(ApiResponse.<Page<StudentDTO>>builder()

                        .success(true)

                        .message("Search Results")

                        .data(students)

                        .build()
        );
    }
}