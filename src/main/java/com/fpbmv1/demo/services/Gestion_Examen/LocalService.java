package com.fpbmv1.demo.services.Gestion_Examen;

import com.fpbmv1.demo.entites.Etudiant;
import com.fpbmv1.demo.entites.Module;
import com.fpbmv1.demo.entites.Salle;
import com.fpbmv1.demo.repository.EtudiantRepository;
import com.fpbmv1.demo.repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocalService {

    @Autowired
    private SalleRepository salleRepository;
    private EtudiantRepository etudiantRepository;
    @Autowired

    private SurveillantService surveillantService;

    public List<Salle> getAllSalles() {
        return salleRepository.findAll();
    }

    public Salle getSalleById(int id) {

        return salleRepository.findById(id).get();
    }


    public Etudiant getEtudiantById(int id) {

        return etudiantRepository.findById(id).get();
    }

    public List<Etudiant> findAllEtudiantByFiliere() {

        var etudiants = (List<Etudiant>) salleRepository.findAllEtudiantss();
        return etudiants;
    }

}