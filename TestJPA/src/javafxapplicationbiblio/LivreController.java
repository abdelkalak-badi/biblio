/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplicationbiblio;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import com.iset.dao.ClasseDao;
import com.iset.dao.LivreDao;
import com.iset.model.Classe;
import com.iset.model.Etudiant;
import com.iset.model.Livre;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author BADI-PC
 */
public class LivreController implements Initializable {

    @FXML
    private VBox btnlivre;
    @FXML
    private Button btn_ajouter_livre;
    @FXML
    private Button btn_modifier_livre;
    @FXML
    private Button btn_supprimer_livre;
    @FXML
    private TextField txtTitre;
    
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtAuteur;
    @FXML
    private DatePicker DateEdition;
    @FXML
    private Button modifier_btn;
    @FXML
    private Button supprimer_btn;
    @FXML
    private Button ajouter_btn;
    @FXML
    private TableView<Livre> tabLivre;
    @FXML
    private TableColumn<Livre, Integer> codelLivre;
    @FXML
    private TableColumn<Livre, String> AuteurLivre;
    @FXML
    private TableColumn<Livre, String> TitreLivre;
    @FXML
    private TableColumn<Livre, Date> DateLivre;

    
    ArrayList<Livre> liste=new ArrayList<Livre>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	 txtId.setVisible(false);
    	Livre c = new Livre();
    	LivreDao cltDao = new LivreDao();
    	
		for (Livre cl : cltDao.listerTous())
    		liste.add(new Livre(cl.getId(),cl.getAuteur(),cl.getTitre(),cl.getDateEdition()));
		
		
		
    	
    	ObservableList<Livre> data = FXCollections.observableArrayList(liste);
    	tabLivre.setItems(data);
    	codelLivre.setCellValueFactory(new PropertyValueFactory<Livre,Integer>("id"));
    	AuteurLivre.setCellValueFactory(new PropertyValueFactory<Livre,String>("auteur"));
    	TitreLivre.setCellValueFactory(new PropertyValueFactory<Livre,String>("titre"));
    	DateLivre.setCellValueFactory(new PropertyValueFactory<Livre,Date>("dateEdition"));

    
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
    	 txtId.setVisible(true);
        ajouter_btn.setVisible(false);
        modifier_btn.setVisible(true);
        supprimer_btn.setVisible(false);
    }

    @FXML
    private void onclick_supprimer(ActionEvent event) {
    	 txtId.setVisible(true);
        ajouter_btn.setVisible(false);
        modifier_btn.setVisible(false);
        supprimer_btn.setVisible(true);
    }

    @FXML
    private void btnModifierLivre(ActionEvent event) {
    	/*System.out.println(DateEdition.getAccessibleText());
    	//System.out.println(DateEdition.);*/
    	LocalDate ld = DateEdition.getValue();
    	Calendar ca =  Calendar.getInstance();
    	ca.set(ld.getYear(), ld.getMonthValue() - 1, ld.getDayOfMonth());
    	Date date = ca.getTime();
    	
    	Livre c=new Livre();
    	c.setId(Integer.parseInt(txtId.getText().toString()));
    	c.setAuteur(txtAuteur.getText().toString());
    	c.setTitre(txtTitre.getText().toString());
        c.setDateEdition(date);
    	LivreDao cd=new LivreDao();
    	cd.modifier(c);
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Modifier Livre");
		alert.setHeaderText("Livre modifié avec succées");
		alert.showAndWait();
	 	liste.clear();
		for (Livre cl : cd.listerTous())
    		liste.add(new Livre(cl.getId(),cl.getAuteur(),cl.getTitre(),cl.getDateEdition()));
		
		
		
    	
    	ObservableList<Livre> data = FXCollections.observableArrayList(liste);
    	tabLivre.setItems(data);
    	codelLivre.setCellValueFactory(new PropertyValueFactory<Livre,Integer>("id"));
    	AuteurLivre.setCellValueFactory(new PropertyValueFactory<Livre,String>("auteur"));
    	TitreLivre.setCellValueFactory(new PropertyValueFactory<Livre,String>("titre"));
    	DateLivre.setCellValueFactory(new PropertyValueFactory<Livre,Date>("dateEdition"));

    
    }

    @FXML
    private void annuler_Livre(ActionEvent event) {
    	txtId.setText("");
    	txtAuteur.setText("");
    	txtTitre.setText("");
    }

    @FXML
    private void btnSupprimerLivre(ActionEvent event) {

    	Livre c=new Livre();
    	c.setId(Integer.parseInt(txtId.getText().toString()));
    	c.setAuteur(txtAuteur.getText().toString());
    	c.setTitre(txtTitre.getText().toString());
    //c.setDateEdition();
    	LivreDao cd=new LivreDao();
    	cd.supprimer(c);
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Supprimer Livre");
		alert.setHeaderText("Livre supprimé avec succées");
		alert.showAndWait();
	 	liste.clear();
		for (Livre cl : cd.listerTous())
    		liste.add(new Livre(cl.getId(),cl.getAuteur(),cl.getTitre(),cl.getDateEdition()));
		
		
		
    	
    	ObservableList<Livre> data = FXCollections.observableArrayList(liste);
    	tabLivre.setItems(data);
    	codelLivre.setCellValueFactory(new PropertyValueFactory<Livre,Integer>("id"));
    	AuteurLivre.setCellValueFactory(new PropertyValueFactory<Livre,String>("auteur"));
    	TitreLivre.setCellValueFactory(new PropertyValueFactory<Livre,String>("titre"));
    	DateLivre.setCellValueFactory(new PropertyValueFactory<Livre,Date>("dateEdition"));


    }

    @FXML
    private void btnAjouterLivre(ActionEvent event) {
    	
    	LocalDate ld = DateEdition.getValue();
    	Calendar ca =  Calendar.getInstance();
    	ca.set(ld.getYear(), ld.getMonthValue() - 1, ld.getDayOfMonth());
    	Date date = ca.getTime();
    	System.out.println(date);
    	Livre c=new Livre();
    	
    	c.setAuteur(txtAuteur.getText().toString());
    	
    	c.setTitre(txtTitre.getText().toString());
    
        c.setDateEdition(date);
        System.out.println(c);
    	LivreDao cd=new LivreDao();
    	cd.ajouter(c);
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Ajouter Livre");
		alert.setHeaderText("Livre ajouté avec succées");
		alert.showAndWait();
    	liste.clear();
		for (Livre cl : cd.listerTous())
    		liste.add(new Livre(cl.getId(),cl.getAuteur(),cl.getTitre(),cl.getDateEdition()));
		
		
		
    	
    	ObservableList<Livre> data = FXCollections.observableArrayList(liste);
    	tabLivre.setItems(data);
    	codelLivre.setCellValueFactory(new PropertyValueFactory<Livre,Integer>("id"));
    	AuteurLivre.setCellValueFactory(new PropertyValueFactory<Livre,String>("auteur"));
    	TitreLivre.setCellValueFactory(new PropertyValueFactory<Livre,String>("titre"));
    	DateLivre.setCellValueFactory(new PropertyValueFactory<Livre,Date>("dateEdition"));


    }

    
}
