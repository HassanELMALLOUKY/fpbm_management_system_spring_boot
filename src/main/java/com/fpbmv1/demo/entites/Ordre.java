package com.fpbmv1.demo.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

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
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToOne(cascade = CascadeType.ALL)
    private Etudiant etudiant;
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToOne(cascade = CascadeType.ALL)
    private Pv pv;
}
