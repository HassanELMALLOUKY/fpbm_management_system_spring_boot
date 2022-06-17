package com.fpbmv1.demo.services.Gestion_Examen;

import com.fpbmv1.demo.entites.Etudiant;
import com.fpbmv1.demo.entites.Surveillant;
import com.fpbmv1.demo.repository.EtudiantRepository;
import com.fpbmv1.demo.repository.SurveillantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveillantService {
    @Autowired
    private SurveillantRepository surveillantRepository;
    public List<Surveillant> getAllSuveillants() {
        return surveillantRepository.findAll();
    }
    public Surveillant getSurveillantById(int id) {

        return surveillantRepository.findById(id).get();
    }
    public Surveillant saveSurveillant(Surveillant surveillant) {

        return surveillantRepository.save(surveillant);
    }

    public void deleteSurveillant(Integer id) {
        surveillantRepository.deleteById(id);

    }
    public void deleteAll(){
        surveillantRepository.deleteAll();
    }

    public void saveAll(List<Surveillant> surveillants) {
        surveillantRepository.saveAll(surveillants);
    }
}
