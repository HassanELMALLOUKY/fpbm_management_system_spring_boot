package com.fpbmv1.demo.services.Gestion_Examen;

import com.fpbmv1.demo.entites.Module;
import com.fpbmv1.demo.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
class ModuleService {
    @Autowired
    private ModuleRepository moduleRepository;
    public Module getFiliere(int id) {
        return moduleRepository.findById(id).orElse(null);
    }
    public List<Module> getAllFiliere(){
        return moduleRepository.findAll();
    }
    public Module getFiliereByName(String s){
        return moduleRepository.findByName(s);
    }
}

