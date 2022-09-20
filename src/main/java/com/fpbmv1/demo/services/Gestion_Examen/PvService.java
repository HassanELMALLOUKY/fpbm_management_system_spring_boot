package com.fpbmv1.demo.services.Gestion_Examen;

import com.fpbmv1.demo.dto.PvEtudiant;
import com.fpbmv1.demo.entites.Etudiant;
import com.fpbmv1.demo.entites.Pv;
import com.fpbmv1.demo.repository.PvRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@CrossOrigin("*")
@Transactional
public class PvService {
    private PvRepository pvRepository;
    private EtudiantService etudiantService;
    private OrdreService ordreService;

    public PvService(PvRepository pvRepository, EtudiantService etudiantService,@Lazy OrdreService ordreService) {
        this.pvRepository = pvRepository;
        this.etudiantService = etudiantService;
        this.ordreService = ordreService;
    }

    public List<Pv> getAllPvs() {
        return pvRepository.findAll();
    }

    public Pv getEtudiantById(long id) {

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
                System.out.println("pv"+ pv);
                //System.out.println("surveillants: "+pv.getSurveillants());
                pvRepository.save(pv);
            });

        }
    }

    public void deleteEtudiant(long id) {
        pvRepository.deleteById(id);

    }
    public void deleteAll(){
        pvRepository.deleteAll();
    }

    public void saveAll(List<Pv> pvs) {
        pvRepository.saveAll(pvs);
    }

    public List<PvEtudiant> getPvsWithCINE(String cine) {
        Etudiant e=etudiantService.getEtudiantByCINE(cine);
        List<PvEtudiant> pvEtudiants = new ArrayList<>();
        List<Pv> pvs = new ArrayList<>();
        pvs=pvRepository.getPvsWithCINE(cine);
        pvs.forEach(pv -> {
            pv.setOrdre(ordreService.getOrdreByEtudiantAndPv(e.getId(),pv.getId()).getOrdre());
            PvEtudiant  pvEtudiant = new PvEtudiant(pv.getDate().toString(),pv.getFiliere(),pv.getSemestre(),pv.getModule(),pv.getHeure(),pv.getResponsableModule(),
                    pv.getLocal(),pv.getOrdre()
            );
            //Get ordre

            pvEtudiants.add(pvEtudiant);
        });
        return pvEtudiants;
    }
    public Pv getPvById(long id){
        return  pvRepository.findById(id).get();
    }


}
