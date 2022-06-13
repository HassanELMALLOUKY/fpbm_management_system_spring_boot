package com.fpbmv1.demo.entites;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    @OneToMany(mappedBy = "section")
    private Collection<ProfesseurModule> professeurModules;

    public Section(String nom, Collection<ProfesseurModule> professeurModules) {
        this.nom = nom;
        this.professeurModules = professeurModules;
    }
}
