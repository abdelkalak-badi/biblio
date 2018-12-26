/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplicationbiblio;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.iset.dao.ClasseDao;
import com.iset.dao.EtudiantDao;
import com.iset.dao.EtudiantLivreDao;
import com.iset.dao.LivreDao;
import com.iset.model.Adresse;
import com.iset.model.Classe;
import com.iset.model.Etudiant;
import com.iset.model.Etudiant_Livre;
import com.iset.model.Livre;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author BADI-PC
 */
public class LivreEmprunterController implements Initializable {

    @FXML
    private Button modifier_btn;
    @FXML
    private Button supprimer_btn;
    @FXML
    private Button ajouter_btn;
    @FXML
    private VBox btnlivre;
    @FXML
    private Button btn_ajouter_Classe;
    @FXML
    private Button btn_modifier_Classe;
    @FXML
    private Button btn_supprimer_Classe;
    @FXML
    private ComboBox<Livre> Llivre;
    @FXML
    private ComboBox<Etudiant> Letudiant;
    @FXML
    private TableView<Etudiant_Livre> tabEmprunter;
    @FXML
    private TableColumn<Etudiant_Livre, Livre> livteE;
    @FXML
    private TableColumn<Etudiant_Livre, Etudiant> etudiantE;
    
    Etudiant idEtudiant ;
    Livre idLlivre;
    ArrayList<Etudiant_Livre> liste;
    ArrayList<Etudiant> listeEtudiant;
    ArrayList<Livre> listeLivre;
    
    ObservableList<Livre> optionsLivre ;
    ObservableList<Etudiant> optionsEtudiant ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	listeEtudiant=new ArrayList<>();
    	EtudiantDao Dao=new EtudiantDao();
    	for (Etudiant cl : Dao.listerTous())
    		listeEtudiant.add(new Etudiant(
        			cl.getCin(),cl.getNom(),
        			cl.getPrenom(),
        			cl.getAdresse(),
        			cl.getClasse(), 
        			cl.getDateNaissance())
        			);
    	optionsEtudiant=FXCollections.observableArrayList(listeEtudiant);
        // TODO
    	
    	Letudiant.setItems(optionsEtudiant);
    	Letudiant.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				// TODO Auto-generated method stub
				Etudiant c;
				c=(Etudiant)newValue;
				idEtudiant=c;
				
			}
		});
        // TODO
    	
    	listeLivre=new ArrayList<>();
    	LivreDao Dao1=new LivreDao();
    	for (Livre cl : Dao1.listerTous())
    		listeLivre.add(new Livre(cl.getId(),cl.getAuteur(),cl.getTitre(),cl.getDateEdition()));
    	optionsLivre=FXCollections.observableArrayList(listeLivre);
        // TODO
    	
    	Llivre.setItems(optionsLivre);
    	Llivre.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				// TODO Auto-generated method stub
				Livre c;
				c=(Livre)newValue;
				idLlivre=c;
				
			}
		});
    	
    	//TABLE
    	/*
    	EtudiantLivreDao cltDao = new EtudiantLivreDao();
		for (Etudiant_Livre EL1 : cltDao.listerTous()){
			liste.add(new Etudiant_Livre(EL1.getEtudiantID(),EL1.getLivreID()));
		}
    	
        System.out.println("--------------------------------------------------------------------");
        
		for (Etudiant_Livre EL1 : cltDao.listerTous())
			System.out.println(EL1);
		
		System.out.println("--------------------------------------------------------------------");
    	ObservableList<Etudiant_Livre> data = FXCollections.observableArrayList(liste);
    	tabEmprunter.setItems(data);
    	livteE.setCellValueFactory(new PropertyValueFactory<Etudiant_Livre, Livre>("EtudiantID"));
    	etudiantE.setCellValueFactory(new PropertyValueFactory<Etudiant_Livre, Etudiant >("LivreID"));

    	
    	*/
    }    

    @FXML
    private void btnModifierLivre(ActionEvent event) {
    }

    @FXML
    private void annuler_Classe(ActionEvent event) {
    }

    @FXML
    private void btnSupprimerClasse(ActionEvent event) {
    }

    @FXML
    private void btnAjouterClasse(ActionEvent event) {
    	System.out.println(idEtudiant.getCin());
    	System.out.println(idLlivre.getId());
    	EtudiantLivreDao etldao = new EtudiantLivreDao();
    	etldao.Ajouter_dones_Liste_livre(idEtudiant, idLlivre);
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Ajouter Livre");
		alert.setHeaderText("Livre ajouté avec succées");
		alert.showAndWait();
    }

    @FXML
    private void onclick_ajouter(ActionEvent event) {
        ajouter_btn.setVisible(true);
        modifier_btn.setVisible(false);
        supprimer_btn.setVisible(false);
    }

    @FXML
    private void onclick_modifier(ActionEvent event) {
        ajouter_btn.setVisible(false);
        modifier_btn.setVisible(true);
        supprimer_btn.setVisible(false);
    }

    @FXML
    private void onclick_supprimer(ActionEvent event) {
        ajouter_btn.setVisible(false);
        modifier_btn.setVisible(false);
        supprimer_btn.setVisible(true);
    }
    
}
