package com.fpbmv1.demo.repository;


import com.fpbmv1.demo.entites.Surveillant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SurveillantRepository extends JpaRepository<Surveillant, Integer> {

}
