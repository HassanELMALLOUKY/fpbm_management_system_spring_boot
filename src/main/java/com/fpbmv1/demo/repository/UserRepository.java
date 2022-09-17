package com.fpbmv1.demo.repository;

import com.fpbmv1.demo.entites.Surveillant;
import com.fpbmv1.demo.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByUsername(String username);
}
