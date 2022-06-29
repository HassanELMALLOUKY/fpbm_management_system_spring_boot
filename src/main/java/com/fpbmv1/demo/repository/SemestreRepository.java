package com.fpbmv1.demo.repository;

import com.fpbmv1.demo.entites.Filiere;
import com.fpbmv1.demo.entites.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SemestreRepository extends JpaRepository<Semestre, Integer> {
    Semestre findByName(String name);
}
