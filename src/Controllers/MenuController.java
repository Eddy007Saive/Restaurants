/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import Models.Produits;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import Interfaces.Ecouteur;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author MEGATRON
 */
public class MenuController implements Initializable {

    @FXML
    private ImageView Image_p;

    @FXML
    private AnchorPane Menu;

    @FXML
    private Label Nom;

    @FXML
    private Label Prix;

    @FXML
    private Button btn_commander;

    @FXML
    private Spinner<?> qt;

    private Produits menu;

    private Image image;
    
    private AnchorPane parent;
    
    private Ecouteur ecouteur;
    
        @FXML
    void click(MouseEvent event) {
            ecouteur.onClickListner(menu);
    }
    

    public void setData(Produits menu,Ecouteur ecouteur) {
        this.menu = menu;
        this.ecouteur=ecouteur;
        Nom.setText(menu.getName());
        Prix.setText(String.valueOf(menu.getPrice()));
        String uri = "file:" + menu.getImage();
        image = new Image(uri, 187, 110, false, true);
        Image_p.setImage(image);


        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
