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
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.StringRefAddr;

import com.iset.dao.AdresseDao;
import com.iset.dao.ClasseDao;
import com.iset.dao.EtudiantDao;
import com.iset.dao.LivreDao;
import com.iset.model.Adresse;
import com.iset.model.Classe;
import com.iset.model.Etudiant;
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
import javafx.scene.control.DatePicker;
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
public class EtudiantController implements Initializable {

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
    private TextField txtcin;
    @FXML
    private TextField txtnom;
    @FXML
    private DatePicker DateNess;
    @FXML
    private TextField txtprenom;
    @FXML
    private TextField txtrue;
    @FXML
    private TextField txtpays;
    @FXML
    private TextField txtville;
    @FXML
    private ComboBox<Classe> ClasseEtudiant;
    @FXML
    private TableView<Etudiant> tabEtudiant;
    @FXML
    private TableColumn<Etudiant, String> cin;
    @FXML
    private TableColumn<Etudiant, String> nom;
    @FXML
    private TableColumn<Etudiant, String> prenom;
    @FXML
    private TableColumn<Etudiant, Date> dateness;
    @FXML
    private TableColumn<Etudiant, Classe> classeEtudiant;
    @FXML
    private TableColumn<Etudiant,Adresse> adresse;

    ArrayList<Etudiant> liste=new ArrayList<Etudiant>();
    
    ArrayList<Classe> listeClasse;
    ObservableList<Classe> options ;
    int idc;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	listeClasse=new ArrayList<>();
    	ClasseDao classeDao=new ClasseDao();
    	for (Classe cl : classeDao.listerTous())
    		listeClasse.add(new Classe(cl.getId(),cl.getNom()));
    	options=FXCollections.observableArrayList(listeClasse);
        // TODO
    	
