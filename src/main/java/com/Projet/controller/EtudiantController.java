package com.Projet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.http.HttpHeaders;

import com.Projet.dto.EtudiantDto;
import com.Projet.dto.StatResDto;

import com.Projet.entity.Etudiant;
import com.Projet.mapper.EtudiantMapper;
import com.Projet.service.EtudiantService;




@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/etudiant")
public class EtudiantController {
	@Autowired
	private EtudiantService etudiantService;
	@Autowired
	private EtudiantMapper etudiantMapper;
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping("")
	public ResponseEntity<?> CreateEtudiant(@RequestBody EtudiantDto etudiantDto){
		Etudiant etudiant = etudiantMapper.unMap(etudiantDto);
		return ResponseEntity.ok(etudiantService.CreateEtudiant(etudiant));
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/{id}")
    public ResponseEntity<?> GetEtudiantById(@PathVariable Long id) {
		Etudiant etudiant = etudiantService.GetEtudiantById(id);
		EtudiantDto dto = etudiantMapper.map(etudiant);
        return ResponseEntity.ok(dto);
    }
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping()
	public ResponseEntity<?> GetAll() {
		
		List<Etudiant> etudiants = etudiantService.GetAll();
		
		List<EtudiantDto> dtos = etudiantMapper.map(etudiants);
		
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Range", "etudiant 0-20/20");

		return ResponseEntity.ok().headers(headers)
                                  .body(dtos);
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@PutMapping("/{id}")
	public ResponseEntity<?> UpdateEtudiant(@PathVariable long id, @RequestBody EtudiantDto etudiantDto){
		Etudiant etudiant = etudiantMapper.unMap(etudiantDto);
	    return ResponseEntity.ok(etudiantService.UpdateEtudiant(id, etudiant));
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@DeleteMapping("/{id}")
    public ResponseEntity<?> DetelteEtudiantById(@PathVariable long id) {
		etudiantService.DetelteEtudiantById(id);
        return ResponseEntity.ok().build();
    }
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping("/female_percentage")
	public ResponseEntity<?> calculateFemalePercentage(){
		StatResDto statResDto = new StatResDto();
		statResDto.setResult(etudiantService.calculateFemalePercentage());

		return ResponseEntity.ok(statResDto);
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping("/male_percentage")
	public ResponseEntity<?> calculateMalePercentage(){
		StatResDto statResDto = new StatResDto();
		statResDto.setResult(etudiantService.calculateMalePercentage());

		return ResponseEntity.ok(statResDto);
	}

}
