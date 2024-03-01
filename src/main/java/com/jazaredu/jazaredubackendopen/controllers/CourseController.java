package com.jazaredu.jazaredubackendopen.controllers;

import com.jazaredu.jazaredubackendopen.model.Course;
import com.jazaredu.jazaredubackendopen.repository.CourseRepository;
import com.jazaredu.jazaredubackendopen.repository.TrackRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.HashSet;
import java.util.Set;

@Controller
public class CourseController {

    private final TrackRepository trackRepository;
    private final CourseRepository courseRepository;

    public CourseController(TrackRepository trackRepository, CourseRepository courseRepository) {
        this.trackRepository = trackRepository;
        this.courseRepository = courseRepository;
    }


    @QueryMapping
    public Set<Course> getAllCoursesByTrackId(@Argument Long trackId) {
        return new HashSet<>(courseRepository.findAllCoursesByTrackId(trackId));
    }

    @QueryMapping
    public Set<Course> getAllCourses() {
        return new HashSet<>(courseRepository.findAll());
    }

    @MutationMapping
    public Course createNewCourse(@Argument Course courseInput) {
        Course course = Course.builder().title(courseInput.getTitle()).description(courseInput.getDescription()).build();
        return courseRepository.save(course);
    }
}
