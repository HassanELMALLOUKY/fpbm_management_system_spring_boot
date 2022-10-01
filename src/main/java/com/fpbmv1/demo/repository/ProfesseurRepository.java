package com.fpbmv1.demo.repository;


import com.fpbmv1.demo.entites.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProfesseurRepository extends JpaRepository<Professeur, Integer> {
    @Query("SELECT  count(e.id) from Professeur e ")
    int getNombreProf();

}
