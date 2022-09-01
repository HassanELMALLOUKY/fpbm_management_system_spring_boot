package com.fpbmv1.demo.repository;


import com.fpbmv1.demo.entites.Etudiant;
import com.fpbmv1.demo.entites.Pv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PvRepository extends JpaRepository<Pv, Integer> {
    @Query("select p from Pv p join p.etudiants e where e.CINE=?1")
    List<Pv> getPvsWithCINE(String cine);
}
