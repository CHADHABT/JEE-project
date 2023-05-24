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

import com.Projet.dto.CadreAdminDto;
import com.Projet.dto.EnseignantDto;
import com.Projet.entity.CadreAdmin;
import com.Projet.entity.Enseignant;
import com.Projet.mapper.CadreAdminMapper;
import com.Projet.mapper.EnseignantMapper;
import com.Projet.service.CadreAdminService;
import com.Projet.service.EnseignantService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/cadre_admin")
public class CadreAdminController {
	@Autowired
	private CadreAdminService cadreAdminService;
	@Autowired
	private CadreAdminMapper cadreAdminMapper;
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping("")
	public ResponseEntity<?> CreateCadreAdmin(@RequestBody CadreAdminDto cadreAdminDto){
		CadreAdmin cadreAdmin = cadreAdminMapper.unMap(cadreAdminDto);
		return ResponseEntity.ok(cadreAdminService.CreateCadreAdmin(cadreAdmin));
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/{id}")
    public ResponseEntity<?> GetCadreAdminById(@PathVariable Long id) {
		CadreAdmin cadreAdmin = cadreAdminService.GetCadreAdminById(id);
		CadreAdminDto dto = cadreAdminMapper.map(cadreAdmin);
        return ResponseEntity.ok(dto);
    }
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping()
	public ResponseEntity<?> GetAll() {
		
		List<CadreAdmin> cadreAdmin = cadreAdminService.GetAll();
		
		List<CadreAdminDto> dtos = cadreAdminMapper.map(cadreAdmin);
		
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Range", "etudiant 0-20/20");

		return ResponseEntity.ok().headers(headers)
                                  .body(dtos);
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@PutMapping("/{id}")
	public ResponseEntity<?> UpdateCadreAdmin(@PathVariable long id, @RequestBody CadreAdminDto cadreAdminDto){
		CadreAdmin cadreAdmin = cadreAdminMapper.unMap(cadreAdminDto);
	    return ResponseEntity.ok(cadreAdminService.UpdateCadreAdmin(id, cadreAdmin));
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@DeleteMapping("/{id}")
    public ResponseEntity<?> DetelteCadreAdminById(@PathVariable long id) {
		cadreAdminService.DetelteCadreAdminById(id);
        return ResponseEntity.ok().build();
    }

}
