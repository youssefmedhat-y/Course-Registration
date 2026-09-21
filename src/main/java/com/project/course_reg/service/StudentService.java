package com.project.course_reg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.course_reg.entity.Student;
import com.project.course_reg.repository.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long Id) {
        return studentRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + Id));
    }

    public Student createStudent(Student student) {
        if (studentRepository.existsByEmail(student.getEmail())) {
            throw new RuntimeException("Email already in use");
        }
        if (studentRepository.existsByStudentCode(student.getStudentCode())) {
            throw new RuntimeException("Student code already in use");
        }
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }
}
