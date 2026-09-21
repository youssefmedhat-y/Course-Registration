package com.project.course_reg.dto.response;

public record CourseResponse(Long id, String courseCode, String title, String description, int capacity,
        Long instructorId, String instructorName) {

}
