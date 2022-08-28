package com.fpbmv1.demo.services.Gestion_Examen;

import com.fpbmv1.demo.entites.Pv;
import com.fpbmv1.demo.repository.PvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PvService {
    @Autowired
    private PvRepository pvRepository;

    public List<Pv> getAllStudents() {
        return pvRepository.findAll();
    }

    public Pv getEtudiantById(int id) {

        return pvRepository.findById(id).get();
    }

    public Pv saveEtudiant(Pv pv) {

        return pvRepository.save(pv);
    }

    public void deleteEtudiant(Integer id) {
        pvRepository.deleteById(id);

    }
    public void deleteAll(){
        pvRepository.deleteAll();
    }

    public void saveAll(List<Pv> pvs) {
        pvRepository.saveAll(pvs);
    }

}
