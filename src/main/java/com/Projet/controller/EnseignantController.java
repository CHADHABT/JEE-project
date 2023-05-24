package com.Projet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Projet.dto.EnseignantDto;
import com.Projet.dto.EtudiantDto;
import com.Projet.entity.Enseignant;
import com.Projet.entity.Etudiant;
import com.Projet.mapper.EnseignantMapper;
import com.Projet.mapper.EtudiantMapper;
import com.Projet.service.EnseignantService;
import com.Projet.service.EtudiantService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/enseignant")
public class EnseignantController {
	@Autowired
	private EnseignantService enseignantService;
	@Autowired
	private EnseignantMapper enseignantMapper;
	
	@CrossOrigin(origins = "*")
	@PostMapping("")
	public ResponseEntity<?> CreateEnseignant(@RequestBody EnseignantDto enseignantDto){
		Enseignant enseignant = enseignantMapper.unMap(enseignantDto);
		HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Expose-Headers", "Content-Range");
        
		return ResponseEntity.ok().headers(headers)
				.body(enseignantService.CreateEnseignant(enseignant));
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/{id}")
    public ResponseEntity<?> GetEnseignantById(@PathVariable Long id) {
		Enseignant enseignant = enseignantService.GetEnseignantById(id);
		EnseignantDto dto = enseignantMapper.map(enseignant);
		HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Expose-Headers", "Content-Range");
        
        return ResponseEntity.ok().headers(headers)
                .body(dto);
    }
	
	@CrossOrigin(origins = "*")
	@GetMapping()
	public ResponseEntity<?> GetAll() {
		
		List<Enseignant> enseignant = enseignantService.GetAll();
		
		List<EnseignantDto> dtos = enseignantMapper.map(enseignant);
		
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Range", "etudiant 0-20/20");

        headers.add("Access-Control-Expose-Headers", "Content-Range");

		return ResponseEntity.ok().headers(headers)
                                  .body(dtos);
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping("/{id}")
	public ResponseEntity<?> UpdateEnseignant(@PathVariable long id, @RequestBody EnseignantDto enseignantDto){
		Enseignant enseignant = enseignantMapper.unMap(enseignantDto);
		HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Expose-Headers", "Content-Range");
        
	    return ResponseEntity.ok().headers(headers)
	    		.body(enseignantService.UpdateEnseignant(id, enseignant));
	    
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/{id}")
    public ResponseEntity<?> DetelteEnseignantById(@PathVariable long id) {
		enseignantService.DetelteEnseignantById(id);
		HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Expose-Headers", "Content-Range");
        return ResponseEntity.ok().headers(headers).build();
    }

}










