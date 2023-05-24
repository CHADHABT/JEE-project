package com.Projet.mapper;

import org.mapstruct.Mapper;

import com.Projet.base.mapper.BaseMapper;
import com.Projet.dto.EtudiantDto;
import com.Projet.entity.Etudiant;


@Mapper
public interface EtudiantMapper extends BaseMapper <Etudiant, EtudiantDto>{

}
