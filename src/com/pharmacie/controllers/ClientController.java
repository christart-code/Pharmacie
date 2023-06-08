package com.pharmacie.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.pharmacie.entities.Client;
import com.pharmacie.models.ModelClient;

import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class ClientController implements Initializable {
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {

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
    private TextField searchTf;

    @FXML
    private Button searchBtn;

    @FXML
    private Button printBtn;

    @FXML
    private TableView<Client> tableclientTv;

    @FXML
    private TableColumn<Client, Integer> colid;

    @FXML
    private TableColumn<Client, String> colniu;

    @FXML
    private TableColumn<Client, String> colnom;

    @FXML
    private TableColumn<Client, String> colprenom;

    @FXML
    void delete(ActionEvent event) {
    	int id = idTf.getAnchor();
    	String nom = nomTf.getText();
    	String prenom = prenomTf.getText();
    	String niu = niuTf.getText();
    	
    	ModelClient mc = new ModelClient();
    	Client client = new Client(niu,nom,prenom);
    	mc.delete(client);
    	

    }

    @FXML
    void print(ActionEvent event) {

    }

    @FXML
    void save(ActionEvent event) {
    	String nom = nomTf.getText();
    	String prenom = prenomTf.getText();
    	String niu = niuTf.getText();
    	
    	ModelClient mc = new ModelClient();
    	Client client = new Client(niu,nom,prenom);
    	mc.save(client);
    }

    @FXML
    void search(ActionEvent event) {

    }

    @FXML
    void update(ActionEvent event) {
    	String nom = nomTf.getText();
    	String prenom = prenomTf.getText();
    	String niu = niuTf.getText();
    	
    	ModelClient mc = new ModelClient();
    	Client client = new Client(niu,nom,prenom);
    	mc.update(client);
    }
}
