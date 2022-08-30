package com.fpbmv1.demo.Pvs;

import com.fpbmv1.demo.entites.Etudiant;
import com.fpbmv1.demo.entites.Surveillant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Pv1 {
    private String local;
    private String module;
    private LocalDateTime localDateTime;
    private List<Surveillant> surveillants;
    private List<Etudiant> etudiants;

}
