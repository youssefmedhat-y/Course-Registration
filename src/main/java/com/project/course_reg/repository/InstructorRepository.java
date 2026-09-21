package com.project.course_reg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.course_reg.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {

    Optional<Instructor> findByEmail(String email);

    boolean existsByEmail(String email);
}
