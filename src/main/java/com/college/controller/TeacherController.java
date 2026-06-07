package com.college.controller;

import com.college.dto.TeacherDTO;
import com.college.response.ApiResponse;
import com.college.service.TeacherService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api/teachers")

@RequiredArgsConstructor

@Tag(
        name = "Teacher APIs",

        description =
                "Operations Related To Teachers"
)

public class TeacherController {

    private final TeacherService service;

    @PostMapping
    public ResponseEntity<ApiResponse<TeacherDTO>>
    createTeacher(@Valid @RequestBody TeacherDTO dto){

        return ResponseEntity.ok(ApiResponse.<TeacherDTO>builder()

                        .success(true)

                        .message("Teacher Created")

                        .data(service.createTeacher(dto))

                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TeacherDTO>>
    getTeacher(@PathVariable Long id){

        return ResponseEntity.ok(ApiResponse.<TeacherDTO>builder()

                        .success(true)

                        .message("Teacher Found")

                        .data(service.getTeacherById(id))

                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<TeacherDTO>>>
    getAllTeachers(@RequestParam(defaultValue="0") int page,
                   @RequestParam(defaultValue="5") int size){

        return ResponseEntity.ok(ApiResponse.<Page<TeacherDTO>>builder()

                        .success(true)

                        .message("Teachers Retrieved")

                        .data(service.getAllTeachers(page,size))

                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<TeacherDTO>>
    updateTeacher(@PathVariable Long id,
                  @RequestBody TeacherDTO dto){

        return ResponseEntity.ok(ApiResponse.<TeacherDTO>builder()

                        .success(true)

                        .message("Teacher Updated")

                        .data(service.updateTeacher(id,dto))

                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>>
    deleteTeacher(@PathVariable Long id){

        service.deleteTeacher(id);

        return ResponseEntity.ok(ApiResponse.<String>builder()

                        .success(true)

                        .message("Teacher Deleted")

                        .data("Deleted")

                        .build()
        );
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<Page<TeacherDTO>>>
    searchTeacher(@RequestParam String keyword,
                  @RequestParam int page,
                  @RequestParam int size){

        return ResponseEntity.ok(ApiResponse.<Page<TeacherDTO>>builder()

                        .success(true)

                        .message("Search Results")

                        .data(service.searchTeachers(keyword, page, size))

                        .build()
        );
    }
}