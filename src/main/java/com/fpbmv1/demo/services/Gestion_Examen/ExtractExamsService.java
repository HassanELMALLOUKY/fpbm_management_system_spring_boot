package com.fpbmv1.demo.services.Gestion_Examen;

import com.fpbmv1.demo.entites.ExtractExams;
import com.fpbmv1.demo.repository.ExtractExamsRepository;
import org.springframework.stereotype.Service;


public class ExtractExamsService {
    private ExtractExamsRepository extractExamsRepository;

    public ExtractExamsService(ExtractExamsRepository extractExamsRepository) {
        this.extractExamsRepository = extractExamsRepository;
    }
    public void saveExtractExams(ExtractExams extractExams){
        extractExamsRepository.save(extractExams);
    }
}
