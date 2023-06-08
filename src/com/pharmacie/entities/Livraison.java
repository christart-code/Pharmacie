package com.pharmacie.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class Livraison {
	private int id;
	private String dateLivrai;
	private Fournisseur fournisseur;
	public Livraison() {
		super();
	}
	public Livraison(int id, String dateLivrai, Fournisseur fournisseur) {
		super();
		this.id = id;
		this.dateLivrai = dateLivrai;
		this.fournisseur = fournisseur;
	}
	public Livraison(String dateLivrai, Fournisseur fournisseur) {
		super();
		this.dateLivrai = dateLivrai;
		this.fournisseur = fournisseur;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDateLivrai() {
		return dateLivrai;
	}
	public void setDateLivrai(String dateLivrai) {
		this.dateLivrai = dateLivrai;
	}
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	@Override
	public String toString() {
		return "Livraison [id=" + id + ", dateLivrai=" + dateLivrai + ", fournisseur=" + fournisseur + "]";
	}
	
	
}
