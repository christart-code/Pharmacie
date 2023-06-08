package com.pharmacie.entities;

public class Role {
	private int id;
	private String code;
	private String nom;
	
	
	
	
	public Role() {
		
		super();
	}
	
	
	public Role(String code, String nom) {
		super();
		this.setCode(code);
		this.setNom(nom);
	}


	public Role(int id, String code, String nom) {
		super();
		this.id = id;
		this.setCode(code);
		this.setNom(nom);

	}


	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Role [id=" + id + ", code=" + code + ", nom=" + nom + "]";
	}
	
	
	
	
	
	

}
