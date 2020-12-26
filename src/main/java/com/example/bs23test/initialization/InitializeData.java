package com.example.bs23test.initialization;

import com.example.bs23test.Repository.LocationRepository;
import com.example.bs23test.Repository.RoleRepository;
import com.example.bs23test.Repository.UserRepository;
import com.example.bs23test.entity.Location;
import com.example.bs23test.entity.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.stream.Stream;

public class InitializeData implements CommandLineRunner {
    private final PasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final LocationRepository locationRepository;

    public InitializeData(PasswordEncoder bCryptPasswordEncoder,
                   UserRepository userRepository,
                   RoleRepository roleRepository,
                   LocationRepository locationRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.locationRepository=locationRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Location location1=new Location();
        location1.setLocation("Banderban");
        locationRepository.save(location1);
        Location location2=new Location();
        location2.setLocation("Dhaka");
        locationRepository.save(location2);
        Location location3=new Location();
        location3.setLocation("Chittagong");
        locationRepository.save(location3);

        Stream.of("ROLE_ADMIN", "ROLE_USER", "ROLE_HR")
                .filter(s -> !roleRepository.existsByAuthority(s))
                .map(Role::new)
                .map(roleRepository::save)
                .forEach(role -> {
                    System.out.println(role.getId());
                });

    }
}
