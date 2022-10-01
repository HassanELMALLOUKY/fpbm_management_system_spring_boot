package com.fpbmv1.demo.services.Gestion_Examen;

import com.fpbmv1.demo.entites.Salle;
import com.fpbmv1.demo.repository.SalleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SalleService {
    private SalleRepository salleRepository;

    public SalleService(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }

    public List<Salle> getEmptySalles() {

        return salleRepository.getAllByDisponibleIsTrue();
    }

    public Salle getSalleById(int id) {

        return salleRepository.findById(id).get();
    }

    public Salle saveSalle(Salle salle) {

        return salleRepository.save(salle);
    }
    public List<Salle> getAllSalles(){
        return salleRepository.findAll();
    }

    public void deleteSalle(Integer id) {
        salleRepository.deleteById(id);

    }
    public  void updateSalle(Salle salle,int id) {
        Salle s=salleRepository.findById(id).get();
        s.setName(salle.getName());
        s.setCapaciteEtudiant(salle.getCapaciteEtudiant());
        s.setDisponible(salle.isDisponible());
        s.setNombreSurveillant(salle.getNombreSurveillant());
        salleRepository.save(salle);

    }
    public void deleteAll(){
        salleRepository.deleteAll();
    }

    public void saveAll(List<Salle> salles) {
        salleRepository.saveAll(salles);
    }

    public void freeSalle(){
        salleRepository.makeSallesFree();
    }

    public int getNbSalles(){
        return salleRepository.getNombreSalle();
    }
}
