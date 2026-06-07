package com.college.service.impl;

import com.college.dto.StudentDTO;

import com.college.entity.Department;
import com.college.entity.Student;

import com.college.exception.DuplicateResourceException;
import com.college.exception.ResourceNotFoundException;

import com.college.mapper.CollegeMapper;

import com.college.repository.DepartmentRepository;
import com.college.repository.StudentRepository;

import com.college.service.StudentService;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.*;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Service

@RequiredArgsConstructor

@Transactional

@Slf4j

public class StudentServiceImpl
        implements StudentService {

    private final StudentRepository
            studentRepository;

    private final DepartmentRepository
            departmentRepository;

    @Override
    public StudentDTO createStudent(
            StudentDTO dto) {

        log.info(
                "Creating Student {}",
                dto.getFirstName());

        if(studentRepository.existsByEmail(
                dto.getEmail())){

            throw new DuplicateResourceException(
                    "Email Already Exists");
        }

        Department department =
                departmentRepository.findById(
                                dto.getDepartmentId())

                        .orElseThrow(() ->

                                new ResourceNotFoundException(
                                        "Department Not Found"));

        Student student =
                CollegeMapper
                        .convertToStudentEntity(
                                dto,
                                department);

        student =
                studentRepository.save(
                        student);

        log.info(
                "Student Created Successfully");

        return CollegeMapper
                .convertToStudentDTO(
                        student);
    }

    @Override
    public StudentDTO getStudentById(
            Long studentId) {

        Student student =
                studentRepository.findById(
                                studentId)

                        .orElseThrow(() ->

                                new ResourceNotFoundException(
                                        "Student Not Found"));

        return CollegeMapper
                .convertToStudentDTO(
                        student);
    }

    @Override
    public Page<StudentDTO>
    getAllStudents(

            int page,

            int size){

        Page<Student> students =

                studentRepository.findAll(

                        PageRequest.of(
                                page,
                                size
                        ));

        return students.map(
                CollegeMapper::
                        convertToStudentDTO
        );
    }

    @Override
    public StudentDTO updateStudent(

            Long studentId,

            StudentDTO dto){

        Student student =
                studentRepository.findById(
                                studentId)

                        .orElseThrow(() ->

                                new ResourceNotFoundException(
                                        "Student Not Found"));

        Department department =
                departmentRepository.findById(
                                dto.getDepartmentId())

                        .orElseThrow(() ->

                                new ResourceNotFoundException(
                                        "Department Not Found"));

        student.setFirstName(
                dto.getFirstName());

        student.setLastName(
                dto.getLastName());

        student.setEmail(
                dto.getEmail());

        student.setAge(
                dto.getAge());

        student.setMobile(
                dto.getMobile());

        student.setDepartment(
                department);

        student =
                studentRepository.save(
                        student);

        log.info(
                "Student Updated");

        return CollegeMapper
                .convertToStudentDTO(
                        student);
    }

    @Override
    public void deleteStudent(
            Long studentId){

        Student student =
                studentRepository.findById(
                                studentId)

                        .orElseThrow(() ->

                                new ResourceNotFoundException(
                                        "Student Not Found"));

        studentRepository.delete(
                student);

        log.info(
                "Student Deleted");
    }

    @Override
    public Page<StudentDTO>
    searchStudents(

            String keyword,

            int page,

            int size){

        Page<Student> students =

                studentRepository
                        .findByFirstNameContainingIgnoreCase(

                                keyword,

                                PageRequest.of(
                                        page,
                                        size)
                        );

        return students.map(

                CollegeMapper::
                        convertToStudentDTO
        );
    }
}
