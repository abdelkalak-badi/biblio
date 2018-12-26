/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplicationbiblio;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.iset.dao.ClasseDao;
import com.iset.model.Classe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author BADI-PC
 */
public class ClasseController implements Initializable {

    @FXML
    private VBox btnlivre;
    @FXML
    private Button btn_ajouter_Classe;
    @FXML
    private Button btn_modifier_Classe;
    @FXML
    private Button btn_supprimer_Classe;
    @FXML
    private Button modifier_btn;
    @FXML
    private Button supprimer_btn;
    @FXML
    private Button ajouter_btn;
    @FXML
    private TextField txtClasse;
    @FXML
    private TextField txtId;
    @FXML
    private TableView<Classe> tabClasse;
    @FXML
    private TableColumn<Classe, Integer> idClasse;
    @FXML
    private TableColumn<Classe, String> NomClasse;

    ArrayList<Classe> liste=new ArrayList<Classe>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	Classe c = new Classe();
    	ClasseDao cltDao = new ClasseDao();
		for (Classe cl : cltDao.listerTous())
    		liste.add(new Classe(cl.getId(),cl.getNom()));
		
    	
    	ObservableList<Classe> data = FXCollections.observableArrayList(liste);
    	tabClasse.setItems(data);
    	idClasse.setCellValueFactory(new PropertyValueFactory<Classe,Integer>("id"));
    	NomClasse.setCellValueFactory(new PropertyValueFactory<Classe,String>("nom"));

    	txtId.setVisible(false);
    }    

    @FXML
    private void btnModifierLivre(ActionEvent event) {
    	Classe c=new Classe();
    	c.setNom(txtClasse.getText().toString());
    	ClasseDao cd=new ClasseDao();
    	c.setId(Integer.parseInt(txtId.getText().toString()));
    	cd.modifier(c);
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Modifier Classe");
		alert.setHeaderText("Classe modifié avec succées");
		alert.showAndWait();
		liste.clear();
		for (Classe cl : cd.listerTous())
    		liste.add(new Classe(cl.getId(),cl.getNom()));
		
    	
    	ObservableList<Classe> data = FXCollections.observableArrayList(liste);
    	tabClasse.setItems(data);
    	idClasse.setCellValueFactory(new PropertyValueFactory<Classe,Integer>("id"));
    	NomClasse.setCellValueFactory(new PropertyValueFactory<Classe,String>("nom"));
    }

    @FXML
    private void annuler_Classe(ActionEvent event) {
    	txtClasse.setText("");
    	txtId.setText("");
    }

    @FXML
    private void btnSupprimerClasse(ActionEvent event) {
    	Classe c=new Classe();
    	c.setNom(txtClasse.getText().toString());
    	ClasseDao cd=new ClasseDao();
    	c.setId(Integer.parseInt(txtId.getText().toString()));
    	cd.supprimer(c);
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Supprimer Classe");
		alert.setHeaderText("Classe Supprimer avec succées");
		alert.showAndWait();
		liste.clear();
		for (Classe cl : cd.listerTous())
    		liste.add(new Classe(cl.getId(),cl.getNom()));
	
    	ObservableList<Classe> data = FXCollections.observableArrayList(liste);
    	tabClasse.setItems(data);
    	idClasse.setCellValueFactory(new PropertyValueFactory<Classe,Integer>("id"));
    	NomClasse.setCellValueFactory(new PropertyValueFactory<Classe,String>("nom"));
    }

    @FXML
    private void btnAjouterClasse(ActionEvent event) {
    	Classe c=new Classe();
    	c.setNom(txtClasse.getText().toString());
    	ClasseDao cd=new ClasseDao();
    	cd.ajouter(c);
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Ajouter Classe");
		alert.setHeaderText("Classe ajouté avec succées");
		alert.showAndWait();
		liste.clear();
		for (Classe cl : cd.listerTous())
    		liste.add(new Classe(cl.getId(),cl.getNom()));
		
    	
    	ObservableList<Classe> data = FXCollections.observableArrayList(liste);
    	tabClasse.setItems(data);
    	idClasse.setCellValueFactory(new PropertyValueFactory<Classe,Integer>("id"));
    	NomClasse.setCellValueFactory(new PropertyValueFactory<Classe,String>("nom"));

    }

    @FXML
    private void onclick_ajouter(ActionEvent event) {
        ajouter_btn.setVisible(true);
        modifier_btn.setVisible(false);
        supprimer_btn.setVisible(false);
        txtId.setVisible(false);
      
    }

    @FXML
    private void onclick_modifier(ActionEvent event) {
        ajouter_btn.setVisible(false);
        modifier_btn.setVisible(true);
        supprimer_btn.setVisible(false);
        txtId.setVisible(true);
    }

    @FXML
    private void onclick_supprimer(ActionEvent event) {
    	txtId.setVisible(true);
        ajouter_btn.setVisible(false);
        modifier_btn.setVisible(false);
        supprimer_btn.setVisible(true);
        txtClasse.setVisible(false);
    }
    
}
