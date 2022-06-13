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
    @OneToMany(mappedBy = "professeur")
    private Collection<ProfesseurModule> professeurModules;
    @OneToMany(mappedBy = "professeur")
    private Collection<Surveillant> surveillants;
    @OneToMany(mappedBy = "professeur")
    private Collection<Jury> juries;
    @ManyToOne
    private Extern extern;

    public Professeur(String nom, String prenom, Date dateNaissance, String CINE, String grade, Collection<ProfesseurModule> professeurModules, Collection<Surveillant> surveillants, Collection<Jury> juries, Extern extern) {
        super(nom, prenom, dateNaissance, CINE);
        this.grade = grade;
        this.professeurModules = professeurModules;
        this.surveillants = surveillants;
        this.juries = juries;
        this.extern = extern;
    }
}
