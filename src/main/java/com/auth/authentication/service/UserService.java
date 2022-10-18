package com.auth.authentication.service;

import com.auth.authentication.domain.Role;
import com.auth.authentication.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String name);
    List<User> getUsers();
}
