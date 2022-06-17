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
public class Module implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne
    private Semestre semestre;
    @OneToMany(mappedBy = "module")
    private Collection<ProfesseurModule> professeurModules;

    public Module(String name, Semestre semestre, Collection<ProfesseurModule> professeurModules) {
        this.name = name;
        this.semestre = semestre;
        this.professeurModules = professeurModules;
    }
}
