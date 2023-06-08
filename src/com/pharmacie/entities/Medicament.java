 package com.pharmacie.entities;


public class Medicament {
	private int id;
	private String nomMedica;
	private String code;
	private double prix;
	private int qteStock;
	private Categorie categorie;
	private double prixTotal;
	public Medicament() {
		super();
	}
	public Medicament(String nomMedica, String code, double prix, int qteStock, Categorie categorie) {
		super();
		this.nomMedica = nomMedica;
		this.code = code;
		this.prix = prix;
		this.qteStock = qteStock;
		this.categorie = categorie;
	}
	public Medicament(int id, String nomMedica, String code, double prix, int qteStock, Categorie categorie) {
		super();
		this.id = id;
		this.nomMedica = nomMedica;
		this.code = code;
		this.prix = prix;
		this.qteStock = qteStock;
		this.categorie = categorie;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomMedica() {
		return nomMedica;
	}
	public void setNomMedica(String nomMedica) {
		this.nomMedica = nomMedica;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQteStock() {
		return qteStock;
	}
	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	public Medicament(int id, String nomMedica, String code, double prix, int qteStock, double prixTotal) {
		super();
		this.id = id;
		this.nomMedica = nomMedica;
		this.code = code;
		this.prix = prix;
		this.qteStock = qteStock;
		this.prixTotal = prixTotal;
	}
	public double getPrixTotal() {
		return prixTotal;
	}
	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}
	@Override
	public String toString() {
		return  id + " " + nomMedica + " " + code + " " + prix + " "
				+ qteStock + " " + categorie ;
	}
	
	
	
	

}
