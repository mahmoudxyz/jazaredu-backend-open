package com.jazaredu.jazaredubackendopen.controllers;

import com.jazaredu.jazaredubackendopen.model.Track;
import com.jazaredu.jazaredubackendopen.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Controller
@CrossOrigin
public class TrackController {

    @Autowired
    TrackRepository trackRepository;

    @QueryMapping
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }
}
