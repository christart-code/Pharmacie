package com.pharmacie.controllers;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import com.pharmacie.views.FxmlLoader;
import javafx.event.ActionEvent;

import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class AccueilController {
	@FXML
	private VBox leftPane;
	@FXML
	private Button medicamentBtn;
	@FXML
	private Button clientBtn;
	@FXML
	private Button fournisseurBtn;
	@FXML
	private Button commandeBtn;
	@FXML
	private Button livraisonBtn;
	@FXML
	private Button categorieBtn;
	@FXML
	private Button eBtn;
	@FXML
	private Pane topPane;
	
	@FXML
	private BorderPane borderPane;

	// Event Listener on Button[#medicamentBtn].onAction
	@FXML
	public void loadMedicament(ActionEvent event) {
		//System.out.println("Bouton medicament cliqué");
		FxmlLoader fxmlLoader=new FxmlLoader();
		Pane pane=fxmlLoader.getPage("Medicament");
		//System.out.println();
		
		// Charger la page au milieu du border pane
		borderPane.setCenter(pane);
		
	}
	// Event Listener on Button[#clientBtn].onAction
	@FXML
	public void loadClient(ActionEvent event) {
		// 
		FxmlLoader fxmlLoader=new FxmlLoader();
		Pane pane=fxmlLoader.getPage("Client");
		borderPane.setCenter(pane);
	}
	// Event Listener on Button[#fournisseurBtn].onAction
	@FXML
	public void loadFournisseur(ActionEvent event) {
		// 
		FxmlLoader fxmlLoader=new FxmlLoader();
		Pane pane=fxmlLoader.getPage("Fournisseur");
		borderPane.setCenter(pane);
	}
	// Event Listener on Button[#commandeBtn].onAction
	@FXML
	public void loadVente(ActionEvent event) {
		//
		FxmlLoader fxmlLoader=new FxmlLoader();
		Pane pane=fxmlLoader.getPage("Vente");
		borderPane.setCenter(pane);
	}
	// Event Listener on Button[#livraisonBtn].onAction
	@FXML
	public void loadAchat(ActionEvent event) {
		//
		FxmlLoader fxmlLoader=new FxmlLoader();
		Pane pane=fxmlLoader.getPage("Achat");
		borderPane.setCenter(pane);
		
	}
	// Event Listener on Button[#categorieBtn].onAction
	@FXML
	public void loadCategorie(ActionEvent event) {
		
		FxmlLoader fxmlLoader=new FxmlLoader();
		Pane pane=fxmlLoader.getPage("Categorie");
		borderPane.setCenter(pane);
		
	}
	// Event Listener on Button[#eBtn].onAction
	@FXML
	public void loadEmploye(ActionEvent event) {
		//
		FxmlLoader fxmlLoader=new FxmlLoader();
		Pane pane=fxmlLoader.getPage("Employe");
		borderPane.setCenter(pane);
	}
}
