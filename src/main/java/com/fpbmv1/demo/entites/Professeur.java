package com.fpbmv1.demo.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
