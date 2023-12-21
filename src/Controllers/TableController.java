/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import Models.Table;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author MEGATRON
 */
public class TableController implements Initializable {

    @FXML
    private ImageView imageTable;
    @FXML
    private Label Tdispo;

    @FXML
    private Label Tnom;

    @FXML
    private Button btn_liste;

    private Table table;
    private Image image;

    public void setData(Table table) {
        this.table = table;
        Tnom.setText(table.getNom());
        Tdispo.setText(table.getAvalaible());
        String uri;
        if(Tdispo.getText().equals("Disponible")){
             uri="file:./src/Assets/Images/restaurant.png";
        }
        else{
            uri="file:./src/Assets/Images/couple-drinking-in-a-bar.png";
        } 
        image = new Image(uri, 161, 144, false, true);
        imageTable.setImage(image);
        

    }
    public void btn_Id(){
        Table.idT= String.valueOf(table.getId()) ;
        CommandeController.idT=String.valueOf(table.getId());
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
