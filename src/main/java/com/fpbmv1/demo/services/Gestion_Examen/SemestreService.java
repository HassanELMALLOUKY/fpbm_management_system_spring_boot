package com.fpbmv1.demo.services.Gestion_Examen;

import com.fpbmv1.demo.entites.Filiere;
import com.fpbmv1.demo.entites.Semestre;
import com.fpbmv1.demo.repository.FiliereRepository;
import com.fpbmv1.demo.repository.SemestreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
class SemestreService {
    @Autowired
    private SemestreRepository semestreRepository;

    public Semestre getFiliere(int id) {
        return semestreRepository.findById(id).orElse(null);
    }

    public List<Semestre> getAllFiliere() {
        return semestreRepository.findAll();
    }

    public Semestre getFiliereByName(String s) {
        return semestreRepository.findByName(s);
    }
}

