package com.project.course_reg.mapper;

import org.springframework.stereotype.Component;

import com.project.course_reg.dto.request.InstructorRequest;
import com.project.course_reg.dto.response.InstructorResponse;
import com.project.course_reg.entity.Instructor;

@Component
public class InstructorMapper {
    public Instructor toEntity(InstructorRequest instructorRequest) {
        return new Instructor(instructorRequest.firstName(),
                instructorRequest.lastName(),
                instructorRequest.email(),
                instructorRequest.department());
    }

    public InstructorResponse toResponse(Instructor instructor) {
        if (instructor == null)
            return null;
        return new InstructorResponse(instructor.getId(), instructor.getFirstName(), instructor.getLastName(),
                instructor.getEmail(), instructor.getDepartment());
    }
}
