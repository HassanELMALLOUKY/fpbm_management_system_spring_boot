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
    public Ordre getOrdreByEtudiantAndPv(long etudiant, long idPv){
        Etudiant e=etudiantService.getEtudiantById(etudiant);
        Pv pv=pvService.getPvById(idPv);

        return ordreRepository.findOrdreByEtudiantAndPv(e, pv);
    }

    public List<Ordre> getOrdreList(Etudiant etudiant){
        return  ordreRepository.findOrdresByEtudiant(etudiant);
    }
}

