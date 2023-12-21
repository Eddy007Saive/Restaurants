/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Database.QueryBuilder;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MEGATRON
 */
public class Produits {

    private int id;
    private String name;
    private String desc;
    private int price;
    private String catg;
    private String image;
    private String avalaible;
    private String table = "produits";
    private String[] colonne = {"name", "descr", "price", "catg", "available", "image"};
    
    protected ResultSet res = null;

    QueryBuilder query = new QueryBuilder(table, colonne);

    public Produits(int id, String name, String desc, String catg,int prix,  String avalaible,String image) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = prix;
        this.catg = catg;
        this.avalaible = avalaible;
        this.image=image;
    }

    public Produits(int id, String name,String avalaible,  int price, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.avalaible = avalaible;
    }
 

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public String getAvalaible() {
        return avalaible;
    }

    public String getTable() {
        return table;
    }

    public String[] getColonne() {
        return colonne;
    }

    public ResultSet getRes() {
        return res;
    }

    public QueryBuilder getQuery() {
        return query;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getCatg() {
        return catg;
    }

  

    /**
     * Ajouter un produit au table
     *
     * @param values Entrez les valueur de chaque table selon la colonne
     * @throws SQLException
     */
    public void add(Object[] values) throws SQLException {
        query.Insertion(values);
    }

    /**
     * Re=écuperer la liste de tout les produits
     *
     * @return
     * @throws SQLException
     */
    public ResultSet All() throws SQLException {
        res = query.All();
        return res;
    }
    /**
     * Mis à jours des données dans produit
     * @param values
     * @throws SQLException 
     */
    public void update(Object[]values) throws SQLException{
        query.update(values, getId());
        
    }
    /**
     * Suppression de données dans produit
     * @throws SQLException 
     */
    public void delete() throws SQLException{
        query.delete(getId());
    }
    
    public ResultSet FindWhere(String colonne,Object value) throws SQLException{
        res=query.FindWhere(colonne, value);
        return res;
    }
 
    public  void closeressource() {
        query.closeResultSet(res);
        query.closeStatement();
        query.closeconnexion();
        
    }
}