    	ClasseEtudiant.setItems(options);
    	ClasseEtudiant.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				// TODO Auto-generated method stub
				Classe c;
				c=(Classe)newValue;
				idc=c.getId();
				
			}
		});
    	/*addListener(new ChangeListener() {

			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				// TODO Auto-generated method stub
		    	System.out.println("test ok!!!!!!");
				
			}
    		
		});*/
    	
        // TODO 10010101010100000000001010101001010101010101
    	Etudiant c = new Etudiant();
    	EtudiantDao cltDao = new EtudiantDao();
    	
		for (Etudiant cl : cltDao.listerTous())
    	liste.add(new Etudiant(
    			cl.getCin(),cl.getNom(),
    			cl.getPrenom(),
    			cl.getAdresse(),
    			cl.getClasse(), 
    			cl.getDateNaissance())
    			);
		for (Etudiant cl : cltDao.listerTous())
			System.out.println(cl);
    	ObservableList<Etudiant> data = FXCollections.observableArrayList(liste);
    	tabEtudiant.setItems(data);
    	cin.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("Cin"));
    	nom.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("nom"));
    	prenom.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("prenom"));
    	dateness.setCellValueFactory(new PropertyValueFactory<Etudiant,Date>("dateNaissance"));
    	classeEtudiant.setCellValueFactory(new PropertyValueFactory<Etudiant,Classe>("classe"));
    	adresse.setCellValueFactory(new PropertyValueFactory<Etudiant,Adresse>("adresse"));
    }    

    @FXML
    private void btnModifierLivre(ActionEvent event) {
    }

    @FXML
    private void annuler_Classe(ActionEvent event) {
    	txtcin.setText("");
    	txtnom.setText("");
    	txtpays.setText("");
    	txtprenom.setText("");
    	txtrue.setText("");
    	txtville.setText("");
    }

    @FXML
    private void btnSupprimerClasse(ActionEvent event) {
    	Etudiant c=new Etudiant();
    	EtudiantDao cd=new EtudiantDao();
    	c=cd.consulter(c, txtcin.getText().toString());
    	Adresse adr=new Adresse();
    	AdresseDao adrDao =new AdresseDao();
    	adrDao.supprimer(c.adresse);
    	cd.supprimer(c);

    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Ajouter Livre");
		alert.setHeaderText("Livre ajouté avec succées");
		alert.showAndWait();
    	liste.clear();
    	
		for (Etudiant cl1 : cd.listerTous())
    	liste.add(new Etudiant(
    			cl1.getCin(),cl1.getNom(),
    			cl1.getPrenom(),
    			cl1.getAdresse(),
    			cl1.getClasse(), 
    			cl1.getDateNaissance())
    			);
	
    	ObservableList<Etudiant> data = FXCollections.observableArrayList(liste);
    	tabEtudiant.setItems(data);
    	cin.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("Cin"));
    	nom.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("nom"));
    	prenom.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("prenom"));
    	dateness.setCellValueFactory(new PropertyValueFactory<Etudiant,Date>("dateNaissance"));
    	classeEtudiant.setCellValueFactory(new PropertyValueFactory<Etudiant,Classe>("classe"));
    	adresse.setCellValueFactory(new PropertyValueFactory<Etudiant,Adresse>("adresse"));
    }

    @FXML
    private void btnAjouterClasse(ActionEvent event) {
    	
    	Adresse adr=new Adresse();
    	adr.setPays(txtpays.getText().toString());
    	adr.setVille(txtville.getText().toString());
    	adr.setRue(txtrue.getText().toString());
    	AdresseDao adrDao =new AdresseDao();
    	adrDao.ajouter(adr);
    	
    	
    	LocalDate ld = DateNess.getValue();
    	Calendar ca =  Calendar.getInstance();
    	ca.set(ld.getYear(), ld.getMonthValue() - 1, ld.getDayOfMonth());
    	Date date = ca.getTime();
    	System.out.println(date);
    	Etudiant c=new Etudiant();
    	c.setCin(txtcin.getText().toString());
    	c.setNom(txtnom.getText().toString());
    	c.setPrenom(txtprenom.getText().toString());
    	c.setDateNaissance(date);
        c.setAdresse(adr);
        ClasseDao classedao=new ClasseDao();
        Classe cccc=new Classe();
        c.setClasse(classedao.consulter(cccc, idc));
        Adresse fina = endAdresse();
        c.setAdresse(fina);
        EtudiantDao cd=new EtudiantDao();
    	cd.ajouter(c);
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Ajouter Livre");
		alert.setHeaderText("Livre ajouté avec succées");
		alert.showAndWait();
    	liste.clear();
    	
		for (Etudiant cl1 : cd.listerTous())
    	liste.add(new Etudiant(
    			cl1.getCin(),cl1.getNom(),
    			cl1.getPrenom(),
    			cl1.getAdresse(),
    			cl1.getClasse(), 
    			cl1.getDateNaissance())
    			);
	
    	ObservableList<Etudiant> data = FXCollections.observableArrayList(liste);
    	tabEtudiant.setItems(data);
    	cin.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("Cin"));
    	nom.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("nom"));
    	prenom.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("prenom"));
    	dateness.setCellValueFactory(new PropertyValueFactory<Etudiant,Date>("dateNaissance"));
    	classeEtudiant.setCellValueFactory(new PropertyValueFactory<Etudiant,Classe>("classe"));
    	adresse.setCellValueFactory(new PropertyValueFactory<Etudiant,Adresse>("adresse"));
    }

    private Adresse endAdresse() {
		// TODO Auto-generated method stub
    	Adresse a=new Adresse();
    	AdresseDao ad =new AdresseDao();
    	List<Adresse> listead = new ArrayList<Adresse>();
    	listead=ad.listerTous();
    	a=listead.get(listead.size()-1);
    	
    	
		return a;
	}

	@FXML
    private void onclick_ajouter(ActionEvent event) {
        ajouter_btn.setVisible(true);
        modifier_btn.setVisible(false);
        supprimer_btn.setVisible(false);
        System.out.println(endAdresse().getId());
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
