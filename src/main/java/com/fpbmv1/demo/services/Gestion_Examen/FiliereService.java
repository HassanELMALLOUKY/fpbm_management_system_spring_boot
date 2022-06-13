package com.fpbmv1.demo.services.Gestion_Examen;

import com.fpbmv1.demo.entites.Filiere;
import com.fpbmv1.demo.repository.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public
class FiliereService {
    @Autowired
    private FiliereRepository filiereRepository;
    public Filiere getFiliere(int id) {
        return filiereRepository.findById(id).orElse(null);
    }
}

