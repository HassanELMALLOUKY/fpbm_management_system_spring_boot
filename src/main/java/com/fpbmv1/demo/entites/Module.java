package com.fpbmv1.demo.entites;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToOne
    private Semestre semestre;
    @ToString.Exclude @EqualsAndHashCode.Exclude
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
