package com.fpbmv1.demo.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
public class Surveillant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Examen examen;
    @ManyToOne
    private Professeur professeur;

    public Surveillant(Examen examen, Professeur professeur) {
        this.examen = examen;
        this.professeur = professeur;
    }
}
