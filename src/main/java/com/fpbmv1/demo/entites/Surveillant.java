package com.fpbmv1.demo.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
public class Surveillant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private Examen examen;
    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private Professeur professeur;
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToOne
    private Pv pv;

    public Surveillant(Examen examen, Professeur professeur, Pv pv) {
        this.examen = examen;
        this.professeur = professeur;
        this.pv=pv;
    }
}
