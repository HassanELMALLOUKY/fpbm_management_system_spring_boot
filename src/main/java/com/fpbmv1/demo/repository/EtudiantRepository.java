package com.fpbmv1.demo.repository;


import com.fpbmv1.demo.entites.Etudiant;
import com.fpbmv1.demo.entites.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {
    @Query("select e from Etudiant e join e.filiere f join f.semestres s join s.modules m where f.name=?1 and s.name=?2 and m.name=?3 ")
    List<Etudiant> getEtudiantsByFiliere(String f, String s, String m);
}
