package com.college.repository;

import com.college.entity.Student;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository
        extends JpaRepository<Student, Long> {

    Page<Student>
    findByFirstNameContainingIgnoreCase(
            String keyword,
            Pageable pageable
    );

    boolean existsByEmail(String email);
}
