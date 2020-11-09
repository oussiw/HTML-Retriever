package com.scrapper.listMed.Entity;

public class Medecine {
	private String engName;
	private String arName;
	
	public Medecine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEngName() {
		return engName;
	}
	public void setEngName(String engName) {
		this.engName = engName;
	}
	public String getArName() {
		return arName;
	}
	public void setArName(String arName) {
		this.arName = arName;
	}
	
	public Medecine(String engName, String arName) {
		super();
		this.engName = engName;
		this.arName = arName;
	}
	

}
