package com.fpbmv1.demo.entites;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Professeur extends Personne implements Serializable {
    private String grade;
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "professeur",fetch = FetchType.LAZY)
    private Collection<Surveillant> surveillants;
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToOne()
    private Extern extern;
}
