package com.fpbmv1.demo.services.Gestion_Examen;

import com.fpbmv1.demo.entites.Pv;
import com.fpbmv1.demo.models.ExcelPv;
import com.fpbmv1.demo.repository.PvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PvService {
    @Autowired
    private PvRepository pvRepository;

    public List<Pv> getAllPvs() {
        return pvRepository.findAll();
    }

    public Pv getEtudiantById(int id) {

        return pvRepository.findById(id).get();
    }

    public Pv savePv(Pv pv) {

        return pvRepository.save(pv);
    }
    public void savePvs(HashMap<String,List<Pv>> hashMapPvs) {
        for(Map.Entry<String, List<Pv>> hashMapPv : hashMapPvs.entrySet()) {
            List<Pv> pvs = new ArrayList<Pv>();
            pvs=hashMapPv.getValue();
            pvs.forEach(pv -> {
                System.out.println("surveillants: "+pv.getSurveillants());
                pvRepository.save(pv);
            });

        }
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
