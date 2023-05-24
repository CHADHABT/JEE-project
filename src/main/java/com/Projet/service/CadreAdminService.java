package com.Projet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projet.base.service.BaseService;
import com.Projet.entity.CadreAdmin;
import com.Projet.entity.Enseignant;
import com.Projet.entity.Etudiant;
import com.Projet.repository.CadreAdminRepository;
import com.Projet.repository.EnseignantRepository;

@Service
public class CadreAdminService extends BaseService<CadreAdmin, Long>{
	@Autowired
	private CadreAdminRepository cadreAdminRepository;
	
    public CadreAdmin CreateCadreAdmin (CadreAdmin newCadreAdmin) {
		
    	CadreAdmin cadreAdmin = new CadreAdmin();
    	cadreAdmin.setCin(newCadreAdmin.getCin());
    	cadreAdmin.setEmail(newCadreAdmin.getEmail());
    	cadreAdmin.setNom(newCadreAdmin.getNom());
    	cadreAdmin.setPrenom(newCadreAdmin.getPrenom());
		
        return cadreAdminRepository.save(cadreAdmin);
        
	}
    
    public CadreAdmin GetCadreAdminById (long id) {
    	Optional<CadreAdmin> optionalCadreAdmin = cadreAdminRepository.findById(id);
    	CadreAdmin cadreAdmin = optionalCadreAdmin.orElseThrow(() -> new RuntimeException("Cadre Admin not found"));
		return cadreAdmin;
	}
    
    public List<CadreAdmin> GetAll() {
		return cadreAdminRepository.findAll();
	}
    
    public CadreAdmin UpdateCadreAdmin (long id, CadreAdmin newCadreAdmin) {
    	
    	Optional<CadreAdmin> optionalCadreAdmin = cadreAdminRepository.findById(id);
    	CadreAdmin cadreAdmin = optionalCadreAdmin.orElseThrow(() -> new RuntimeException("Cadre Admin not found"));
    	
    	cadreAdmin.setEmail(newCadreAdmin.getEmail());
    	cadreAdmin.setNom(newCadreAdmin.getNom());
    	cadreAdmin.setPrenom(newCadreAdmin.getPrenom());
    	
        return cadreAdminRepository.save(cadreAdmin);
    }
    
    public void DetelteCadreAdminById (long id) {
    	CadreAdmin cadreAdmin = cadreAdminRepository.findById(id).orElseThrow(() -> new RuntimeException("Cadre Admin not found"));
    	cadreAdminRepository.deleteById(id);
	}

}
