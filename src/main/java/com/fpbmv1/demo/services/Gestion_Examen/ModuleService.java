package com.fpbmv1.demo.services.Gestion_Examen;

import com.fpbmv1.demo.entites.Etudiant;
import com.fpbmv1.demo.entites.Module;
import com.fpbmv1.demo.repository.EtudiantRepository;
import com.fpbmv1.demo.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ModuleService {
    @Autowired
    private ModuleRepository moduleRepository;

    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    public Module getModuleById(int id) {

        return moduleRepository.findById(id).get();
    }

    public Module saveModule(Module module) {

        return moduleRepository.save(module);
    }

    public void deleteModule(Integer id) {
        moduleRepository.deleteById(id);

    }
    public void deleteAll(){
        moduleRepository.deleteAll();
    }

    public void saveAll(List<Module> modules) {

        moduleRepository.saveAll(modules);
    }

}
