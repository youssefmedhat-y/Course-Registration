package com.project.course_reg.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.course_reg.entity.Course;
import com.project.course_reg.entity.Enrollment;
import com.project.course_reg.entity.EnrollmentStatus;
import com.project.course_reg.entity.Student;
import com.project.course_reg.repository.CourseRepository;
import com.project.course_reg.repository.EnrollmentRepository;
import com.project.course_reg.repository.StudentRepository;

@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository, CourseRepository courseRepository,
            StudentRepository studentRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    public Enrollment enrollStudent(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException(
                        "No Student found with id: " + studentId));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException(
                        "No Course found with id: " + courseId));

        if (enrollmentRepository
                .existsByStudentIdAndCourseId(studentId, courseId)) {

            throw new RuntimeException(
                    "Student already enrolled in this course");
        }

        long activeEnrollments = enrollmentRepository.countByCourseIdAndStatus(
                courseId,
                EnrollmentStatus.ENROLLED);

        if (activeEnrollments >= course.getCapacity()) {

            throw new RuntimeException(
                    "Course is full. Capacity reached: "
                            + course.getCapacity());
        }

        Enrollment enrollment = new Enrollment();

        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setStatus(EnrollmentStatus.ENROLLED);
        enrollment.setEnrollmentDate(LocalDateTime.now());
        return enrollmentRepository.save(enrollment);
    }

    public Enrollment cancelEnrollment(Long enrollmentId) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new RuntimeException("No enrollment found with this ID :" + enrollmentId));
        enrollment.setStatus(EnrollmentStatus.CANCELLED);
        return enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> getEnrollmentsByStudentId(Long studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    public List<Enrollment> getEnrollmentsByCourseId(Long courseId) {
        if (!courseRepository.existsById(courseId)) {
            throw new RuntimeException("No Course found with this Id" + courseId);
        }
        return enrollmentRepository.findByCourseId(courseId);
    }

    public Enrollment getEnrollmentById(Long enrollmentId) {
        return enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new RuntimeException("No enrollment found with this ID: " + enrollmentId));
    }

}
