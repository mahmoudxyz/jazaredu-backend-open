package com.jazaredu.jazaredubackendopen.controllers;

import com.jazaredu.jazaredubackendopen.model.*;
import com.jazaredu.jazaredubackendopen.repository.CourseRepository;
import com.jazaredu.jazaredubackendopen.repository.TopicRepository;
import com.jazaredu.jazaredubackendopen.repository.TrackRepository;
import com.jazaredu.jazaredubackendopen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;


import java.util.List;

@Controller
public class TrackController {

    private final TrackRepository trackRepository;
    private final CourseRepository courseRepository;
    private final TopicRepository topicRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public TrackController(TrackRepository trackRepository, CourseRepository courseRepository, TopicRepository topicRepository) {
        this.trackRepository = trackRepository;
        this.courseRepository = courseRepository;
        this.topicRepository = topicRepository;
    }


    @QueryMapping
//    @PreAuthorize("hasRole('ADMIN')")
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }
}
