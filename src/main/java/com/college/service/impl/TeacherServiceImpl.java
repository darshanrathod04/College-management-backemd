package com.college.service.impl;

import com.college.dto.TeacherDTO;
import com.college.entity.Department;
import com.college.entity.Teacher;
import com.college.exception.DuplicateResourceException;
import com.college.exception.ResourceNotFoundException;
import com.college.mapper.CollegeMapper;
import com.college.repository.DepartmentRepository;
import com.college.repository.TeacherRepository;
import com.college.service.TeacherService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    private final DepartmentRepository departmentRepository;

    @Override
    public TeacherDTO createTeacher(TeacherDTO dto) {

        log.info("Creating Teacher : {}", dto.getFirstName());

        // Check Duplicate Email

        if (teacherRepository.existsByEmail(dto.getEmail())) {

            throw new DuplicateResourceException(
                    "Teacher Email Already Exists");
        }

        // Check Department

        Department department =
                departmentRepository.findById(
                                dto.getDepartmentId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Department Not Found"));

        // DTO -> Entity

        Teacher teacher =
                CollegeMapper.convertToTeacherEntity(
                        dto,
                        department);

        // Save

        teacher = teacherRepository.save(teacher);

        log.info("Teacher Created Successfully");

        // Entity -> DTO

        return CollegeMapper.convertToTeacherDTO(
                teacher);
    }

    @Override
    public TeacherDTO getTeacherById(Long teacherId) {

        Teacher teacher =
                teacherRepository.findById(
                                teacherId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Teacher Not Found"));

        return CollegeMapper.convertToTeacherDTO(
                teacher);
    }

    @Override
    public Page<TeacherDTO> getAllTeachers(
            int page,
            int size) {

        Page<Teacher> teachers =
                teacherRepository.findAll(
                        PageRequest.of(
                                page,
                                size));

        return teachers.map(
                CollegeMapper::convertToTeacherDTO);
    }

    @Override
    public TeacherDTO updateTeacher(
            Long teacherId,
            TeacherDTO dto) {

        Teacher teacher =
                teacherRepository.findById(
                                teacherId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Teacher Not Found"));

        Department department =
                departmentRepository.findById(
                                dto.getDepartmentId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Department Not Found"));

        teacher.setFirstName(
                dto.getFirstName());

        teacher.setLastName(
                dto.getLastName());

        teacher.setEmail(
                dto.getEmail());

        teacher.setSpecialization(
                dto.getSpecialization());

        teacher.setSallary(
                dto.getSalary());

        teacher.setDepartment(
                department);

        teacher =
                teacherRepository.save(
                        teacher);

        log.info(
                "Teacher Updated Successfully");

        return CollegeMapper.convertToTeacherDTO(
                teacher);
    }

    @Override
    public void deleteTeacher(
            Long teacherId) {

        Teacher teacher =
                teacherRepository.findById(
                                teacherId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Teacher Not Found"));

        teacherRepository.delete(
                teacher);

        log.info(
                "Teacher Deleted Successfully");
    }

    @Override
    public Page<TeacherDTO> searchTeachers(
            String keyword,
            int page,
            int size) {

        Page<Teacher> teachers =
                teacherRepository
                        .findByFirstNameContainingIgnoreCase(
                                keyword,
                                PageRequest.of(
                                        page,
                                        size));

        return teachers.map(
                CollegeMapper::convertToTeacherDTO);
    }
}