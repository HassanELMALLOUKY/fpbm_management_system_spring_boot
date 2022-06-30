package com.fpbmv1.demo.entites;

import lombok.*;

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
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "semestre")
    private Collection<Module> modules;
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToOne
    private Filiere filiere;

    public Semestre(String name, Collection<Module> modules) {
        this.name = name;
        this.modules = modules;
    }
}
