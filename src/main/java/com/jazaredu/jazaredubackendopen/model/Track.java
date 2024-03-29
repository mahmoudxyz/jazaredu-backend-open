package com.jazaredu.jazaredubackendopen.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Track {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;

    @ManyToMany(mappedBy = "tracks")
    private Set<Course> courses = new HashSet<>();
}