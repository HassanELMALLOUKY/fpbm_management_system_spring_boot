package com.fpbmv1.demo.services.Gestion_Examen;

import com.fpbmv1.demo.entites.Surveillant;
import com.fpbmv1.demo.repository.SurveillantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SurveillantService {

    @Autowired
    private SurveillantRepository surveillantRepository;


    public List<Surveillant> getAllSurveillants() {
        return surveillantRepository.findAll();
    }

    public Surveillant getSurveillantById(int id) {

        return surveillantRepository.findById(id).get();
    }

    public Surveillant saveSurveillant(Surveillant professeur) {

        return surveillantRepository.save(professeur);
    }

    public void deleteSurveillant(Integer id) {
        surveillantRepository.deleteById(id);

    }
    public void deleteAll(){
        surveillantRepository.deleteAll();
    }

    public void saveAll(List<Surveillant> professeurs) {
        surveillantRepository.saveAll(professeurs);
    }
}
