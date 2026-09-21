package com.project.course_reg.dto.response;

import java.time.LocalDateTime;

import com.project.course_reg.entity.EnrollmentStatus;

public record EnrollmentResponse(
        Long id,
        Long studentId,
        String studentName,
        Long courseId,
        String courseTitle,
        LocalDateTime enrollmentDate,
        EnrollmentStatus status) {

}
