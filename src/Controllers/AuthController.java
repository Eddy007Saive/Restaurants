package Controllers;

import Database.Database;
import Models.Users;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import AllOutils.outils;
import Database.QueryBuilder;
import java.io.IOException;
import javafx.scene.control.Button;

public class AuthController implements Initializable {

    private Users user = new Users(0, "", "", "");
    private ResultSet res = null;
    private String login = null;
    private String mdp = null;
    private boolean admin;
    private outils o = new outils();

    @FXML
    private PasswordField TMdp;

    @FXML
    private TextField Tuser;

    @FXML
    private Button btn_connexion;

    @FXML
    void close(MouseEvent event) {
        System.exit(0);
    }

    public void valider(ActionEvent event) throws SQLException, IOException {
        Object values = Tuser.getText();
        res = user.find(values);
        while (res.next()) {
            mdp = res.getString("mdp");
            admin = res.getBoolean("admin");
            outils.admin = admin;
        }
     

        if (!o.testField(Tuser, TMdp)) {
            if (mdp != null) {
                if (mdp.equals(TMdp.getText())) {
                    //Pour ouvrir une fenetre
                    o.Fenetre("/Views/Accueil.fxml", btn_connexion);
                    if (admin) {
                    }
                } else {
                    o.alert1(Alert.AlertType.ERROR, "Erruer", null, "Mots de passe incorrecte");
                }
            } else {
                o.alert1(Alert.AlertType.ERROR, "Erreur", null, "Utlisateur inconue");
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    

}
