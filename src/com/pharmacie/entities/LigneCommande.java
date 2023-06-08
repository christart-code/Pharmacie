package com.pharmacie.entities;

import java.util.ArrayList;
import java.util.List;


public class LigneCommande {
	private int id;
	private double qteLiCom;
	private CommandeAchat commandeAchat;
	private List<Medicament> medicaments=new ArrayList<>();

	
	
	public LigneCommande() {
		super();
	}


	public LigneCommande(int id, double qteLiCom) {
		super();
		this.id = id;
		this.setQteLiCom(qteLiCom);
	}


	public LigneCommande(double qteLiCom) {
		super();
		this.setQteLiCom(qteLiCom);
	}


	public int getId() {
		return id;
	}


	


	public double getQteLiCom() {
		return qteLiCom;
	}


	public void setQteLiCom(double qteLiCom) {
		this.qteLiCom = qteLiCom;
	}


	public CommandeAchat getCommandeAchat() {
		return commandeAchat;
	}


	public void setCommandeAchat(CommandeAchat commandeAchat) {
		this.commandeAchat = commandeAchat;
	}


	public List<Medicament> getMedicaments() {
		return medicaments;
	}


	public void setMedicaments(List<Medicament> medicaments) {
		this.medicaments = medicaments;
	}


	@Override
	public String toString() {
		return "LigneCommande [id=" + id + ", qteLiCom=" + qteLiCom + ", commandeAchat=" + commandeAchat
				+ ", medicaments=" + medicaments + "]";
	}


	


}
