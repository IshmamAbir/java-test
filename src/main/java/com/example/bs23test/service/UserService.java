package com.example.bs23test.service;

import com.example.bs23test.Repository.UserRepository;
import com.example.bs23test.entity.User;
import com.example.bs23test.exception.ResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = (User) userRepository.findByUsername(username).orElseThrow(() ->
                new ResourceNotFoundException("User with this username does not exist"));
        return user;
    }
}
