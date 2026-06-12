package com.college.controller;

import com.college.dto.DepartmentDTO;
import com.college.response.ApiResponse;
import com.college.service.DepartmentService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api/departments")

@RequiredArgsConstructor

@Tag(name = "Department APIs",
        description = "Operations Related To Departments"
)

public class DepartmentController {

    private final DepartmentService service;

    @PostMapping
    public ResponseEntity<ApiResponse<DepartmentDTO>>
    createDepartment(@Valid @RequestBody DepartmentDTO dto){

        return ResponseEntity.ok(ApiResponse.<DepartmentDTO>builder()

                        .success(true)

                        .message("Department Created")

                        .data(service.createDepartment(dto))

                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<DepartmentDTO>>
    getDepartment(@PathVariable Long id){

        return ResponseEntity.ok(ApiResponse.<DepartmentDTO>builder()

                        .success(true)

                        .message("Department Found")

                        .data(service.getDepartmentById(id))

                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<DepartmentDTO>>>
    getAllDepartments(){

        return ResponseEntity.ok(ApiResponse.<List<DepartmentDTO>>builder()

                        .success(true)

                        .message("Departments Retrieved")

                        .data(service.getAllDepartments())

                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<DepartmentDTO>>
    updateDepartment(@PathVariable Long id, @RequestBody DepartmentDTO dto){

        return ResponseEntity.ok(ApiResponse.<DepartmentDTO>builder()

                        .success(true)

                        .message("Department Updated")

                        .data(service.updateDepartment(id, dto))

                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>>
    deleteDepartment(@PathVariable Long id){

        service.deleteDepartment(id);

        return ResponseEntity.ok(ApiResponse.<String>builder()

                        .success(true)

                        .message("Department Deleted")

                        .data("Deleted")

                        .build()
        );
    }
}