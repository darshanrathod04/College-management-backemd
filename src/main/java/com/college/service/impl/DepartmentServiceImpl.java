package com.college.service.impl;

import com.college.dto.DepartmentDTO;

import com.college.entity.Department;

import com.college.exception.DuplicateResourceException;

import com.college.exception.ResourceNotFoundException;

import com.college.mapper.CollegeMapper;

import com.college.repository.DepartmentRepository;

import com.college.service.DepartmentService;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

@RequiredArgsConstructor

@Transactional

@Slf4j

public class DepartmentServiceImpl
        implements DepartmentService {

    private final DepartmentRepository
            repository;

    @Override
    public DepartmentDTO createDepartment(
            DepartmentDTO dto){

        if(repository
                .existsByDepartmentName(
                        dto.getDepartmentName())){

            throw new DuplicateResourceException(
                    "Department Already Exists");
        }

        Department department =

                CollegeMapper
                        .convertToDepartmentEntity(
                                dto);

        department =
                repository.save(
                        department);

        return CollegeMapper
                .convertToDepartmentDTO(
                        department);
    }

    @Override
    public DepartmentDTO getDepartmentById(
            Long departmentId){

        Department department =
                repository.findById(
                                departmentId)

                        .orElseThrow(() ->

                                new ResourceNotFoundException(
                                        "Department Not Found"));

        return CollegeMapper
                .convertToDepartmentDTO(
                        department);
    }

    @Override
    public List<DepartmentDTO>
    getAllDepartments(){

        return repository.findAll()

                .stream()

                .map(
                        CollegeMapper::
                                convertToDepartmentDTO
                )

                .toList();
    }

    @Override
    public DepartmentDTO updateDepartment(

            Long departmentId,

            DepartmentDTO dto){

        Department department =
                repository.findById(
                                departmentId)

                        .orElseThrow(() ->

                                new ResourceNotFoundException(
                                        "Department Not Found"));

        department.setDepartmentName(
                dto.getDepartmentName());

        department.setDescription(
                dto.getDescription());

        department =
                repository.save(
                        department);

        return CollegeMapper
                .convertToDepartmentDTO(
                        department);
    }

    @Override
    public void deleteDepartment(
            Long departmentId){

        Department department =
                repository.findById(
                                departmentId)

                        .orElseThrow(() ->

                                new ResourceNotFoundException(
                                        "Department Not Found"));

        repository.delete(
                department);
    }
}