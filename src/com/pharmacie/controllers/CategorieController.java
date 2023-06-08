package com.pharmacie.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.swing.text.TabableView;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.pharmacie.entities.Categorie;
import com.pharmacie.entities.Medicament;
import com.pharmacie.models.ModelCategorie;
import com.pharmacie.models.ModelMedicament;
import com.pharmacie.tools.ConnexionDB;
import com.pharmacie.tools.Notification;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class CategorieController implements Initializable {
	 @FXML
	    private TextField idTf;

	    @FXML
	    private TextField codeTf;

	    @FXML
	    private TextField libelleTf;

	    @FXML
	    private Button savebtn;

	    @FXML
	    private Button updatebtn;

	    @FXML
	    private Button deletebtn;

	    @FXML
	    private TextField displayTf;

	    @FXML
	    private Button searchbtn;

	    @FXML
	    private Button printbtn;

	@FXML
	private TableView<Categorie> tablecategorie;
	@FXML
	private TableColumn<Categorie, Integer> colid;
	@FXML
	private TableColumn<Categorie, String> colcode;
	@FXML
	private TableColumn<Categorie, String> collibelle;
	ObservableList<Categorie> listM;
	int index = -1;
	Connection conn = null;
	ResultSet resultat,rs;
	PreparedStatement pstmt, ps = null;
	
	
	
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		colid.setCellValueFactory(new PropertyValueFactory<Categorie, Integer>("id"));
		colcode.setCellValueFactory(new PropertyValueFactory<Categorie, String>("code"));
		collibelle.setCellValueFactory(new PropertyValueFactory<Categorie, String>("libelle"));
		//listM=ConnexionDB.getAllCategorie();
		//tablecategorie.setItems(listM);
		loadCategorieTable();
		updatebtn.setDisable(true);
		deletebtn.setDisable(true);

	}
	

	// Event Listener on Button[#savebtn].onAction
	@FXML
	public void save(ActionEvent event) {
		//
		String code=codeTf.getText();
		String libelle=libelleTf.getText();
		if(code.equals("") || libelle.equals("")) {
			Notification.notifWarning("Enregistrement d'une ligne vide", "Les champs code et libéllé sont obligatoires");
		}else {
			Categorie categorie=new Categorie(code, libelle);
			
			ModelCategorie modelCategorie=new ModelCategorie();
			modelCategorie.save(categorie);
			loadCategorieTable();
			codeTf.setText("");
			libelleTf.setText("");
			Notification.notifSuccess("Enregistrement de categorie", "Categorie enregistrée avec succès");
		}
		

	}
	// Event Listener on Button[#updatebtn].onAction
	@FXML
	public void update(ActionEvent event) {
		int id = Integer.parseInt(idTf.getText());
		String code=codeTf.getText();
		String libelle=libelleTf.getText();
		
		Categorie categorie=new Categorie(id,code, libelle);
		
		ModelCategorie modelCategorie=new ModelCategorie();
		modelCategorie.update(categorie);
		loadCategorieTable();
		idTf.setText("");
		codeTf.setText("");
		libelleTf.setText("");
		updatebtn.setDisable(true);
		deletebtn.setDisable(true);

	}
	
	
	// Event Listener on Button[#deletebtn].onAction
	@FXML
	public void delete(ActionEvent event) {
		int id = Integer.parseInt(idTf.getText());
		String code=codeTf.getText();
		String libelle=libelleTf.getText();
		
		Categorie categorie=new Categorie(id,code, libelle);
		
		ModelCategorie modelCategorie=new ModelCategorie();
		Alert mBox = new Alert(AlertType.CONFIRMATION);
		mBox.setTitle("Suppression d'une categorie");
		mBox.setContentText("Voulez-vous vraiment supprimer cette categorie ?");
		Optional<ButtonType> reponse = mBox.showAndWait();
		if(reponse.get()==ButtonType.OK) {
		modelCategorie.delete(categorie);
		loadCategorieTable();
		idTf.setText("");
		codeTf.setText("");
		libelleTf.setText("");
		deletebtn.setDisable(true);
		updatebtn.setDisable(true);
		Notification.notifSuccess("Suppression d'une categorie", "Categorie supprimée avec succès");
		}
	

	}
	// Event Listener on Button[#searchbtn].onAction
	@FXML
	public void search(ActionEvent event) {
		String rech = displayTf.getText();
    	ObservableList<Categorie> categories = FXCollections.observableArrayList();
    	ModelCategorie mc = new ModelCategorie();
    	List<Categorie> liste = mc.findAll();
    	
    	for(Categorie cat : liste) {
    		if(String.valueOf(cat).contains(rech) || String.valueOf(cat).contains(rech.toUpperCase()) || String.valueOf(cat).contains(rech.toLowerCase())) {
    	
    			categories.add(cat);
    		}
    	}
    	tablecategorie.setItems(categories);
	}
	// Event Listener on Button[#printbtn].onAction
	@FXML
	public void print(ActionEvent event) {
		// TODO Autogenerated
	}
	
	@FXML
	public void getSelected(MouseEvent event) {
		index = tablecategorie.getSelectionModel().getSelectedIndex();
		if(index<=-1) {
			return;
		}
		idTf.setText(colid.getCellData(index).toString());
		codeTf.setText(colcode.getCellData(index).toString());
		libelleTf.setText(collibelle.getCellData(index).toString());


	}
	public void loadCategorieTable(){
			ObservableList<Categorie> categories=FXCollections.observableArrayList();
			// recuperer les donnees dans une liste
			ModelCategorie modeleCategorie=new ModelCategorie();
			List<Categorie> categorieList=modeleCategorie.findAll(); 
			
			for ( Categorie cat :categorieList) {
				categories.add(cat);	
			}
			
			tablecategorie.setItems(categories);
		}
	
	
	 @FXML
	    void tableClicked(MouseEvent event) {
		 Categorie categorie = tablecategorie.getSelectionModel().getSelectedItem();
			idTf.setText(String.valueOf(categorie.getId()));
			codeTf.setText(categorie.getCode());
			libelleTf.setText(categorie.getLibelle());
			updatebtn.setDisable(false);
			deletebtn.setDisable(false);
	    }
	
	
}
