package com.fpbmv1.demo.services.Gestion_Examen;

import com.fpbmv1.demo.entites.Examen;
import com.fpbmv1.demo.repository.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamenService {
    @Autowired
    private ExamenRepository examenRepository;

    public List<Examen> getAllExamen() {
        return examenRepository.findAll();
    }

    public Examen getExamenById(int id) {

        return examenRepository.findById(id).get();
    }

    public Examen saveExamen(Examen professeur) {

        return examenRepository.save(professeur);
    }

    public void deleteExamen(Integer id) {
        examenRepository.deleteById(id);

    }

    public void deleteAll() {
        examenRepository.deleteAll();
    }

    public void saveAll(List<Examen> examens) {
        examenRepository.saveAll(examens);
    }
}
