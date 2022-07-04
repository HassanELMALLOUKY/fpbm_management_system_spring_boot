package com.fpbmv1.demo.entites;

import lombok.*;

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
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "professeur",fetch = FetchType.LAZY)
    private Collection<Surveillant> surveillants;
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToOne()
    private Extern extern;


    public Professeur(String nom, String prenom, Date dateNaissance, String CINE, String grade, Collection<Surveillant> surveillants, Extern extern) {
        super(nom, prenom, dateNaissance, CINE);
        this.grade = grade;
        this.surveillants = surveillants;
        this.extern = extern;
    }
}
