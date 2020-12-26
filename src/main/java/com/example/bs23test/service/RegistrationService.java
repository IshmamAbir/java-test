package com.example.bs23test.service;

import com.example.bs23test.Repository.RoleRepository;
import com.example.bs23test.Repository.UserRepository;
import com.example.bs23test.dto.UserDto;
import com.example.bs23test.entity.Role;
import com.example.bs23test.entity.User;
import com.example.bs23test.exception.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {
    private final PasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public RegistrationService(PasswordEncoder bCryptPasswordEncoder,
                      UserRepository userRepository,
                      RoleRepository roleRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public void saveUser( UserDto userDto){

        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        List<Role> roleList = roleRepository.findAll();
        user.setRole(roleList.get(0));
        System.out.println(userRepository.existsByUsername(user.getUsername()));
        System.out.println(userRepository.existsByEmail(user.getEmail()));
        String passTemp = bCryptPasswordEncoder.encode(userDto.getPassword());
        if(( (userRepository.existsByUsername(user.getUsername())) || (userRepository.existsByEmail(user.getEmail())) )){
            throw new ResourceNotFoundException("Username and Email Alrady Exist.");
        }

        else {
            user.setPassword(passTemp);
            userRepository.save(user);
        }
    }
}
