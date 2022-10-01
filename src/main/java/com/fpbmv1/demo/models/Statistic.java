package com.fpbmv1.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Statistic {
    private int nbEtudiants;
    private int nbProf;
    private int nbSalle;
    private int nbFiliere;

}
