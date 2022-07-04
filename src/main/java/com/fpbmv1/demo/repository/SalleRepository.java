package com.fpbmv1.demo.repository;

import com.fpbmv1.demo.entites.Etudiant;
import com.fpbmv1.demo.entites.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
//njkdnfjsd
public interface SalleRepository extends JpaRepository<Salle,Integer> {

    @Query("select u from Etudiant u where u.id=269")
    List<Etudiant> findAllEtudiantss();

}
