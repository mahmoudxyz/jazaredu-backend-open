package com.jazaredu.jazaredubackendopen.repository;


import com.jazaredu.jazaredubackendopen.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {
}
