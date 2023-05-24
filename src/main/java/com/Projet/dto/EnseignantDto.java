package com.Projet.dto;




import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnseignantDto {
	private String Nom;
	private String Prenom;
	private String email;
	private long cin;


}
