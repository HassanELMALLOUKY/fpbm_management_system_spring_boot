package com.fpbmv1.demo;
import com.fpbmv1.demo.entites.Etudiant;
import com.fpbmv1.demo.entites.Role;
import com.fpbmv1.demo.entites.User;
import com.fpbmv1.demo.repository.RoleRepository;
import com.fpbmv1.demo.services.Gestion_Examen.EtudiantService;
import com.fpbmv1.demo.services.Gestion_Examen.FiliereService;
import com.fpbmv1.demo.services.Gestion_Examen.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Fpbmv1Application implements CommandLineRunner {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(Fpbmv1Application.class, args);
    }

    @Bean
    PasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {
        /*Role a = roleRepository.save(new Role(1L,"admin"));
        Role p = roleRepository.save(new Role(2L,"teacher"));
        Role e = roleRepository.save(new Role(3L,"student"));

        List<Role> professeurRole = new ArrayList<>();
        List<Role> adminRole = new ArrayList<>();
        List<Role> etudientRole = new ArrayList<>();
        professeurRole.add(p);
        adminRole.add(a);
        etudientRole.add(e);
        User user1 = new User(1,"Admin",getBCPE().encode("123"),adminRole);
        User user2 = new User(2,"teacher",getBCPE().encode("123"),professeurRole);
        User user3 = new User(3,"student",getBCPE().encode("123"),etudientRole);
        userService.saveUser(user1);
        userService.saveUser(user2);
        userService.saveUser(user3);*/
    }
}
