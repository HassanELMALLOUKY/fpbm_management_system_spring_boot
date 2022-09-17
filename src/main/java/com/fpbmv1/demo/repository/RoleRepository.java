package com.fpbmv1.demo.repository;

import com.fpbmv1.demo.entites.Role;
import com.fpbmv1.demo.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getRoleByRole(String role);
}
