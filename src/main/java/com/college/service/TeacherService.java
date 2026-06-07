package com.college.service;

import com.college.dto.TeacherDTO;

import org.springframework.data.domain.Page;

public interface TeacherService {

    TeacherDTO createTeacher(TeacherDTO dto);

    TeacherDTO getTeacherById(Long teacherId);

    Page<TeacherDTO> getAllTeachers(int page, int size);

    TeacherDTO updateTeacher(Long teacherId, TeacherDTO dto);

    void deleteTeacher(Long teacherId);

    Page<TeacherDTO> searchTeachers(String keyword, int page, int size);
}