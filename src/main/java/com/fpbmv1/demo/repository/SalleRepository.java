package com.fpbmv1.demo.repository;

import com.fpbmv1.demo.entites.Etudiant;
import com.fpbmv1.demo.entites.Salle;
import com.fpbmv1.demo.services.Gestion_Examen.FiliereService;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface SalleRepository   extends JpaRepository<Salle, Integer> {

    @Query(" from Etudiant  b join Filiere a where a.id = b.filiere.id ")
    List<Etudiant> findAllEtudiantss();

}