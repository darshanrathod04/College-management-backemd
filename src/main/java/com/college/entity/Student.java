package com.college.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="teachers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "firstName",nullable = false
    )
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String email;

    private Integer age;

    private String mobile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="department_id",nullable = false)
    private Department department;


}
