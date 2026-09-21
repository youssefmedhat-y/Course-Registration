package com.project.course_reg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.course_reg.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByEmail(String email);

    Optional<Student> findByStudentCode(String studentCode);

    boolean existsByEmail(String email);

    boolean existsByStudentCode(String studentCode);

}
