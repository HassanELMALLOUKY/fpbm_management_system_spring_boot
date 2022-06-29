package com.fpbmv1.demo.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@Data
@NoArgsConstructor
public class Professeur extends Personne implements Serializable {
    private String grade;
    @OneToMany(mappedBy = "professeur",fetch = FetchType.LAZY)
    private Collection<Surveillant> surveillants;
    @ManyToOne()
    private Extern extern;


    public Professeur(String nom, String prenom, Date dateNaissance, String CINE, String grade, Collection<Surveillant> surveillants, Extern extern) {
        super(nom, prenom, dateNaissance, CINE);
        this.grade = grade;
        this.surveillants = surveillants;
        this.extern = extern;
    }
}
