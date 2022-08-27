package com.fpbmv1.demo.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Pv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    private String filiere;
    private String semestre;
    private String module;
    private String heure;
    private String responsableModule;
    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "pv",fetch = FetchType.LAZY)
    private List<Etudiant> etudiants;
    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "pv",fetch = FetchType.LAZY)
    private List<Surveillant> surveillants;

    public Pv(Date date,String filiere, String semestre, String module,  String responsableModule,String heure) {
        this.date=date;
        this.filiere = filiere;
        this.semestre = semestre;
        this.module = module;
        this.heure = heure;
        this.responsableModule = responsableModule;
    }
}
