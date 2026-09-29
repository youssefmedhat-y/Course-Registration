package com.project.course_reg.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.course_reg.dto.request.EnrollmentRequest;
import com.project.course_reg.dto.response.EnrollmentResponse;
import com.project.course_reg.service.EnrollmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    public ResponseEntity<EnrollmentResponse> enrollStudent(@Valid @RequestBody EnrollmentRequest request) {

        EnrollmentResponse enrollment = enrollmentService.enrollStudent(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(enrollment);
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<EnrollmentResponse> cancelEnrollment(@PathVariable Long id) {
        EnrollmentResponse canceledEnrollment = enrollmentService.cancelEnrollment(id);
        return ResponseEntity.ok(canceledEnrollment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentResponse> getEnrollmentById(@PathVariable Long id) {
        EnrollmentResponse enrollment = enrollmentService.getEnrollmentById(id);
        return ResponseEntity.ok(enrollment);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<EnrollmentResponse>> getEnrollmentsByStudent(@PathVariable Long studentId) {
        List<EnrollmentResponse> enrollments = enrollmentService.getEnrollmentsByStudentId(studentId);
        return ResponseEntity.ok(enrollments);
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<EnrollmentResponse>> getEnrollmentsByCourse(@PathVariable Long courseId) {
        List<EnrollmentResponse> enrollments = enrollmentService.getEnrollmentsByCourseId(courseId);
        return ResponseEntity.ok(enrollments);
    }

}
