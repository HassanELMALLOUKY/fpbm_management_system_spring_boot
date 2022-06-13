package com.fpbmv1.demo.entites;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Soutenance {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String sujet;
    private Date dateSoutenance;
    @OneToMany(mappedBy = "soutenance")
    private Collection<Jury> juries;
    @ManyToOne
    private Salle salle;
}
