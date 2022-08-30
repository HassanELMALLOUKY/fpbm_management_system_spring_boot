package com.fpbmv1.demo.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime date;
    private String filiere;
    private String semestre;
    private String module;
    private String heure;
    private String responsableModule;
    private String Local;
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Etudiant> etudiants;
    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany()
    private List<Surveillant> surveillants;

    public Pv(LocalDateTime date, String filiere, String semestre, String module, String heure, String responsableModule, String local) {
        this.date = date;
        this.filiere = filiere;
        this.semestre = semestre;
        this.module = module;
        this.heure = heure;
        this.responsableModule = responsableModule;
        Local = local;
    }
}
