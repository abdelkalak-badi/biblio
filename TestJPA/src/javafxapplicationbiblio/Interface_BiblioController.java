/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplicationbiblio;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author BADI-PC
 */
public class Interface_BiblioController implements Initializable {

    @FXML
    private Button livre_e;
    @FXML
    private Button livre;
    @FXML
    private Button classe;
    @FXML
    private Button etudiant;
    @FXML
    private Pane root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         Parent pane = null; 
        try {
            pane = FXMLLoader.load(getClass().getResource("LivreEmprunter.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Interface_BiblioController.class.getName()).log(Level.SEVERE, null, ex);
        }
         root.getChildren().setAll(pane);
    }    

    @FXML
    private void onclick_livre(ActionEvent event) throws IOException {
         Parent pane = FXMLLoader.load(getClass().getResource("Livre.fxml")); 
         root.getChildren().setAll(pane);
    }

    @FXML
    private void onclick_Classe(ActionEvent event) throws IOException {
         Parent pane = FXMLLoader.load(getClass().getResource("Classe.fxml")); 
         root.getChildren().setAll(pane);
    }

    @FXML
    private void onclick_Etudiant(ActionEvent event) throws IOException {
         Parent pane = FXMLLoader.load(getClass().getResource("Etudiant.fxml")); 
         root.getChildren().setAll(pane);
    }

    @FXML
    private void onclick_LivreEmprunter(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("LivreEmprunter.fxml")); 
         root.getChildren().setAll(pane);
    }
    
}
