package com.fpbmv1.demo.entites;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamenProfesseurModuleEtudiant implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    private Examen examen;
    @ManyToOne
    private ProfesseurModuleEtudiant professeurModuleEtudiant;

}
