package com.fpbmv1.demo.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    @ManyToOne(fetch = FetchType.EAGER)
    private Filiere filiere;

    public Etudiant(String nom, String prenom, Date dateNaissance, String CINE, long appogee, String cne, Filiere filiere) {
        super(nom, prenom, dateNaissance, CINE);
        this.appogee = appogee;
        this.cne = cne;
        this.filiere = filiere;
    }
}
