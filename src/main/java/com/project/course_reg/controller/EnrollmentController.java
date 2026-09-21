package com.project.course_reg.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.course_reg.entity.Enrollment;
import com.project.course_reg.service.EnrollmentService;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    public ResponseEntity<Enrollment> enrollStudent(
            @RequestParam Long studentId,
            @RequestParam Long courseId) {
        Enrollment enrollment = enrollmentService.enrollStudent(studentId, courseId);
        return ResponseEntity.status(HttpStatus.CREATED).body(enrollment);
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<Enrollment> cancelEnrollment(@PathVariable Long id) {
        Enrollment canceledEnrollment = enrollmentService.cancelEnrollment(id);
        return ResponseEntity.ok(canceledEnrollment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enrollment> getEnrollmentById(@PathVariable Long id) {
        Enrollment enrollment = enrollmentService.getEnrollmentById(id);
        return ResponseEntity.ok(enrollment);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Enrollment>> getEnrollmentsByStudent(@PathVariable Long studentId) {
        List<Enrollment> enrollments = enrollmentService.getEnrollmentsByStudentId(studentId);
        return ResponseEntity.ok(enrollments);
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Enrollment>> getEnrollmentsByCourse(@PathVariable Long courseId) {
        List<Enrollment> enrollments = enrollmentService.getEnrollmentsByCourseId(courseId);
        return ResponseEntity.ok(enrollments);
    }

}
