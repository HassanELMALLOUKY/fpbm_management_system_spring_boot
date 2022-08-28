package com.fpbmv1.demo.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
public class Etudiant extends Personne implements Serializable {
    private long appogee;
    private String cne;
    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private Filiere filiere;
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToOne
    private Pv pv;

    public Etudiant(String nom, String prenom, Date dateNaissance, String CINE, long appogee, String cne, Filiere filiere, Pv pv) {
        super(nom, prenom, dateNaissance, CINE);
        this.appogee = appogee;
        this.cne = cne;
        this.filiere = filiere;
        this.pv=pv;
    }
}
