package com.college.repository;

import com.college.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {


    Page<Teacher>
    findByFirstNameContainingIgnoreCase(String keyword, Pageable pageable);

    boolean existsByEmail(String email);
}
