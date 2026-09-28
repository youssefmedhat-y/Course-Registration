package com.project.course_reg.dto.request;

import jakarta.validation.constraints.NotNull;

public record EnrollmentRequest(
        @NotNull(message = "Student ID is required!") Long studentId,
        @NotNull(message = "Course ID is required!") Long courseId) {

}
