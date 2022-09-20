package com.fpbmv1.demo.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
public class Etudiant extends Personne implements Serializable {
    private long appogee;
    private String cne;
    private String ordre;
    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private Filiere filiere;
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Pv> pv;
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Examen> examens;
}
