package com.pharmacie.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.pharmacie.models.UserModel;
import com.pharmacie.tools.Notification;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;

public class ConnexionController implements Initializable {
	@FXML
	private TextField usernameTF;
	@FXML
	private PasswordField passwordPf;
	@FXML
	private Button connectBtn;
	// 
	private Parent root;
	private Stage stage;
	private Scene scene;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
   
	public void login(ActionEvent event) {
		// Récuperation des données du formulaire
		String username= usernameTF.getText();
		String password= passwordPf.getText();
		//System.out.println(username+" "+password);
		//instanciation de la classe UserModel
		UserModel userModel = new UserModel();
		
		//vérification des paramètres de l'utilisateur
		
			if(userModel.isLogin(username,password)) {
				//System.out.println("connecté");
				// appel
				FXMLLoader loader =new FXMLLoader(getClass().getResource("/com/pharmacie/views/Accueil.fxml"));
				
				try {
					// chargement
					root=loader.load();
					// fenetre principale
					stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
					// lieu
					scene=new Scene(root);
					
					stage.setScene(scene); // recuperer la scene
					
					stage.centerOnScreen(); // afficher la fenetre au milieu
					stage.setFullScreen(true); // Occupe toute la fen de l'ordinateur
					
					stage.show(); // montre la scene
					
					Notification.notifSuccess("Paramètres correctes", "Connexion réussie");
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else {
				//System.out.println("pas connecté");
				Notification.notifError("Paramètres incorrectes", "Nom utilisateur ou mot de passe incorrecte");
			}
		
	}
	
}
