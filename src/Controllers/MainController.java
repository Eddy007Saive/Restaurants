/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author MEGATRON
 */
public class MainController implements Initializable{


    @FXML
    private Button btn_Mimg;

    @FXML
    private Button btn_delP;

    @FXML
    private Button btn_modifP;

    @FXML
    private AnchorPane form_utilisateur;

    @FXML
    private AnchorPane form_reservation;

    @FXML
    private AnchorPane form_commande;


    @FXML
    private Button btn_addP;

    @FXML
    private Button btn_adm_ajout;

    @FXML
    private Button btn_adm_ajout1;

    @FXML
    private Button btn_adm_ajout11;

    @FXML
    private Button btn_admin;

    @FXML
    private Button btn_com;

    @FXML
    private Button btn_details;

    @FXML
    private Button btn_imgP;

    @FXML
    private Button btn_inv;

    @FXML
    private Button btn_menu;

    @FXML
    private Button btn_reservation;

    @FXML
    private FontAwesomeIconView btn_recherche;

    @FXML
    private AnchorPane pop;


   
    @FXML
    private AnchorPane form_produit;

    @FXML
    private AnchorPane ff;

    @FXML
    private ImageView imageP;

    @FXML
    private AnchorPane menu_p;

    @FXML
    private GridPane menu_grid;

    @FXML
    private GridPane menu_gridT;

    @FXML
    private ScrollPane menu_scroll;

   

   

    @FXML
    void Switch(ActionEvent event) throws SQLException, IOException {
        if (event.getSource() == btn_admin) {
            form_utilisateur.setVisible(true);
            form_produit.setVisible(false);
            form_reservation.setVisible(false);
            form_commande.setVisible(false);
            

        } else if (event.getSource() == btn_inv) {
            form_produit.setVisible(true);
            form_utilisateur.setVisible(false);
            form_reservation.setVisible(false);
            form_commande.setVisible(false);
            
        } else if (event.getSource() == btn_reservation) {
            form_produit.setVisible(false);
            form_utilisateur.setVisible(false);
            form_reservation.setVisible(true);
            form_commande.setVisible(false);
           

        } else if (event.getSource() == btn_com) {
            form_produit.setVisible(false);
            form_utilisateur.setVisible(false);
            form_reservation.setVisible(false);
            form_commande.setVisible(true);
            
        }
    }

   
    
    
        @Override
    public void initialize(URL url, ResourceBundle rb) {
     

    }
}
