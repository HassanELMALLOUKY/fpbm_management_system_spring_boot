package com.fpbmv1.demo.services.Gestion_Examen;

import com.fpbmv1.demo.entites.Etudiant;
import com.fpbmv1.demo.entites.Ordre;
import com.fpbmv1.demo.entites.Pv;
import com.fpbmv1.demo.repository.OrdreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
class OrdreService {
    @Autowired
    private OrdreRepository ordreRepository;
    @Autowired
    private EtudiantService etudiantService;
    @Autowired
    private PvService pvService;
    public Ordre getFiliere(long id) {
        return ordreRepository.findById(id).orElse(null);
    }
    public List<Ordre> getAllFiliere(){
        return ordreRepository.findAll();
    }
    public void saveOrdre(Ordre ordre){
        ordreRepository.save(ordre);
    }
    public Pv getOrdreByEtudiantAndPv(long etudiant, long idPv){
        Etudiant e=etudiantService.getEtudiantById(etudiant);
        Pv pv=pvService.getPvById(idPv);
        pv.setOrdre(ordreRepository.findOrdreByEtudiantAndPv(e, pv).getOrdre());

        return pv;
    }

    public List<Ordre> getOrdreList(Etudiant etudiant){
        return  ordreRepository.findOrdresByEtudiant(etudiant);
    }

    public List<Etudiant> getOrdreList1(String id){
        pvService.getPvById(Long.parseLong(id)).getEtudiants().forEach(e ->  {
            e.setOrdre(getOrdreByEtudiantAndPv(e.getId(),Long.parseLong(id)).getOrdre());
        });
        return pvService.getPvById(Long.parseLong(id)).getEtudiants();
    }
}

