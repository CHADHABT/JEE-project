package com.Projet.repository;

import org.springframework.stereotype.Repository;

import com.Projet.base.repository.BaseRepository;
import com.Projet.entity.Enseignant;
import com.Projet.entity.Etudiant;


@Repository

public interface EtudiantRepository extends BaseRepository <Etudiant, Long>{
    long countByGenre(String genre);
    long countByNiveau(String niveau);
    long countBySection(String section);



}
