package com.project.course_reg.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.course_reg.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> findByCourseCode(String courseCode);

    boolean existsByCourseCode(String courseCode);

    List<Course> findByInstructorId(Long instructorId);

}
