package com.fpbmv1.demo.services.Gestion_Examen;

import com.fpbmv1.demo.entites.User;
import com.fpbmv1.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User loadUserByUsername(String username){
        return userRepository.getUserByUsername(username);
    }
    public void saveUser(User user){
        userRepository.save(user);
    }
}
