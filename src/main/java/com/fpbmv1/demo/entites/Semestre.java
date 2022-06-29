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
public class Semestre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "semestre")
    private Collection<Module> modules;
    @OneToMany(mappedBy = "semestre")
    private Collection<Module> moduleList;
    @ManyToOne
    private Filiere filiere;

    public Semestre(String name, Collection<Module> modules) {
        this.name = name;
        this.modules = modules;
    }
}
