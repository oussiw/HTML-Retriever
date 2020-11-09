package com.scrapper.listMed.Entity;

import java.util.ArrayList;
import java.util.List;

public class MedecineGroup {
	private char letter;
	private String url;
	private List<Medecine> medocs;
	
	public MedecineGroup(char letter, String url) {
		super();
		this.letter = letter;
		this.url = url;
		medocs = new ArrayList<Medecine>();
	}
	
	public char getLetter() {
		return letter;
	}
	public void setLetter(char letter) {
		this.letter = letter;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public void addMedecine(Medecine med) {
		medocs.add(med);
		System.out.println("Element ajoute.");
	}

	public List<Medecine> getMedocs() {
		return medocs;
	}
	

}
