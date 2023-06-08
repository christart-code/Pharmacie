package com.pharmacie.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.pharmacie.entities.Categorie;
import com.pharmacie.entities.Medicament;
import com.pharmacie.models.ModelMedicament;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class VenteController implements Initializable {
	 @FXML
	    private TextField codeTf;

	    @FXML
	    private TextField libelleTf;

	    @FXML
	    private TextField prixTf;

	    @FXML
	    private Spinner<Integer> qteSp;

	    @FXML
	    private TextField prixTotalTf;

	    @FXML
	    private TableView<Medicament> tableVente;

	    @FXML
	    private TableColumn<Medicament, Integer> colid;

	    @FXML
	    private TableColumn<Medicament, String> colcode;

	    @FXML
	    private TableColumn<Medicament, String> collibelle;

	    @FXML
	    private TableColumn<Medicament, Double> colprixunitaire;

	    @FXML
	    private TableColumn<Medicament, Integer> colquantite;

	    @FXML
	    private TableColumn<Medicament, Double> colprixtotal;

	    @FXML
	    private Button ajouterBtn;

	    @FXML
	    private Button enleverBtn;

	    @FXML
	    private Button enleverToutBtn;

	    @FXML
	    private Button validerBtn;

	    @FXML
	    private TextField reglementEspTf;

	    @FXML
	    private TextField montantTf;

	    @FXML
	    private TextField remboursementEspTf;
	    @FXML
	    private TextField idTf;
	    Medicament medicament=null;
	    List<Medicament> listeMedicaments = new ArrayList<>();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		colid.setCellValueFactory(new PropertyValueFactory<Medicament, Integer>("id"));
		colcode.setCellValueFactory(new PropertyValueFactory<Medicament, String>("code"));
		collibelle.setCellValueFactory(new PropertyValueFactory<Medicament, String>("nomMedica"));
		colprixunitaire.setCellValueFactory(new PropertyValueFactory<Medicament, Double>("prix"));
		colquantite.setCellValueFactory(new PropertyValueFactory<Medicament, Integer>("qteStock"));
		colprixtotal.setCellValueFactory(new PropertyValueFactory<Medicament, Double>("prixTotal"));
		loadSpinValue();
		ajouterBtn.setOnAction(e->{
			loadMedicamentToChart();
		});
	}
	public void loadSpinValue() {
			SpinnerValueFactory<Integer> valueFactory=new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 999999999);
			valueFactory.setValue(1);
			qteSp.setValueFactory(valueFactory);
		}
	@FXML
	public void searchMediByCode(KeyEvent event) {
		String code = codeTf.getText();
		ModelMedicament mm =new ModelMedicament();
		Medicament medicament = new Medicament();
		
		if(event.getCode()==KeyCode.TAB) {
			medicament=mm.findCode(code);
			System.out.println(medicament);
			idTf.setText(""+medicament.getId());
			libelleTf.setText(medicament.getNomMedica());
			prixTf.setText(""+medicament.getPrix());
			int quantite = qteSp.getValue();
			prixTotalTf.setText(""+quantite*medicament.getPrix());
		}
		
	}
	@FXML
	public void spinnerPress(KeyEvent event) {
		if(event.getCode()==KeyCode.TAB) {
			int quantite = qteSp.getValue();
			double prixU = Double.parseDouble(prixTf.getText());
			prixTotalTf.setText(""+quantite*prixU);
		}
	}
	
	
	public void ajouter(ActionEvent event) {
		  
	  }
	  public void loadMedicament() {
		  ModelMedicament mm = new ModelMedicament();
		  medicament = new Medicament(Integer.parseInt(idTf.getText()),
				  libelleTf.getText(),codeTf.getText(),Double.parseDouble(prixTf.getText()),
				  qteSp.getValue(),Double.parseDouble(prixTotalTf.getText())
				  );
		  //recuperation de la quantite en stock
		  int quantiteStock = mm.getQteStockMedicament(medicament);
		  if(qteSp.getValue() > quantiteStock) {
			  Alert mBox = new Alert(AlertType.ERROR);
			  mBox.setTitle("Quantité insuffisante");
			  mBox.setContentText("la quantité en stock est insuffisante");
			  mBox.showAndWait();
		  }
		  else {
			  listeMedicaments.add(medicament);
			  
		  }
	    }
	  
	  public void loadMedicamentToChart() {
		  loadMedicament();
		  ObservableList<Medicament> medicaments = FXCollections.observableArrayList(listeMedicaments);
		  tableVente.setItems(medicaments);
		  ObservableList<TableColumn<Medicament, ?>> cols = tableVente.getColumns();
		 double cellValue =0;
		  for(int i=0; i<listeMedicaments.size();i++) {
			  TableColumn<Medicament, ?> col = cols.get(5);
			  cellValue = cellValue + (double)col.getCellData(medicaments.get(i));
		  }
		  montantTf.setText(""+cellValue);
		  codeTf.setText("");
		  libelleTf.setText("");
		  prixTf.setText("");
			prixTotalTf.setText("");
			idTf.setText("");
			loadSpinValue();

			
	  }
	  @FXML
	  public void amountPaid(KeyEvent event) {
		  String paidS = reglementEspTf.getText();
		  double paid = 0;
		  if(paidS.trim().length() != 0) {
			  paid = Double.valueOf(paidS);
		  }
		  double subTotal = Double.valueOf(montantTf.getText());
		  double diff = paid - subTotal;
		  remboursementEspTf.setText(""+diff);
	  }

}

