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
class ProfesseurModuleEtudiant implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private CoursTDTP coursTDTP;
    @ManyToOne
    private Etudiant etudiant;
    @ManyToOne
    private ProfesseurModule professeurModule;
    @OneToMany(mappedBy = "professeurModuleEtudiant")
    private Collection<ExamenProfesseurModuleEtudiant> examenProfesseurModuleEtudiants;

    public ProfesseurModuleEtudiant(CoursTDTP coursTDTP, Etudiant etudiant, ProfesseurModule professeurModule, Collection<ExamenProfesseurModuleEtudiant> examenProfesseurModuleEtudiants) {
        this.coursTDTP = coursTDTP;
        this.etudiant = etudiant;
        this.professeurModule = professeurModule;
        this.examenProfesseurModuleEtudiants = examenProfesseurModuleEtudiants;
    }
}
