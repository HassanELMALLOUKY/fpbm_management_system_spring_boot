package com.fpbmv1.demo.services.Gestion_Examen;

import com.fpbmv1.demo.repository.EtudiantRepository;
import com.fpbmv1.demo.entites.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService {
    @Autowired
    private EtudiantRepository etudiantRepository;

    public List<Etudiant> getAllStudents() {
        return etudiantRepository.findAll();
    }

    public Etudiant getEtudiantById(int id) {

        return etudiantRepository.findById(id).get();
    }

    public Etudiant saveEtudiant(Etudiant etudiant) {

        return etudiantRepository.save(etudiant);
    }

    public void deleteEtudiant(Integer id) {
        etudiantRepository.deleteById(id);

    }

    public void deleteAll() {
        etudiantRepository.deleteAll();
    }

    public void saveAll(List<Etudiant> etudiants) {
        etudiantRepository.saveAll(etudiants);
    }

    public List<Etudiant> getEtudiantsByFiliere(String f, String s, String m) {
        return etudiantRepository.getEtudiantsByFiliere(f, s, m);
    }
    public void updateEtudient(Etudiant etudiant,Long id) {
        etudiant.setId(Math.toIntExact(id));
        etudiantRepository.save(etudiant);
        //etudiantRepository.saveAll(etudiants);
    }


}
