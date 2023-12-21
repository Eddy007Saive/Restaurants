/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers.Menu;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author MEGATRON
 */
public class ProduitController implements Initializable {

    @FXML
    private AnchorPane form_produit;
    @FXML
    private AnchorPane menu_p;
    @FXML
    private TableView<?> tableP;
    @FXML
    private TableColumn<?, ?> TP_id;
    @FXML
    private TableColumn<?, ?> TP_nom;
    @FXML
    private TableColumn<?, ?> TP_Desc;
    @FXML
    private TableColumn<?, ?> TP_Cat;
    @FXML
    private TableColumn<?, ?> TP_Prix;
    @FXML
    private TableColumn<?, ?> TP_Disp;
    @FXML
    private TextField Recherche;
    @FXML
    private FontAwesomeIconView btn_recherche;
    @FXML
    private TextField TnomP;
    @FXML
    private ComboBox<?> CBcat;
    @FXML
    private ImageView imageP;
    @FXML
    private Button btn_imgP;
    @FXML
    private TextField TPrixP;
    @FXML
    private ComboBox<?> Combodisp;
    @FXML
    private TextArea TdescP;
    @FXML
    private Button btn_addP;
    @FXML
    private Button btn_delP;
    @FXML
    private Button btn_modifP;
    @FXML
    private AnchorPane pop;
    @FXML
    private FontAwesomeIconView Bclose;
    @FXML
    private TextField TM_nom;
    @FXML
    private TextField TM_prix;
    @FXML
    private ComboBox<?> CBcatM;
    @FXML
    private ComboBox<?> CombodispM;
    @FXML
    private Button btn_Mimg;
    @FXML
    private ImageView Image_Mp;
    @FXML
    private TextArea TM_desc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void selected(MouseEvent event) {
    }

    @FXML
    private void RechercheProduit(KeyEvent event) {
    }

    @FXML
    private void categorie(ActionEvent event) {
    }

    @FXML
    private void choisirImage(MouseEvent event) {
    }

    @FXML
    private void choisirImage(ActionEvent event) {
    }

    @FXML
    private void Disponible(ActionEvent event) {
    }

    @FXML
    private void addproduct(ActionEvent event) {
    }

    @FXML
    private void fermer(MouseEvent event) {
    }

    @FXML
    private void update(ActionEvent event) {
    }

    @FXML
    private void delete(ActionEvent event) {
    }

    @FXML
    private void ModifImage(ActionEvent event) {
    }
    
}
