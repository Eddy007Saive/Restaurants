/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import Database.QueryBuilder;
import Interfaces.Ecouteur;
import Models.Produits;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import Models.Table;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import Models.Commandes;
import Models.Details_commandes;
import java.sql.PreparedStatement;
import static java.time.Instant.now;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import Models.ListeCoommande;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author MEGATRON
 */
public class CommandeController implements Initializable {

    private Commandes commande = new Commandes();
    private Details_commandes details = new Details_commandes();

    private ObservableList<Produits> CardList = FXCollections.observableArrayList();

    private Ecouteur ecouteur;

    private Button btn_actu;

    protected Image image;
    @FXML
    private ImageView ImageP_choisis;

    @FXML
    private Label NomP_choisis;

    @FXML
    private Label PrixP_choisis;

    @FXML
    private Button btn_ajouterP;

    @FXML
    private Button btn_recherche1;

    @FXML
    private AnchorPane form_commande;

    @FXML
    private GridPane menu_grid;

    @FXML
    private ScrollPane menu_scroll1;

    public static String idT;

    @FXML
    private TextField id;

    @FXML
    private Spinner qt_choisis;

    private SpinnerValueFactory<Integer> spin;

    @FXML
    private TextField recherche_p;

    @FXML
    private TableColumn<ListeCoommande, Integer> col_IdCom;

    @FXML
    private TableColumn<ListeCoommande, Integer> col_mont;

    @FXML
    private TableColumn<ListeCoommande, String> col_plat;

    @FXML
    private TableColumn<ListeCoommande, Integer> col_prix;

    @FXML
    private TableColumn<ListeCoommande, Integer> col_qt;

    @FXML
    private TableView<ListeCoommande> table_com;

    private Produits produits = new Produits(0, "", "", "", 0, "", "");

    private ResultSet res;
    private ObservableList<ListeCoommande> ajouterP;

    public void Setquantity() {
        spin = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1);
        qt_choisis.setValueFactory(spin);
    }

    public ObservableList<ListeCoommande> ListOrder() throws SQLException {
        ObservableList<ListeCoommande> datas = FXCollections.observableArrayList();
        ListeCoommande listecom;
        int prix = 0;
        int qt = 0;
        res = commande.LeftJoin();
        while (res.next()) {
            prix = res.getInt("p.price");
            qt = res.getInt("d.qt");
            listecom = new ListeCoommande(
                    res.getInt("c.idCom"),
                    res.getString("p.name"),
                    qt,
                    prix,
                    prix * qt
            );
            datas.add(listecom);
        }

        return datas;

    }

    public void MakeOrder() throws SQLException {
        ajouterP = ListOrder();

        col_IdCom.setCellValueFactory(new PropertyValueFactory<>("idCom"));
        col_plat.setCellValueFactory(new PropertyValueFactory<ListeCoommande, String>("Nom"));
        col_qt.setCellValueFactory(new PropertyValueFactory<>("qt"));
        col_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        col_mont.setCellValueFactory(new PropertyValueFactory<ListeCoommande, Integer>("Montant"));

        table_com.setItems(ajouterP);

    }

    public ObservableList<Produits> menugetData() throws SQLException {
        ObservableList<Produits> datas = FXCollections.observableArrayList();

        res = produits.FindWhere("available", true);
        String dispo;
        while (res.next()) {
            if (res.getBoolean("available") == true) {
                dispo = "Disponible";
            } else {
                dispo = "Indisponible";
            }

            produits = new Produits(res.getInt("id"),
                    res.getString("name"),
                    res.getString("descr"),
                    res.getString("catg"),
                    res.getInt("price"),
                    dispo,
                    res.getString("image"));
            datas.add(produits);

        }
        return datas;
    }

    public void actualiser() throws SQLException, IOException {
        menudisplayCard();

    }

    public void ProduitChoisis(Produits produit) {
        id.setText(String.valueOf(produit.getId()));
        NomP_choisis.setText(produit.getName());
        PrixP_choisis.setText(String.valueOf(produit.getPrice()));
        String uri = "file:" + produit.getImage();
        image = new Image(uri, 187, 110, false, true);
        ImageP_choisis.setImage(image);

    }

    public void menudisplayCard() throws SQLException, IOException {
        CardList.clear();
        CardList.addAll(menugetData());

        ecouteur = new Ecouteur() {
            @Override
            public void onClickListner(Produits produits) {
                ProduitChoisis(produits);
            }
        };
        int row = 0;
        int column = 0;
        menu_grid.getColumnConstraints().clear();
        for (int i = 0; i < CardList.size(); i++) {
            FXMLLoader load = new FXMLLoader();
            load.setLocation(getClass().getResource("/Views/Card.fxml"));
            AnchorPane pane = load.load();
            MenuController menu = load.getController();
            menu.setData(CardList.get(i), ecouteur);
            if (column == 3) {
                column = 0;
                row += 1;
            }
            menu_grid.add(pane, column++, row);
            GridPane.setMargin(pane, new Insets(10));

        }
    }

    @FXML
    void commander(ActionEvent event) throws SQLException {
        int idPro = Integer.parseInt(id.getText());

        int idCom = 0;

        int qt = (Integer) qt_choisis.getValue();
        Object[] value = {1, 0};

        commande.add(value);
        res = commande.lastInsertId();
        while (res.next()) {
            idCom = res.getInt(1);
        }
        Object[] value2 = {idCom, idPro, qt};
        System.out.println(value2[1]);
        details.add(value2);
        MakeOrder();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Setquantity();
            MakeOrder();
            menudisplayCard();
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

}
