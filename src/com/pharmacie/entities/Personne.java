package com.pharmacie.entities;

public abstract class Personne {
	protected String nom;
	protected String prenom;
	protected String niu;
	
	
	public Personne() {
		super();
	}



	public Personne(String niu, String nom, String prenom) {
		super(); 
		this.setNiu(niu);
		this.setNom(nom);
		this.setPrenom(prenom);
	}






	public String getNom() {
		return nom;
	}





// le nom sera enregistré en majuscule grâce à la methode toUppercase
	
	public void setNom(String nom) {
		this.nom = nom.toUpperCase();
	}






	public String getPrenom() {
		return prenom;
	}






	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}






	public String getNiu() {
		return niu;
	}






	public void setNiu(String niu) {
		this.niu = niu;
	}






	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", niu=" + niu + "]";
	}






		
	
	
	
	
	
	
	

}
