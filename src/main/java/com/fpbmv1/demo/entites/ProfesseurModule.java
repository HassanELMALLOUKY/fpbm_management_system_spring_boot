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
public class ProfesseurModule implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Annee annee;
    @ManyToOne
    private Professeur professeur;
    @ManyToOne
    private Module module;
    @ManyToOne
    private CoursTDTP coursTDTP;
    @OneToMany(mappedBy = "professeurModule")
    private Collection<ProfesseurModuleEtudiant> professeurModuleEtudiants;
    @ManyToOne
    private Section section;

}
