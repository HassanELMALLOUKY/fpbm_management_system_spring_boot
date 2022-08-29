package com.fpbmv1.demo.repository;

import com.fpbmv1.demo.entites.Etudiant;
import com.fpbmv1.demo.entites.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface SalleRepository extends JpaRepository<Salle,Integer> {

    @Query("select u from Etudiant u")
    List<Etudiant> findAllEtudiantss();
    @Query("select s from Salle s where s.disponible=true")
    List<Salle> findFreeSalle();
    List<Salle> getAllByDisponibleIsTrue();
    @Transactional
    @Modifying
    @Query("update Salle s set s.disponible=true")
    void makeSallesFree();

}
