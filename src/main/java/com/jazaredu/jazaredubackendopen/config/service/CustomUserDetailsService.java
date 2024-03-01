package com.jazaredu.jazaredubackendopen.config.service;

import com.jazaredu.jazaredubackendopen.model.SecurityUser;
import com.jazaredu.jazaredubackendopen.model.UserProfile;
import com.jazaredu.jazaredubackendopen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserProfile user = userRepository.findByUsername(username).orElseThrow();

        return new SecurityUser(user);
    }
}