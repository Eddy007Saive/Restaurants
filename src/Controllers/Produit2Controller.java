/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import Models.Produits;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author MEGATRON
 */
public class Produit2Controller implements Initializable {

  
    
    

    @FXML
    void Disponible(ActionEvent event) {

    }

    @FXML
    void categorie(ActionEvent event) {

    }

    @FXML
    void choisirImage(ActionEvent event) {

    }

    @FXML
    void fermer(MouseEvent event) {
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Produits produits=new Produits(0, "name", "avalaible", 0, "image");
        System.out.println(produits.getImage());
    }    
    
}
