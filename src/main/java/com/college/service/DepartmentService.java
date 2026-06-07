package com.college.service;

import com.college.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {

    DepartmentDTO createDepartment(
            DepartmentDTO dto);

    DepartmentDTO getDepartmentById(
            Long departmentId);

    List<DepartmentDTO>
    getAllDepartments();

    DepartmentDTO updateDepartment(
            Long departmentId,
            DepartmentDTO dto);

    void deleteDepartment(
            Long departmentId);
}