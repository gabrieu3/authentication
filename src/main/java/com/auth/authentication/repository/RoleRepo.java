package com.auth.authentication.repository;

import com.auth.authentication.domain.Role;
import com.auth.authentication.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
