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
public class Table {
    public static String idT;
    private int id;
    private String nom;
    private String avalaible;
    private String Table="table_r";
    private String[] colonne={"id", "tables", "Available"};
    QueryBuilder query=new QueryBuilder(Table, colonne);
    public ResultSet res;

    public Table(int id, String nom, String avalaible) {
        this.id = id;
        this.nom = nom;
        this.avalaible = avalaible;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getAvalaible() {
        return avalaible;
    }
    
     public ResultSet All() throws SQLException{
         res=query.All();
         return res;
     }
    
}
