package com.project.course_reg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.course_reg.dto.request.StudentRequest;
import com.project.course_reg.dto.response.StudentResponse;
import com.project.course_reg.entity.Student;
import com.project.course_reg.mapper.StudentMapper;
import com.project.course_reg.repository.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll().stream().map(studentMapper::toResponse).toList();
    }

    public StudentResponse getStudentById(Long Id) {
        return studentMapper.toResponse(studentRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + Id)));
    }

    public StudentResponse createStudent(StudentRequest studentRequest) {
        if (studentRepository.existsByEmail(studentRequest.email())) {
            throw new RuntimeException("Email already in use");
        }
        if (studentRepository.existsByStudentCode(studentRequest.studentCode())) {
            throw new RuntimeException("Student code already in use");
        }
        return studentMapper.toResponse(studentRepository.save(studentMapper.toEntity(studentRequest)));
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }
}
