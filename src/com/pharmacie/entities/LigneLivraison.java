package com.pharmacie.entities;

import java.time.LocalDate;

public class LigneLivraison {
	private int id;
	private double qteLivra;
	private double prixLivra;
	private LocalDate dateExpire;
	
	
	public LigneLivraison() {
		super();
	}


	public LigneLivraison(int id, double qteLivra, double prixLivra, LocalDate dateExpire) {
		super();
		this.id = id;
		this.setQteLivra(qteLivra);
		this.setPrixLivra(prixLivra);
		this.setDateExpire(dateExpire);
	}


	public LigneLivraison(double qteLivra, double prixLivra, LocalDate dateExpire) {
		super();
		this.setQteLivra(qteLivra);
		this.setPrixLivra(prixLivra);
		this.setDateExpire(dateExpire);

	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getQteLivra() {
		return qteLivra;
	}


	public void setQteLivra(double qteLivra) {
		this.qteLivra = qteLivra;
	}


	public double getPrixLivra() {
		return prixLivra;
	}


	public void setPrixLivra(double prixLivra) {
		this.prixLivra = prixLivra;
	}


	public LocalDate getDateExpire() {
		return dateExpire;
	}


	public void setDateExpire(LocalDate dateExpire) {
		this.dateExpire = dateExpire;
	}


	@Override
	public String toString() {
		return "LigneLivraison [id=" + id + ", qteLivra=" + qteLivra + ", prixLivra=" + prixLivra + ", dateExpire="
				+ dateExpire + "]";
	}

	

}
