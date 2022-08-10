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

   // @ToString.Exclude
   // @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Filiere filiere;

    public Etudiant(String nom, String prenom, Date dateNaissance, String CINE, long appogee, String cne, Filiere filiere) {
        super(nom, prenom, dateNaissance, CINE);
        this.appogee = appogee;
        this.cne = cne;
        this.filiere = filiere;
    }
}
