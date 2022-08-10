package com.fpbmv1.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurveillantsNameModel {
    private int id;
    private String nom;
    private String prenom;
}
