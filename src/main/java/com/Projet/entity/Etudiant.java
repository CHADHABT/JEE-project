package com.Projet.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private long cin;

    private String Nom;
    private String Prenom;

    @Column(unique = true)
    private String email;

    private String niveau;
    private String section;
    private String genre;

    public String getEmail() {
        return email;
    }

    public long getCin() {
        return cin;
    }

    public void setCin(long cin) {
        this.cin = cin;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNiveau() {
        return niveau;
    }

    public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public String getSection() {
        return section;
    }

    public String getGenre() {
        return genre;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public void setNom(String nom) {
        this.Nom = nom;
    }

    public void setPrenom(String prenom) {
        this.Prenom = prenom;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

	public void setId(long id2) {
		// TODO Auto-generated method stub
		id=id2;
	}

	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}
}
