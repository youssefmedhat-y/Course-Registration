package com.project.course_reg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.course_reg.dto.request.CourseRequest;
import com.project.course_reg.dto.response.CourseResponse;
import com.project.course_reg.entity.Course;
import com.project.course_reg.entity.Instructor;
import com.project.course_reg.mapper.CourseMapper;
import com.project.course_reg.repository.CourseRepository;
import com.project.course_reg.repository.InstructorRepository;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;
    private final CourseMapper courseMapper;

    public CourseService(CourseRepository courseRepository, InstructorRepository instructorRepository,
            CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
        this.courseMapper = courseMapper;
    }

    public List<CourseResponse> getAllCourses() {
        return courseRepository.findAll().stream().map(courseMapper::toResponse).toList();

    }

    public CourseResponse getCourseById(Long id) {
        return courseRepository.findById(id).map(courseMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("No course with id: " + id));
    }

    public CourseResponse createCourse(CourseRequest course, Long instructorId) {

        if (courseRepository.existsByCourseCode(course.courseCode())) {
            throw new RuntimeException("Course code already exists: " + course.courseCode());
        }

        Instructor instructor = instructorRepository
                .findById(instructorId)
                .orElseThrow(() -> new RuntimeException("Instructor not found with id: " + instructorId));
        Course courseEntity = courseMapper.toEntity(course, instructor);
        return courseMapper.toResponse(courseRepository.save(courseEntity));
    }

    public List<CourseResponse> getCourseByInstructorId(Long instructorId) {
        if (!instructorRepository.existsById(instructorId)) {
            throw new RuntimeException("Instructor not found");
        }
        return courseRepository.findByInstructorId(instructorId).stream().map(courseMapper::toResponse).toList();
    }

    public void deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new RuntimeException("No course with id: " + id);
        }
        courseRepository.deleteById(id);
    }
}
