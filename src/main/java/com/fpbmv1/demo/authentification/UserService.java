package com.fpbmv1.demo.authentification;


import com.fpbmv1.demo.entites.Role;
import com.fpbmv1.demo.entites.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getAllUsers();
}
