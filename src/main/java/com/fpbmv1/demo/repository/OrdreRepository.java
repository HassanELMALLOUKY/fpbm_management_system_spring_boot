package com.fpbmv1.demo.repository;

import com.fpbmv1.demo.entites.Etudiant;
import com.fpbmv1.demo.entites.Ordre;
import com.fpbmv1.demo.entites.Pv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface OrdreRepository extends JpaRepository<Ordre, Long> {
    Ordre findOrdreByEtudiantAndPv(Etudiant etudiant, Pv pv);
    List<Ordre> findOrdresByEtudiant(Etudiant etudiant);
}
