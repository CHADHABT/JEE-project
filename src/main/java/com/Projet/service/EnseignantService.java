package com.Projet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projet.base.service.BaseService;
import com.Projet.entity.Enseignant;
import com.Projet.entity.Etudiant;
import com.Projet.repository.EnseignantRepository;

@Service
public class EnseignantService extends BaseService<Enseignant, Long>{
	
	@Autowired
	private EnseignantRepository enseignantRepository;
	
    public Enseignant CreateEnseignant (Enseignant newEnseignant) {
		
    	Enseignant enseignant = new Enseignant();
    	enseignant.setCin(newEnseignant.getCin());
    	enseignant.setEmail(newEnseignant.getEmail());
    	enseignant.setNom(newEnseignant.getNom());
    	enseignant.setPrenom(newEnseignant.getPrenom());
		
        return enseignantRepository.save(enseignant);

	}
    
    public Enseignant GetEnseignantById (long id) {
    	Optional<Enseignant> optionalEnseignant = enseignantRepository.findById(id);
    	Enseignant enseignant = optionalEnseignant.orElseThrow(() -> new RuntimeException("Enseignant not found"));
		return enseignant;
	}
    
    public List<Enseignant> GetAll() {
		return enseignantRepository.findAll();
	}
    
    public Enseignant UpdateEnseignant (long id, Enseignant newEnseignant) {
    	
    	Optional<Enseignant> optionalEnseignant = enseignantRepository.findById(id);
    	Enseignant enseignant = optionalEnseignant.orElseThrow(() -> new RuntimeException("Enseignant not found"));
    	
    	enseignant.setEmail(newEnseignant.getEmail());
    	enseignant.setNom(newEnseignant.getNom());
    	enseignant.setPrenom(newEnseignant.getPrenom());
    	
        return enseignantRepository.save(enseignant);
    }
    
    public void DetelteEnseignantById (long id) {
    	Enseignant enseignant = enseignantRepository.findById(id).orElseThrow(() -> new RuntimeException("Enseignant not found"));
    	enseignantRepository.deleteById(id);
	}

}
