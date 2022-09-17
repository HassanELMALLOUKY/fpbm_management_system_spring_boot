package com.fpbmv1.demo.entites;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@Data
@NoArgsConstructor
public abstract class Personne extends User {
    private String nom;
    private String prenom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private String CINE;

    public Personne(String nom, String prenom, Date dateNaissance, String CINE) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.CINE = CINE;
    }
}
