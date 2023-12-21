/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import AllOutils.Oimage;
import Database.QueryBuilder;
import Models.Produits;
import AllOutils.outils;
import Database.Database;
import Models.Users;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import Database.Database;
import Interfaces.Ecouteur;
import Models.Produits;
import com.mysql.cj.util.DnsSrv;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javax.sound.midi.Patch;
import Interfaces.Ecouteur;
import javafx.scene.control.Label;
import Models.Table;

/**
 * FXML Controller class
 *
 * @author MEGATRON
 */
public class ProduitController implements Initializable {

    protected Image image;
    private String[] categorie = {"Entrée", "Désert", "Specialité", "petit déjeuner", "Repas", "Boisson"};
    private String[] disponibilité = {"Disponible", "Indisponible"};
    private Produits produits = new Produits(0, "", "", "", 0, "", "");
    private ObservableList<Produits> ajouterP;
    public outils outil = new outils();
    private Table table = new Table(0, "", "");

    private Ecouteur ecouteur;

    @FXML
    private Label NomP_choisis;
    @FXML
    private Label PrixP_choisis;
    @FXML
    private ImageView ImageP_choisis;
    @FXML
    private TextField qt_choisis;

    @FXML
    private ImageView Image_Mp;

    @FXML
    private TextField TM_nom;

    @FXML
    private TextField TM_prix;

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
    private ComboBox<String> CBcat;

    @FXML
    private ComboBox<String> CBcatM;

    @FXML
    private ComboBox<String> CombodispM;

    @FXML
    private FontAwesomeIconView Bclose;

    @FXML
    private ComboBox<String> Combodisp;

    @FXML
    private TextField TPrixP;

    @FXML
    private TextArea TdescP;

    @FXML
    private TextArea TM_desc;

    @FXML
    private TextField TnomP;

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
    private TextField Recherche;

    @FXML
    private TableColumn<Produits, Integer> TP_id;

    @FXML
    private TableColumn<Produits, String> TP_nom;

    @FXML
    private TableColumn<Produits, String> TP_Desc;

    @FXML
    private TableColumn<Produits, Integer> TP_Prix;

    @FXML
    private TableColumn<Produits, String> TP_Disp;

    @FXML
    private TableColumn<Produits, String> TP_Cat = new TableColumn<Produits, String>("cate");

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
    private TableView<Produits> tableP;

    private ResultSet res;

    private Oimage images = new Oimage();

    private ObservableList<Produits> CardList = FXCollections.observableArrayList();

    public void Disponible() {
        List<String> dispo = new ArrayList<>();
        for (String data : this.disponibilité) {
            dispo.add(data);
        }
        ObservableList lisdata = FXCollections.observableArrayList(dispo);
        Combodisp.setItems(lisdata);
        CombodispM.setItems(lisdata);

    }

    public void categorie() {
        List<String> categori = new ArrayList<>();
        for (String data : this.categorie) {
            categori.add(data);
        }
        ObservableList lisdata = FXCollections.observableArrayList(categori);
        CBcat.setItems(lisdata);
        CBcatM.setItems(lisdata);
    }

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

    @FXML
    /**
     * Ajouter un produit au table
     */
    void addproduct(ActionEvent event) throws SQLException {
        Boolean dispo = false;

        if (!outil.testField(TnomP, TPrixP, TdescP) && !CBcat.getValue().isEmpty() && !Combodisp.getValue().isEmpty()) {
            if (Combodisp.getValue().equals("Disponible")) {
                dispo = true;

            }
            String image = images.stokerImage(produits);
            Object[] values = {TnomP.getText(), TdescP.getText(), TPrixP.getText(), CBcat.getValue(), dispo, image};
            produits.add(values);
            outil.alert1(Alert.AlertType.INFORMATION, "Succés", null, "Produit ajouter");
            ajouterProduit();
            outil.Reset(TnomP, TdescP, TPrixP);
            imageP.setImage(null);
        } else {
            outil.alert1(Alert.AlertType.ERROR, "Champs vide", null, "Rempliser toute les champs");
        }

    }

