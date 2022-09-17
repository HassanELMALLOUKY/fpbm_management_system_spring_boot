package com.fpbmv1.demo.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ordre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String ordre;

    @ManyToOne(cascade = CascadeType.ALL)
    private Etudiant etudiant;

    @ManyToOne(cascade = CascadeType.ALL)
    private Pv pv;
}
