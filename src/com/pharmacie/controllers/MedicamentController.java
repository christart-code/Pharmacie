package com.pharmacie.controllers;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

import org.omg.CORBA.portable.ValueFactory;

import com.mysql.jdbc.PreparedStatement;
import com.pharmacie.entities.Categorie;
import com.pharmacie.entities.Medicament;
import com.pharmacie.models.ModelCategorie;
import com.pharmacie.models.ModelMedicament;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


public class MedicamentController implements Initializable {
	 @FXML
	    private TextField idTf;

	    @FXML
	    private TextField nomTf;

	    @FXML
	    private TextField codeTf;

	    @FXML
	    private TextField prixTf;

	    @FXML
	    private Spinner<Integer> qteStockSp; 

	    @FXML
	    private ComboBox<Categorie> categorieCb;
	    
	    @FXML
	    private Button deleteBtn;
	    
	    @FXML
	    private Button updateBtn;

	    @FXML
	    private Button saveBtn;
	    
	    @FXML
	    private TextField displayTf;

	    @FXML
	    private Button searchBtn;

	    @FXML
	    private Button printBtn;

	    @FXML
	    private TableView<Medicament> medicamentTv;

	    @FXML
	    private TableColumn<Medicament, Integer> idCol;

	    @FXML
	    private TableColumn<Medicament, String> codeCol;

	    @FXML
	    private TableColumn<Medicament, String> nomCol;

	    @FXML
	    private TableColumn<Medicament, Float> prixCol;

	    @FXML
	    private TableColumn<Medicament, Integer> qteCol;

	    @FXML
	    private TableColumn<Medicament, Categorie> categorieCol;
	    PreparedStatement pstmt;
	    
	    
	    @Override
		public void initialize(URL location, ResourceBundle resources) {
	    	idCol.setCellValueFactory(new PropertyValueFactory<Medicament, Integer>("id"));
			nomCol.setCellValueFactory(new PropertyValueFactory<Medicament, String>("nomMedica"));
			codeCol.setCellValueFactory(new PropertyValueFactory<Medicament, String>("code"));
			prixCol.setCellValueFactory(new PropertyValueFactory<Medicament, Float>("prix"));
			qteCol.setCellValueFactory(new PropertyValueFactory<Medicament, Integer>("qteStock"));
			categorieCol.setCellValueFactory(new PropertyValueFactory<Medicament, Categorie>("categorie"));

			loadCategorie();
			loadMedicamentTable();
	    	loadSpinValue();
	 
	    	
		}
	    @FXML
	    void delete(ActionEvent event) {

	    }

	    @FXML
	    void print(ActionEvent event) {

	    }

	    @FXML
	    void save(ActionEvent event) {
	    	String nom=nomTf.getText();
	    	String code=codeTf.getText();
	    	Double prix=Double.parseDouble(prixTf.getText());
	    	int qte=qteStockSp.getValue();
	    	Categorie categorie =  categorieCb.getValue();


			Medicament medicament = new Medicament(nom, code, prix, qte, categorie);
			ModelMedicament mm = new ModelMedicament();
			mm.save(medicament);
			
			
			loadMedicamentTable();
			codeTf.setText("");
			nomTf.setText("");
			prixTf.setText("");
			
			categorieCb.setValue(null);
	    }

	    @FXML
	    void search(ActionEvent event) {
	    	String rech = displayTf.getText();
	    	ObservableList<Medicament> medicaments = FXCollections.observableArrayList();
	    	ModelMedicament mm = new ModelMedicament();
	    	List<Medicament> liste = mm.findAll();
	    	
	    	for(Medicament med : liste) {
	    		if(String.valueOf(med).contains(rech) || String.valueOf(med).contains(rech.toUpperCase()) || String.valueOf(med).contains(rech.toLowerCase())) {
	    	
	    			medicaments.add(med);
	    		}
	    	}
	    	medicamentTv.setItems(medicaments);
	    }

	    @FXML
	    void update(ActionEvent event) {

	    }
	    
 		public void loadMedicamentTable(){
 			ObservableList<Medicament> medicaments=FXCollections.observableArrayList();
 			// recuperer les donnees dans une liste
 			ModelMedicament mm =new ModelMedicament();
 			List<Medicament> medicamentList=mm.findAll(); 
 			
 			for ( Medicament med : medicamentList) {
 				medicaments.add(med);	
 			}
 			
 			medicamentTv.setItems(medicaments);
 		}
 		 // methode qui charge les informations dans le combo
 		public void loadCategorie(){
 			ObservableList<Categorie> categories=FXCollections.observableArrayList();
 			// recuperer les donnees dans une liste
 			ModelCategorie mm =new ModelCategorie();
 			List<Categorie> categorieList = mm.findAll(); 
 			
 			for ( Categorie cat : categorieList) {
 				categories.add(cat);	
 			}
 			
 			categorieCb.setItems(categories);
 		}
 		
 		public void loadSpinValue() {
 			SpinnerValueFactory<Integer> valueFactory=new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 999999999);
 			valueFactory.setValue(1);
 			qteStockSp.setValueFactory(valueFactory);
 		}

 		
		
 		 @FXML
 	    void tableClicked(MouseEvent event) {
 		 Medicament medicament = medicamentTv.getSelectionModel().getSelectedItem();
 			idTf.setText(String.valueOf(medicament.getId()));
 			nomTf.setText(medicament.getNomMedica());
 			codeTf.setText(medicament.getCode());;
 			prixTf.setText(String.valueOf(medicament.getPrix()));
 			//qteStockSp.setValueFactory(medicament.getQteStock());
 			categorieCb.setValue(medicament.getCategorie());
 			qteStockSp.getValueFactory().setValue(medicament.getQteStock());

 		 }
 	
	
}
