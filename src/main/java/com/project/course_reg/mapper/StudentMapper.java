package com.project.course_reg.mapper;

import org.springframework.stereotype.Component;

import com.project.course_reg.dto.request.StudentRequest;
import com.project.course_reg.dto.response.StudentResponse;
import com.project.course_reg.entity.Student;

@Component
public class StudentMapper {
    public Student toEntity(StudentRequest studentRequest) {
        return new Student(studentRequest.firstName(),
                studentRequest.lastName(),
                studentRequest.email(),
                studentRequest.studentCode());
    }

    public StudentResponse toResponse(Student student) {
        if (student == null)
            return null;
        return new StudentResponse(student.getId(), student.getFirstName(), student.getLastName(), student.getEmail(),
                student.getStudentCode());
    }
}
