package com.pharmacie.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class CommandeAchat {
  private int id;
  private LocalDate datecom;
  private double somme;
  private List<LigneCommande> lignecommandes= new ArrayList<>();
  
  
public CommandeAchat() {
	super();
}


public CommandeAchat(LocalDate datecom, double somme) {
	super();
	this.setDatecom(datecom);
	this.setSomme(somme);
}


public CommandeAchat(int id, LocalDate datecom, double somme) {
	super();
	this.id = id;
	this.setDatecom(datecom);
	this.setSomme(somme);
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public LocalDate getDatecom() {
	return datecom;
}


public void setDatecom(LocalDate datecom) {
	this.datecom = datecom;
}


public double getSomme() {
	return somme;
}


public void setSomme(double somme) {
	this.somme = somme;
}


@Override
public String toString() {
	return "CommandeAchat [id=" + id + ", datecom=" + datecom + ", somme=" + somme + "]";
}
  
  
	
	
	
	
}
