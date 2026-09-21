package com.project.course_reg.mapper;

import org.springframework.stereotype.Component;

import com.project.course_reg.dto.request.CourseRequest;
import com.project.course_reg.dto.response.CourseResponse;
import com.project.course_reg.entity.Course;
import com.project.course_reg.entity.Instructor;

@Component
public class CourseMapper {
    public Course toEntity(CourseRequest courseRequest, Instructor instructor) {
        Course course = new Course();
        course.setCourseCode(courseRequest.courseCode());
        course.setTitle(courseRequest.title());
        course.setDescription(courseRequest.description());
        course.setCapacity(courseRequest.capacity());
        course.setInstructor(instructor);
        return course;
    }

    public CourseResponse toResponse(Course course) {
        if (course == null)
            return null;
        return new CourseResponse(
                course.getId(),
                course.getCourseCode(),
                course.getTitle(),
                course.getDescription(),
                course.getCapacity(),
                course.getInstructor().getId(),
                course.getInstructor().getFirstName() + " " + course.getInstructor().getLastName());
    }
}
