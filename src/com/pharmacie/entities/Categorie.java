package com.pharmacie.entities;

import java.util.ArrayList;
import java.util.List;


public class Categorie {
	private int id;
	private String code;
	private String libelle;

	
	// construsteur sans paramètres
	public Categorie() {
		super();
	}
	//construsteur avec paramètres
	
	public Categorie(String code, String libelle) {
		super();
		this.setCode(code);
		this.setLibelle(libelle);
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	/*construsteur avec paramètres y compris l'id(ceci est fait
	 pour les mises à jours*/
	 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Categorie(int id, String code, String libelle) {
		super();
		this.id = id;
		this.setCode(code);
		this.setLibelle(libelle);
	}

	@Override
	public String toString() {
		return id + " " + code + " " + libelle ;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
