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
    public Ordre getFiliere(long id) {
        return ordreRepository.findById(id).orElse(null);
    }
    public List<Ordre> getAllFiliere(){
        return ordreRepository.findAll();
    }
    public void saveOrdre(Ordre ordre){
        ordreRepository.save(ordre);
    }
    public Ordre getOrdreByEtudiantAndPv(Etudiant etudiant, Pv pv){
        return ordreRepository.findOrdreByEtudiantAndPv(etudiant, pv);
    }

    public List<Ordre> getOrdreList(Etudiant etudiant){
        return  ordreRepository.findOrdresByEtudiant(etudiant);
    }
}

