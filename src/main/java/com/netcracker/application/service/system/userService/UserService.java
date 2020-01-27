package com.netcracker.application.service.system.userService;

import com.netcracker.application.model.security.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);
    List<User> getAllUsers();
    List<User> getUsersWithRole(String role);
    User findUserByUsername(String username);
}