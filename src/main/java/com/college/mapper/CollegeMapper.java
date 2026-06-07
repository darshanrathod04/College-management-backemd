package com.college.mapper;

import com.college.dto.DepartmentDTO;
import com.college.dto.StudentDTO;
import com.college.dto.TeacherDTO;

import com.college.entity.Department;
import com.college.entity.Student;
import com.college.entity.Teacher;

public class CollegeMapper {

    private CollegeMapper() {
    }


    public static StudentDTO
    convertToStudentDTO(
            Student student){

        return StudentDTO.builder()
                .studentId(student.getStudentId())

                .firstName(student.getFirstName())

                .lastName(student.getLastName())

                .email(student.getEmail())

                .age(student.getAge())

                .mobile(student.getMobile())

                .departmentId(student.getDepartment().getDepartmentId())

                .build();
    }


    public static Student
    convertToStudentEntity(StudentDTO dto, Department department){

        return Student.builder()

                .studentId(dto.getStudentId())

                .firstName(dto.getFirstName())

                .lastName(dto.getLastName())

                .email(dto.getEmail())

                .age(dto.getAge())

                .mobile(dto.getMobile())

                .department(department)

                .build();
    }


    public static TeacherDTO
    convertToTeacherDTO(Teacher teacher){

        return TeacherDTO.builder()

                .teacherId(teacher.getTeacherId())

                .firstName(teacher.getFirstName())

                .lastName(teacher.getLastName())

                .email(teacher.getEmail())

                .specialization(teacher.getSpecialization())

                .salary(teacher.getSallary())

                .departmentId(teacher.getDepartment().getDepartmentId())

                .build();
    }


    public static Teacher
    convertToTeacherEntity(TeacherDTO dto, Department department){

        return Teacher.builder()

                .teacherId(dto.getTeacherId())

                .firstName(dto.getFirstName())

                .lastName(dto.getLastName())

                .email(dto.getEmail())

                .specialization(dto.getSpecialization())

                .sallary(dto.getSalary())

                .department(department)

                .build();
    }


    public static DepartmentDTO
    convertToDepartmentDTO(Department department){

        return DepartmentDTO.builder()

                .departmentId(department.getDepartmentId())

                .departmentName(department.getDepartmentName())

                .description(department.getDescription())

                .build();
    }



    public static Department
    convertToDepartmentEntity(DepartmentDTO dto){

        return Department.builder()

                .departmentId(dto.getDepartmentId())

                .departmentName(dto.getDepartmentName())

                .description(dto.getDescription())

                .build();
    }
}