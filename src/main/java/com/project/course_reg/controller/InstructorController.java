package com.project.course_reg.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.course_reg.dto.request.InstructorRequest;
import com.project.course_reg.dto.response.InstructorResponse;
import com.project.course_reg.service.InstructorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public ResponseEntity<List<InstructorResponse>> getAllInstructors() {
        List<InstructorResponse> instructors = instructorService.getAllInstructors();
        return ResponseEntity.ok(instructors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstructorResponse> getInstructorById(@PathVariable Long id) {
        InstructorResponse instructor = instructorService.getInstructorById(id);
        return ResponseEntity.ok(instructor);
    }

    @PostMapping
    public ResponseEntity<InstructorResponse> createInstructor(@Valid @RequestBody InstructorRequest instructor) {
        InstructorResponse createdInstructor = instructorService.createInstructor(instructor);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInstructor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable Long id) {
        instructorService.deleteInstructor(id);
        return ResponseEntity.noContent().build();
    }

}
