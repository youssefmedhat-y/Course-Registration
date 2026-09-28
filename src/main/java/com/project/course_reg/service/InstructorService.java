package com.project.course_reg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.course_reg.dto.request.InstructorRequest;
import com.project.course_reg.dto.response.InstructorResponse;
import com.project.course_reg.mapper.InstructorMapper;
import com.project.course_reg.repository.InstructorRepository;

@Service
public class InstructorService {
    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;

    public InstructorService(InstructorRepository instructorRepository, InstructorMapper instructorMapper) {
        this.instructorRepository = instructorRepository;
        this.instructorMapper = instructorMapper;
    }

    public List<InstructorResponse> getAllInstructors() {
        return instructorRepository.findAll().stream()
                .map(instructorMapper::toResponse)
                .toList();
    }

    public InstructorResponse getInstructorById(Long id) {
        return instructorRepository.findById(id)
                .map(instructorMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("No Instructor with id: " + id));
    }

    public InstructorResponse createInstructor(InstructorRequest instructor) {
        if (instructorRepository.existsByEmail(instructor.email())) {
            throw new RuntimeException("Email already exists");
        }
        return instructorMapper.toResponse(instructorRepository.save(instructorMapper.toEntity(instructor)));
    }

    public void deleteInstructor(Long id) {
        if (!instructorRepository.existsById(id)) {
            throw new RuntimeException("No Instructor with id: " + id);
        }
        instructorRepository.deleteById(id);
    }

}
