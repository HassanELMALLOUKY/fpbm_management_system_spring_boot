package com.fpbmv1.demo.services.Gestion_Examen;

import com.fpbmv1.demo.entites.Professeur;
import com.fpbmv1.demo.entites.Salle;
import com.fpbmv1.demo.entites.Surveillant;
import com.fpbmv1.demo.models.SurveillantsNameModel;
import com.fpbmv1.demo.repository.SurveillantRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Surveillant> getSurveillantNames(){
        List<Surveillant> surveillants=new ArrayList<>();
        List<Object[]> result=surveillantRepository.getSurveillantNames();
        for (Object o[] : result){
            Surveillant s=(Surveillant) o[0];
            Professeur p=(Professeur) o[1];
            s.setNom(p.getNom());
            s.setPrenom(p.getPrenom());
            surveillants.add(s);
        }
            return surveillants;
    }
    public List<Surveillant> getSurveillantsgetDisponibleSurveillants() {
        return surveillantRepository.getAllByDisponibleIsTrue();
    }
    public  void updateSurveillants(Surveillant surveillant, int id) {
        Surveillant surveillant1=surveillantRepository.findById(id).get();
        surveillant1.setNom(surveillant.getNom());
        surveillant1.setPrenom(surveillant.getPrenom());
        surveillant1.setDisponible(surveillant.isDisponible());
        surveillantRepository.save(surveillant1);
    }
}
