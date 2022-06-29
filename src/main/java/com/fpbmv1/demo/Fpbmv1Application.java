package com.fpbmv1.demo;
import com.fpbmv1.demo.entites.Etudiant;
import com.fpbmv1.demo.services.Gestion_Examen.EtudiantService;
import com.fpbmv1.demo.services.Gestion_Examen.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class Fpbmv1Application {

    public static void main(String[] args) {
        SpringApplication.run(Fpbmv1Application.class, args);
    }

    @Autowired
    private EtudiantService etudiantService;
    @Autowired
    private FiliereService filiereService;
}
