package com.project.course_reg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.course_reg.entity.Instructor;
import com.project.course_reg.repository.InstructorRepository;

@Service
public class InstructorService {
    private final InstructorRepository instructorRepository;

    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    public Instructor getInstructorById(Long id) {
        return instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No Instructor with id: " + id));
    }

    public Instructor createInstructor(Instructor instructor) {
        if (instructorRepository.existsByEmail(instructor.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        return instructorRepository.save(instructor);
    }

    public void deleteInstructor(Long id) {
        if (!instructorRepository.existsById(id)) {
            throw new RuntimeException("No Instructor with id: " + id);
        }
        instructorRepository.deleteById(id);
    }

}
