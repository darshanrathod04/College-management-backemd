package com.college.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String email;

    private String specialization;

    private Double sallary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="department_id")
    private Department department;
}
