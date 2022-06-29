package com.fpbmv1.demo.repository;

import com.fpbmv1.demo.entites.Filiere;
import com.fpbmv1.demo.entites.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ModuleRepository extends JpaRepository<Module, Integer> {
    Module findByName(String name);
}
