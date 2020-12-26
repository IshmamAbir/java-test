package com.example.bs23test.Repository;

import com.example.bs23test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    boolean existsByUsername(String s);

    boolean existsByEmail(String s);

    Optional<UserDetails> findByUsername(String username);
}


