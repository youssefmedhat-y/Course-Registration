package com.project.course_reg.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.project.course_reg.dto.response.EnrollmentResponse;
import com.project.course_reg.entity.Course;
import com.project.course_reg.entity.Enrollment;
import com.project.course_reg.entity.EnrollmentStatus;
import com.project.course_reg.entity.Student;

@Component
public class EnrollmentMapper {

    public EnrollmentResponse toResponse(Enrollment enrollment) {
        if (enrollment == null) {
            return null;
        }

        Long studentId = null;
        String studentName = null;
        if (enrollment.getStudent() != null) {
            studentId = enrollment.getStudent().getId();
            studentName = enrollment.getStudent().getFirstName() + " " + enrollment.getStudent().getLastName();
        }

        Long courseId = null;
        String courseTitle = null;
        if (enrollment.getCourse() != null) {
            courseId = enrollment.getCourse().getId();
            courseTitle = enrollment.getCourse().getTitle();
        }

        return new EnrollmentResponse(
                enrollment.getId(),
                studentId,
                studentName,
                courseId,
                courseTitle,
                enrollment.getEnrollmentDate(),
                enrollment.getStatus());
    }

    public Enrollment toEntity(Student student, Course course) {
        return new Enrollment(
                student,
                course,
                LocalDateTime.now(),
                EnrollmentStatus.ENROLLED);
    }
}
