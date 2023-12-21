/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AllOutils;

import java.io.IOException;
import java.util.Optional;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author MEGATRON
 */
public class outils {
        private Alert alert;
           public static String  username;
           public static  String path;
           public static boolean admin=false;
           
        /**
         * Pour créer des fenetre d'alerte
         * @param type type de 'alerte
         * @param title titre du fenetre
         * @param header tete ddu fenetre
         * @param content corpss du fenetre
         */
    public void alert1(AlertType type,String title,String header,String content){
        alert = new Alert(type);
                    alert.setTitle(title);
                    alert.setHeaderText(header);
                    alert.setContentText(content);
                    alert.showAndWait(); 
    }
    /**
     * Permet de faire une alert avec confirmation
     * @param title
     * @param header
     * @param content 
     */
       public Optional<ButtonType> AlertConfirmation(String title,String header,String content){
        alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle(title);
                    alert.setHeaderText(header);
                    alert.setContentText(content);
                    Optional<ButtonType>option= alert.showAndWait(); 
                    return option;
    }
    
        /**
         * Pour tester que toute es champs ne sont pas vide sinon erreur 
         * @param input
         * @return 
         */
    public boolean testField(TextInputControl... input){
        boolean test=false;
        for(TextInputControl inputs : input){
            if(inputs.getText().isEmpty()){
                test=true;
            }
        }
        return test;
    }
     public boolean testCombo(ComboBox<?>... combos){
        boolean test=false;
        for(ComboBox<?> combo : combos){
            if(combo.getValue().equals(null)){
                test=true;
            }
        }
        return test;
    }
    
        /**
         * Permet de manipuler les fenetre et ouverture
         * @param path le chemin du fichier fxml
         * @param button le bouton qui déclance la fermeture du fenetre
         * @throws IOException 
         */
       public void Fenetre(String path,Button button) throws IOException{
           Parent root=FXMLLoader.load(getClass().getResource(path));
           Stage stage=new Stage();
           Scene scene=new Scene(root);
           stage.setResizable(true);
           stage.setScene(scene);
           stage.show();
           button.getScene().getWindow().hide();
       }
       
       /**
        * Permet de vider les valeur des texte
        * @param input Entrez les Textfiel a vider
        */
       public  void Reset(TextInputControl... input){
           for(TextInputControl inputs:input){
               inputs.setText("");
           }
           
       }
       
       /**
        * Rend un bouton visible
        * @param button 
     * @param visible 
        */
       public  void visibilitybutton(Boolean visible,Button... button){
       for(Button b:button){
           b.setVisible(visible);
       }
       
    }
       
       
       public void Swicthform(AnchorPane[] p1,Button[] B){
           
       
       }
        

    
}
