package com.fpbmv1.demo.repository;

import com.fpbmv1.demo.entites.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface FiliereRepository extends JpaRepository<Filiere, Integer> {
    Filiere findByName(String name);
}
