package com.fpbmv1.demo.entites;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
public class PHDStudent extends Personne implements Serializable {
  private String sujetDoctorat;
  @OneToMany(mappedBy = "phdStudent")
  private Collection<Inscription> inscriptions;
  @ManyToOne
  private CED ced;

}
