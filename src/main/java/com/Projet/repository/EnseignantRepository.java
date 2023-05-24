package com.Projet.repository;

import org.springframework.stereotype.Repository;

import com.Projet.base.repository.BaseRepository;
import com.Projet.entity.CadreAdmin;
import com.Projet.entity.Enseignant;

@Repository

public interface EnseignantRepository extends BaseRepository <Enseignant, Long>{

}
