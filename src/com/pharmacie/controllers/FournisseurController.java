package com.pharmacie.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.pharmacie.entities.Fournisseur;

import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class FournisseurController implements Initializable {
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	 @FXML
	    private TextField idTf;

	    @FXML
	    private TextField niuTf;

	    @FXML
	    private TextField nomTf;

	    @FXML
	    private TextField prenomTf;

	    @FXML
	    private Button saveBtn;

	    @FXML
	    private Button updateBtn;

	    @FXML
	    private Button deleteBtn;

	    @FXML
	    private Button searchBtn;

	    @FXML
	    private Button printBtn;

	    @FXML
	    private TableView<Fournisseur> tablefournisseurTv;

	    @FXML
	    private TableColumn<Fournisseur, Integer> colid;

	    @FXML
	    private TableColumn<Fournisseur, String> colniu;

	    @FXML
	    private TableColumn<Fournisseur, String> colnom;

	    @FXML
	    private TableColumn<Fournisseur, String> colprenom;
	    
	    @FXML
	    void delete(ActionEvent event) {

	    }

	    @FXML
	    void print(ActionEvent event) {

	    }

	    @FXML
	    void save(ActionEvent event) {

	    }

	    @FXML
	    void search(ActionEvent event) {

	    }

	    @FXML
	    void update(ActionEvent event) {

	    }

}
