package com.fpbmv1.demo.entites;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

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
    @ManyToOne
    private Filiere filiere;

    public Module(String name, Semestre semestre, Filiere filiere) {
        this.name = name;
        this.semestre = semestre;
        this.filiere=filiere;
    }

    public Module(String name) {
        this.name = name;
    }
}
