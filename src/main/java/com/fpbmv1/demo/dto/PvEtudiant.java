package com.fpbmv1.demo.dto;

import com.fpbmv1.demo.entites.Pv;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
public class PvEtudiant implements Serializable {
    private String date;
    private String filiere;
    private String semestre;
    private String module;
    private String heure;
    private String responsableModule;
    private String Local;

    public PvEtudiant( String date, String filiere, String semestre, String module, String heure, String responsableModule, String local) {
        this.date = date;
        this.filiere = filiere;
        this.semestre = semestre;
        this.module = module;
        this.heure = heure;
        this.responsableModule = responsableModule;
        Local = local;
    }
}
