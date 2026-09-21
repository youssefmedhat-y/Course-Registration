package com.project.course_reg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.course_reg.entity.Course;
import com.project.course_reg.entity.Instructor;
import com.project.course_reg.repository.CourseRepository;
import com.project.course_reg.repository.InstructorRepository;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;

    public CourseService(CourseRepository courseRepository, InstructorRepository instructorRepository) {
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();

    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new RuntimeException("No course with id: " + id));
    }

    public Course createCourse(Course course, Long instructorId) {

        if (courseRepository.existsByCourseCode(course.getCourseCode())) {
            throw new RuntimeException("Course code already exists: " + course.getCourseCode());
        }

        Instructor instructor = instructorRepository
                .findById(instructorId)
                .orElseThrow(() -> new RuntimeException("Instructor not found with id: " + instructorId));

        course.setInstructor(instructor);

        return courseRepository.save(course);
    }

    public List<Course> getCourseByInstructorId(Long instructorId) {
        if (!instructorRepository.existsById(instructorId)) {
            throw new RuntimeException("Instructor not found");
        }
        return courseRepository.findByInstructorId(instructorId);
    }

    public void deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new RuntimeException("No course with id: " + id);
        }
        courseRepository.deleteById(id);
    }
}
