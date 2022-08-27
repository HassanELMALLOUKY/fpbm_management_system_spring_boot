package com.fpbmv1.demo.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Filiere implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    private Type type;
    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "filiere", fetch = FetchType.LAZY)
    private Set<Etudiant> etudiants;
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToOne
    private Departement departement;
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "filiere",fetch = FetchType.LAZY)
    private Collection<Module> modules;
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "filiere",fetch = FetchType.LAZY)
    private Collection<Semestre> semestres;

}
