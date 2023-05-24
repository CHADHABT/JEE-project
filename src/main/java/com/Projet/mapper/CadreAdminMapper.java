package com.Projet.mapper;

import org.mapstruct.Mapper;

import com.Projet.base.mapper.BaseMapper;
import com.Projet.dto.CadreAdminDto;
import com.Projet.dto.EtudiantDto;
import com.Projet.entity.CadreAdmin;
import com.Projet.entity.Etudiant;

@Mapper
public interface CadreAdminMapper extends BaseMapper <CadreAdmin, CadreAdminDto>{

}
