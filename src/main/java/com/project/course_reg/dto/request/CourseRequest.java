package com.project.course_reg.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CourseRequest(
        @NotBlank(message = "Course code is required!") 
        @Size(max = 20, message = "Course code must be less than 20 characters!") 
        String courseCode, 
        
        @NotBlank(message = "Title is required!") 
        @Size(max = 100, message = "Title must be less than 100 characters!") 
        String title, 
        
        @Size(max = 500, message = "Description must be less than 500 characters!") 
        String description, 
        
        @Min(value = 1, message = "Capacity must be at least 1!") 
        int capacity, 
        
        @NotNull(message = "Instructor ID is required!") 
        Long instructorId) {

}
