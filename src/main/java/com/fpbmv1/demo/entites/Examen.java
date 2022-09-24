package com.fpbmv1.demo.entites;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Examen implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date dateExamen;
    private String module;
    private String filiere;
    private String heure;
    @ManyToOne
    private Salle salle;
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.LAZY)
    private Collection<Surveillant> surveillants;
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Etudiant> etudiants;
}
