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




@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/etudiant")
public class EtudiantController {
	@Autowired
	private EtudiantService etudiantService;
	@Autowired
	private EtudiantMapper etudiantMapper;
	
	@CrossOrigin(origins = "*")
	@PostMapping("")
	public ResponseEntity<?> CreateEtudiant(@RequestBody EtudiantDto etudiantDto){
		Etudiant etudiant = etudiantMapper.unMap(etudiantDto);
		HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Expose-Headers", "Content-Range");


		return ResponseEntity.ok().headers(headers)
								  .body(etudiantService.CreateEtudiant(etudiant));
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/{id}")
    public ResponseEntity<?> GetEtudiantById(@PathVariable Long id) {
		Etudiant etudiant = etudiantService.GetEtudiantById(id);
		EtudiantDto dto = etudiantMapper.map(etudiant);
		
		HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Expose-Headers", "Content-Range");
        
        return ResponseEntity.ok().headers(headers)
                .body(dto);
    }
	
	@CrossOrigin(origins = "*")
	@GetMapping()
	public ResponseEntity<?> GetAll() {
		
		List<Etudiant> etudiants = etudiantService.GetAll();
		
		List<EtudiantDto> dtos = etudiantMapper.map(etudiants);
		
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Range", "etudiant 0-20/20");
        
        headers.add("Access-Control-Expose-Headers", "Content-Range");

		return ResponseEntity.ok().headers(headers)
                                  .body(dtos);
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping("/{id}")
	public ResponseEntity<?> UpdateEtudiant(@PathVariable long id, @RequestBody EtudiantDto etudiantDto){
		Etudiant etudiant = etudiantMapper.unMap(etudiantDto);
		
		HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Expose-Headers", "Content-Range");
        
	    return ResponseEntity.ok().headers(headers)
	    		.body(etudiantService.UpdateEtudiant(id, etudiant));
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/{id}")
    public ResponseEntity<?> DetelteEtudiantById(@PathVariable long id) {
		etudiantService.DetelteEtudiantById(id);
		HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Expose-Headers", "Content-Range");
        return ResponseEntity.ok().headers(headers).build();
    }
	
	@CrossOrigin(origins = "*")
	@PostMapping("/female_percentage")
	public ResponseEntity<?> calculateFemalePercentage(){
		StatResDto statResDto = new StatResDto();
		statResDto.setResult(etudiantService.calculateFemalePercentage());
		
		HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Expose-Headers", "Content-Range");

		return ResponseEntity.ok().headers(headers)
									.body(statResDto);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/male_percentage")
	public ResponseEntity<?> calculateMalePercentage(){
		StatResDto statResDto = new StatResDto();
		statResDto.setResult(etudiantService.calculateMalePercentage());
		HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Expose-Headers", "Content-Range");

		return ResponseEntity.ok().headers(headers)
									.body(statResDto);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/ing_percentage")
	public ResponseEntity<?> calculateIngPercentage(){
		StatResDto statResDto = new StatResDto();
		statResDto.setResult(etudiantService.calculateIngPercentage());

		HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Expose-Headers", "Content-Range");

		return ResponseEntity.ok().headers(headers)
									.body(statResDto);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/licence_percentage")
	public ResponseEntity<?> calculateLicencePercentage(){
		StatResDto statResDto = new StatResDto();
		statResDto.setResult(etudiantService.calculateLicencePercentage());
		HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Expose-Headers", "Content-Range");

		return ResponseEntity.ok().headers(headers)
									.body(statResDto);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/mastere_percentage")
	public ResponseEntity<?> calculateMasterePercentage(){
		StatResDto statResDto = new StatResDto();
		statResDto.setResult(etudiantService.calculateMasterePercentage());
		HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Expose-Headers", "Content-Range");

		return ResponseEntity.ok().headers(headers)
									.body(statResDto);
	}

}
