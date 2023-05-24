package com.Projet.dto;

import java.util.List;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadreAdminDto {
	private long id;
	private String Nom;
	private String Prenom;
	private String email;
	private long cin;


}
