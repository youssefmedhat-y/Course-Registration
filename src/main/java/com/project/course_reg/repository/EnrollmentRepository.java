package com.project.course_reg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.course_reg.entity.Enrollment;
import com.project.course_reg.entity.EnrollmentStatus;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByStudentId(Long studentId);

    List<Enrollment> findByCourseId(Long courseId);

    boolean existsByStudentIdAndCourseId(Long studentId, Long courseId);

    long countByCourseIdAndStatus(Long courseId, EnrollmentStatus status);

}
