package com.example.bs23test.Repository;

import com.example.bs23test.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,String> {

    Role findByAuthority(String authority);

    boolean existsByAuthority(String s);
}
