package com.fpbmv1.demo.services;

import com.fpbmv1.demo.entites.Semestre;
import com.fpbmv1.demo.repository.SemestreRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@NoArgsConstructor
@Service
public class SemestreService {
    private SemestreRepository semestreRepository;

    public SemestreService(SemestreRepository semestreRepository) {
        this.semestreRepository = semestreRepository;
    }

    public Semestre getSemestre(int id) {
        return semestreRepository.findById(id).orElse(null);
    }
    public List<Semestre> getAllSemestre(){
        return semestreRepository.findAll();
    }
    public Semestre getByName(String s){
        return semestreRepository.findByName(s);
    }
}
