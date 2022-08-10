package com.fpbmv1.demo.services.Gestion_Examen;

import com.fpbmv1.demo.entites.Professeur;
import com.fpbmv1.demo.entites.Professeur;
import com.fpbmv1.demo.repository.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesseurService {
    @Autowired
    private ProfesseurRepository professeurRepository;

    public List<Professeur> getAllStudents() {
        return professeurRepository.findAll();
    }

    public Professeur getProfesseurById(int id) {

        return professeurRepository.findById(id).get();
    }

    public Professeur saveProfesseur(Professeur professeur) {

        return professeurRepository.save(professeur);
    }

    public void deleteProfesseur(Integer id) {
        professeurRepository.deleteById(id);

    }

    public void deleteAll() {
        professeurRepository.deleteAll();
    }

    public void saveAll(List<Professeur> professeurs) {
        professeurRepository.saveAll(professeurs);
    }
}
