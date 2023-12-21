/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import Models.Users;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import AllOutils.outils;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * FXML Controller class
 *
 * @author MEGATRON
 */
public class UserController implements Initializable {

    private outils outil = new outils();
    private Users users;
    @FXML
    private ComboBox<String> ComboRole;

    private ResultSet res;
    @FXML
    private TextField T_nom;

    @FXML
    private PasswordField T_pass;

    @FXML
    private TableView<Users> Tableuser;

    @FXML
    private Button btn_adm_ajout;

    @FXML
    private Button btn_modif;

    @FXML
    private Button btn_supr;

    @FXML
    private TableColumn<Users, String> col_Role;

    @FXML
    private TableColumn<Users, String> col_log;

    @FXML
    private AnchorPane form_utilisateur;

    private String[] role = {"Utilisateur"};

    public ObservableList<Users> AllUser() throws SQLException {
        ObservableList<Users> listdata = FXCollections.observableArrayList();
        Users user = new Users(0, "", "", "");
        Users users;
        res = user.All();
        String admin;
        while (res.next()) {
            if (res.getBoolean("admin")) {
                admin = "Administrateur";

            } else {
                admin = "Utilisateur";
            }
            System.out.println(res.getBoolean("admin"));
            users = new Users(
                    res.getInt("id"),
                    res.getString("login"),
                    admin,
                    res.getString("mdp"));
            listdata.add(users);
        }
        return listdata;
    }

    private ObservableList<Users> listUser;

    public void addtotableV() throws SQLException {
        listUser = AllUser();
        col_log.setCellValueFactory(new PropertyValueFactory<Users, String>("login"));
        col_Role.setCellValueFactory(new PropertyValueFactory<Users, String>("admin"));

        Tableuser.setItems(listUser);

    }

    public void Role() {
        List<String> dispo = new ArrayList<>();
        for (String data : this.role) {
            dispo.add(data);
        }
        ObservableList lisdata = FXCollections.observableArrayList(dispo);
        ComboRole.setItems(lisdata);

    }

    public void select(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
            users = Tableuser.getSelectionModel().getSelectedItem();
            int index = Tableuser.getSelectionModel().getSelectedIndex();

            if (event.getSource() != Tableuser) {

            }
            if (index >= 0) {
                T_nom.setText(String.valueOf(users.getLogin()));
                T_pass.setText(String.valueOf(users.getPass()));
                btn_adm_ajout.setDisable(true);
                btn_modif.setDisable(false);
                btn_supr.setDisable(false);

            } else {

            }
        }

    }

    public void adduser() throws SQLException {
        boolean admin = false;
        Users user = new Users(0, "", "", "");
        if (!outil.testField(T_nom, T_pass) && !ComboRole.getValue().isEmpty()) {
            if (ComboRole.getValue().equals("Administrateur")) {
                admin = true;
            }
            Object[] values = {T_nom.getText(), T_pass.getText(), admin};
            user.add(values);
            outil.alert1(Alert.AlertType.INFORMATION, "Succés", null, "Utilisateur  ajouter");
            addtotableV();

        } else {
            outil.alert1(Alert.AlertType.ERROR, "Erreur", null, "Veuillez remplir toutes les information");
        }

    }

    public void updateuser() throws SQLException {
        boolean admin = false;
        Optional<ButtonType> option = outil.AlertConfirmation("Modification", null, "Voulez vous vraiment modifier l'utilisateur ?");
        if (option.get().equals(ButtonType.OK)) {
            if (ComboRole.getValue().equals("Administrateur")) {
                admin = true;
            }
            Object[] values = {T_nom.getText(), T_pass.getText(), admin};
            users.update(values);
        }

    }

    public void deleteUser() throws SQLException {
        Optional<ButtonType> option = outil.AlertConfirmation("Suppression", null, "Voulez vous vraiment supprimer l'utilisateur ?");
        if(option.get().equals(ButtonType.OK)){
           users.delete(); 
        }
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Role();
        btn_modif.setDisable(true);
        btn_supr.setDisable(true);
        ComboRole.setValue("Utilisateur");
        try {

            addtotableV();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
