package com.fpbmv1.demo.entites;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
public class CED {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany(mappedBy = "ced")
    private Collection<PHDStudent> phdStudents;
    @OneToMany(mappedBy = "ced")
    private Collection<Equipe> equipes;
    @OneToMany(mappedBy = "ced")
    private Collection<Labo> labos;
}
