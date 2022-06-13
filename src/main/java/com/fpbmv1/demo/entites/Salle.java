package com.fpbmv1.demo.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
public class Salle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int capaciteEtudiant;
    private int nombreSurveillant;
    @OneToMany(mappedBy = "salle")
    private Collection<Examen> examens;
    @OneToMany(mappedBy = "salle")
    private Collection<Soutenance> soutenances;

    public Salle(String name, int capaciteEtudiant, int nombreSurveillant, Collection<Examen> examens) {
        this.name = name;
        this.capaciteEtudiant = capaciteEtudiant;
        this.nombreSurveillant = nombreSurveillant;
        this.examens = examens;
    }
}
