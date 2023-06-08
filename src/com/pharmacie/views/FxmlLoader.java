package com.pharmacie.views;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
public class FxmlLoader {
private Pane views;
	
	public Pane getPage(String fileName) {
		try {
			URL fileURL = Main.class.getResource("/com/pharmacie/views/"+fileName+".fxml");
			if(fileName == null) {
				throw new java.io.FileNotFoundException("Document FXML introuvable");
			}
			new FXMLLoader();
			views = FXMLLoader.load(fileURL);
		} catch (Exception e) {
			System.out.println("Pas de page "+fileName+", veuillez vérifier la classe FxmlLoader");
		}
		return views ;
	}
}

