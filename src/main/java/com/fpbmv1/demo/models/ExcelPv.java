package com.fpbmv1.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExcelPv {
    private String date;
    private String filiere;
    private String semestre;
    private String module;
    private String responsable;
    private String heure;
}
