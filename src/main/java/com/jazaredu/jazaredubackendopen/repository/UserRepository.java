package com.jazaredu.jazaredubackendopen.repository;

import com.jazaredu.jazaredubackendopen.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserProfile, Long> {

    Optional<UserProfile> findByUsername(String username);
}
