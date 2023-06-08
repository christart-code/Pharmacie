package com.pharmacie.entities;

import java.util.ArrayList;
import java.util.List;



public class Fournisseur extends Personne {
	private int id;
	private String niu;
	private String nom;
	private String prenom;
	public Fournisseur() {
		super();
	}
	public Fournisseur(int id, String niu, String nom, String prenom) {
		super();
		this.id = id;
		this.niu = niu;
		this.nom = nom;
		this.prenom = prenom;
	}
	public Fournisseur(String niu, String nom, String prenom) {
		super();
		this.niu = niu;
		this.nom = nom;
		this.prenom = prenom;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNiu() {
		return niu;
	}
	public void setNiu(String niu) {
		this.niu = niu;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	@Override
	public String toString() {
		return "fournisseur [id=" + id + ", niu=" + niu + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
 
}
