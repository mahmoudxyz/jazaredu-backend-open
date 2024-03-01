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
public class Topic {
    @Id
    @GeneratedValue
    private Long id;
    private String title;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToMany(mappedBy = "topics", fetch = FetchType.EAGER)
    private Set<Course> courses = new HashSet<>();
}
