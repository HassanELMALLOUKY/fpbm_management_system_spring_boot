package com.fpbmv1.demo.repository;


import com.fpbmv1.demo.entites.Professeur;
import com.fpbmv1.demo.entites.Surveillant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface SurveillantRepository extends JpaRepository<Surveillant, Integer> {
    @Query("select s,p from Surveillant s join s.professeur p where s.professeur.id=p.id ")
    List<Object[]> getSurveillantNames();
    List<Surveillant> getSurveillantsByDisponibleIsTrue();
    List<Surveillant> getAllByDisponibleIsTrue();


}
