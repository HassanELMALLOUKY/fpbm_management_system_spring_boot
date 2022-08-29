package com.fpbmv1.demo.repository;


import com.fpbmv1.demo.entites.Examen;
import com.fpbmv1.demo.entites.ExtractExams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ExtractExamsRepository extends JpaRepository<ExtractExams, Integer> {

}
