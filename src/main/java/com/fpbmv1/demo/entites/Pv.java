package com.fpbmv1.demo.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String date;
    private String filiere;
    private String semestre;
    private String module;
    private String heure;
    private String responsableModule;
    private String Local;
    private long de;
    private long jusqua;
    private String ordre;
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Etudiant> etudiants;
    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToMany()
    private List<Surveillant> surveillants;

}
