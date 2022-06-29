package com.fpbmv1.demo.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @OneToMany(mappedBy = "filiere", fetch = FetchType.LAZY)
    private Set<Etudiant> etudiants;
    @ManyToOne
    private Departement departement;
    @OneToMany(mappedBy = "filiere",fetch = FetchType.LAZY)
    private Collection<Module> modules;
    @OneToMany(mappedBy = "filiere",fetch = FetchType.LAZY)
    private Collection<Semestre> semestres;
    @Override
    public String toString() {
        return name;
    }
}
