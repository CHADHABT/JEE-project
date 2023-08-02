package com.Projet.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatResDto {
	private double result;

	public void setResult(double calculateLicencePercentage) {
		this.result=calculateLicencePercentage;
		
	}



}
