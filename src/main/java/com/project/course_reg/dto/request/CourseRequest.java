package com.project.course_reg.dto.request;

public record CourseRequest(String courseCode, String title, String description, int capacity, Long instructorId) {

}
