package com.jazaredu.jazaredubackendopen.repository;

import com.jazaredu.jazaredubackendopen.model.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("SELECT DISTINCT c FROM Course c LEFT JOIN FETCH c.tracks LEFT JOIN FETCH c.topics")
    List<Course> findAllWithTracksAndTopics();
    @Query("SELECT DISTINCT c FROM Course c JOIN FETCH c.tracks t WHERE t.id = :trackId")
    List<Course> findAllCoursesByTrackId(@Param("trackId") Long trackId);

}
