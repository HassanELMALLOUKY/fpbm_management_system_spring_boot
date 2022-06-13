package com.fpbmv1.demo.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Examen implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date dateExamen;
    private String heure;
    @ManyToOne
    private Salle salle;
    @OneToMany(mappedBy = "examen")
    private Collection<Surveillant> surveillants;
    @OneToMany(mappedBy = "examen")
    private Collection<ExamenProfesseurModuleEtudiant> examenProfesseurModuleEtudiants;
}
