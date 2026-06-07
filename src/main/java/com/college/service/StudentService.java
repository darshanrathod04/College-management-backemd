package com.college.service;

import com.college.dto.StudentDTO;

import org.springframework.data.domain.Page;

public interface StudentService {

    StudentDTO createStudent(StudentDTO dto);

    StudentDTO getStudentById(Long studentId);

    Page<StudentDTO> getAllStudents(int page, int size);

    StudentDTO updateStudent(Long studentId, StudentDTO dto);

    void deleteStudent(Long studentId);

    Page<StudentDTO> searchStudents(String keyword, int page, int size);
}