    @FXML
    void selected(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
            produits = tableP.getSelectionModel().getSelectedItem();
            int index = tableP.getSelectionModel().getSelectedIndex();
            /**
             * Selection de colonne Le fenetre mofid apparait
             */
            if (index >= 0) {
                pop.setVisible(true);
                System.out.println(produits.getImage());
                TM_nom.setText(String.valueOf(produits.getName()));
                TM_desc.setText(String.valueOf(produits.getDesc()));
                TM_prix.setText(String.valueOf(produits.getPrice()));
                CombodispM.setValue(produits.getAvalaible());
                CBcatM.setValue(produits.getCatg());
                String uri = "file:" + produits.getImage();
                image = new Image(uri, 222, 165, false, true);
                Image_Mp.setImage(image);

            }
        }
    }

    //Rechercher 
    public void Rechercher(MouseEvent event) {
        System.out.println("ssu");
    }

    public void choisirImage() {

        images.choisirImage(form_produit, imageP, 139, 161);

    }

    public void ModifImage() {
        images.choisirImage(pop, Image_Mp, 165, 222);
    }

    public ObservableList<Produits> Allproduct() throws SQLException {
        ObservableList<Produits> datas = FXCollections.observableArrayList();
        res = produits.All();
        String dispo = "Indisponible";
        String categorie = null;
        String desc = null;
        Produits produits;

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
            produits.closeressource();

        }
        return datas;

    }

    public void ajouterProduit() throws SQLException {
        ajouterP = Allproduct();

        TP_id.setCellValueFactory(new PropertyValueFactory<Produits, Integer>("id"));
        TP_nom.setCellValueFactory(new PropertyValueFactory<Produits, String>("name"));
        TP_Desc.setCellValueFactory(new PropertyValueFactory<Produits, String>("desc"));
        TP_Cat.setCellValueFactory(new PropertyValueFactory<Produits, String>("catg"));
        TP_Prix.setCellValueFactory(new PropertyValueFactory<Produits, Integer>("price"));
        TP_Disp.setCellValueFactory(new PropertyValueFactory<Produits, String>("avalaible"));
        tableP.setItems(ajouterP);
        produits.closeressource();
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
            produits.closeressource();
        }

        return datas;
    }


    public void click(MouseEvent event) {
        if (event.getSource() != tableP) {
            outil.visibilitybutton(false, btn_modifP, btn_delP);
            outil.visibilitybutton(true, btn_addP);
        }
    }

    public void fermer(MouseEvent event) {
        pop.setVisible(false);
    }

    public void update() throws SQLException {
        Optional<ButtonType> option = outil.AlertConfirmation("Confirmation message", null, "Voulez vous vraiment modifier ?");
        if (option.get().equals(ButtonType.OK)) {
            if (!outil.testField(TM_desc, TM_nom, TM_prix) && !CBcatM.getValue().isEmpty() && !CombodispM.getValue().isEmpty()) {
                Boolean dispo = false;
                if (CombodispM.getValue().equals("Disponible")) {
                    dispo = true;

                }
                String image = images.stokerImage(produits);
                System.out.println(produits.getImage());
                System.out.println(produits.getId());
                Object[] values = {TM_nom.getText(), TM_desc.getText(), TM_prix.getText(), CBcatM.getValue(), dispo, image};
                produits.update(values);
                outil.alert1(Alert.AlertType.INFORMATION, "Succés", null, "Produit Modifier");
                ajouterProduit();

            } else {
                outil.alert1(Alert.AlertType.ERROR, "Champs vide", null, "Rempliser toute les champs");
            }
        } else {
            outil.alert1(Alert.AlertType.INFORMATION, "Annulation message", null, "Modification annuler");
        }

    }

    public void delete() throws SQLException {
        Optional<ButtonType> option = outil.AlertConfirmation("Confirmation message", null, "Voulez vous vraiment supprimer ?");
        String uri = "file:" + produits.getImage();
        if (option.get().equals(ButtonType.OK)) {
            File fichier = new File(uri);
            if (fichier.exists()) {
                fichier.delete();
            } else {
                System.out.println("nooooooo");
            }

            produits.delete();

            ajouterProduit();
            outil.alert1(Alert.AlertType.INFORMATION, "Suppresion", null, "Produit supprimer");
            pop.setVisible(false);
        }

    }

    public void RechercheProduit() {
        FilteredList<Produits> filtre = new FilteredList<>(ajouterP, e -> true);
        String prix = String.valueOf(produits.getPrice());
        Recherche.textProperty().addListener((observable, oldvalue, newValue) -> {
            filtre.setPredicate(predicateproduit -> {
                if (newValue.isEmpty() || newValue == null) {
                    return true;
                }
                String motRechercher = newValue.toLowerCase();
                if (predicateproduit.getDesc().toLowerCase().contains(motRechercher)) {
                    return true;
                } else if (predicateproduit.getCatg().toLowerCase().contains(motRechercher)) {
                    return true;
                } else if (predicateproduit.getName().toLowerCase().contains(motRechercher)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        SortedList<Produits> sortlist = new SortedList<>(filtre);
        sortlist.comparatorProperty().bind(tableP.comparatorProperty());
        tableP.setItems(sortlist);
    }

    private ObservableList<Table> TableList = FXCollections.observableArrayList();

    public void Displaytable() throws SQLException, IOException {
        TableList.clear();
        TableList.addAll(tablegetData());

        int row = 0;
        int column = 0;
        menu_gridT.getColumnConstraints().clear();
        for (int i = 0; i < TableList.size(); i++) {
            FXMLLoader load = new FXMLLoader();
            load.setLocation(getClass().getResource("/Views/Table.fxml"));
            AnchorPane pane = load.load();
            TableController table = load.getController();
            table.setData(TableList.get(i));
            if (column == 3) {
                column = 0;
                row += 1;
            }
            menu_gridT.add(pane, column++, row);
            GridPane.setMargin(pane, new Insets(20));
            produits.closeressource();

        }
    }

    public ObservableList<Table> tablegetData() throws SQLException {
        ObservableList<Table> datas = FXCollections.observableArrayList();
        res = table.All();
        String dispo;
        while (res.next()) {
            if (res.getBoolean("available") == true) {
                dispo = "Disponible";
            } else {
                dispo = "Occupé";
            }
            table = new Table(res.getInt("id"), res.getString("tables"), dispo);
            datas.add(table);
        }
        produits.closeressource();
        return datas;

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            if (!outils.admin) {
                btn_admin.setVisible(false);
            }
            ajouterProduit();
            categorie();
            Disponible();
            try {
                
                Displaytable();
            } catch (IOException ex) {
                System.out.println(ex);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            if (res != null) {
                produits.closeressource();
            }
        }
    }

}
