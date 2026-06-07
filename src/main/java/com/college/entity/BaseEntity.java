package com.college.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter

@MappedSuperclass
@EntityListeners(AutoCloseable.class)
public class BaseEntity {
    @CreatedDate

    @Column(name ="created_at",
            updatable = false
    )
    private LocalDateTime createAt;

    @LastModifiedDate
    @Column(name ="updated")
    private LocalDateTime updatedAt;
}
