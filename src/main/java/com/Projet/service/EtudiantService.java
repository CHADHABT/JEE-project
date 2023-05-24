package com.Projet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Projet.base.service.BaseService;
import com.Projet.entity.Etudiant;
import com.Projet.repository.EtudiantRepository;

@Service
public class EtudiantService extends BaseService<Etudiant, Long>{
	
	@Autowired
	private EtudiantRepository etudiantRepository; 
	
	public Etudiant CreateEtudiant (Etudiant newEtudiant) {
		
		Etudiant etudiant = new Etudiant();
		etudiant.setCin(newEtudiant.getCin());
		etudiant.setEmail(newEtudiant.getEmail());
		etudiant.setNiveau(newEtudiant.getNiveau());
		etudiant.setNom(newEtudiant.getNom());
		etudiant.setPrenom(newEtudiant.getPrenom());
		etudiant.setSection(newEtudiant.getSection());
		etudiant.setGenre(newEtudiant.getGenre());
		
        return etudiantRepository.save(etudiant);

	}
	
    public Etudiant GetEtudiantById (long id) {
    	Optional<Etudiant> optionalEtudiant = etudiantRepository.findById(id);
    	Etudiant etudiant = optionalEtudiant.orElseThrow(() -> new RuntimeException("Etudiant not found"));
		return etudiant;
	}
    
    public List<Etudiant> GetAll() {
		return etudiantRepository.findAll();
	}
    
    public Etudiant UpdateEtudiant (long id, Etudiant newEtudiant) {
    	
    	Optional<Etudiant> optionalEtudiant = etudiantRepository.findById(id);
    	Etudiant etudiant = optionalEtudiant.orElseThrow(() -> new RuntimeException("Etudiant not found"));
    	
    	etudiant.setEmail(newEtudiant.getEmail());
		etudiant.setNiveau(newEtudiant.getNiveau());
		etudiant.setNom(newEtudiant.getNom());
		etudiant.setPrenom(newEtudiant.getPrenom());
		etudiant.setSection(newEtudiant.getSection());
    	
        return etudiantRepository.save(etudiant);

    }
    
    public void DetelteEtudiantById (long id) {
    	Etudiant etudiant = etudiantRepository.findById(id).orElseThrow(() -> new RuntimeException("Etudiant not found"));
    	etudiantRepository.deleteById(id);
	}
    
    public double calculateFemalePercentage() {
        if (etudiantRepository.countByGenre("homme") + etudiantRepository.countByGenre("femme") == 0) {
            return 0.0; // To handle division by zero error
        }
        
        double femalePercentage = (double) etudiantRepository.countByGenre("femme") / (etudiantRepository.countByGenre("homme") + etudiantRepository.countByGenre("femme")) * 100;
        return femalePercentage;
    }
    
    public double calculateMalePercentage() {
        if (etudiantRepository.countByGenre("homme") + etudiantRepository.countByGenre("femme") == 0) {
            return 0.0; // To handle division by zero error
        }
        
        double femalePercentage = (double) etudiantRepository.countByGenre("homme") / (etudiantRepository.countByGenre("homme") + etudiantRepository.countByGenre("femme")) * 100;
        return femalePercentage;
    }
    
    public double calculateIngPercentage() {
        if (etudiantRepository.count() == 0) {
            return 0.0; // To handle division by zero error
        }
        
        double SectionPercentage = (double) etudiantRepository.countByNiveau("ing") / (etudiantRepository.count()) * 100;
        return SectionPercentage;
    }
    
    public double calculateLicencePercentage() {
        if (etudiantRepository.count() == 0) {
            return 0.0; // To handle division by zero error
        }
        
        double SectionPercentage = (double) etudiantRepository.countByNiveau("licence") / (etudiantRepository.count()) * 100;
        return SectionPercentage;
    }
    
    public double calculateMasterePercentage() {
        if (etudiantRepository.count() == 0) {
            return 0.0; // To handle division by zero error
        }
        
        double SectionPercentage = (double) etudiantRepository.countByNiveau("mastere") / (etudiantRepository.count()) * 100;
        return SectionPercentage;
    }
    

}
