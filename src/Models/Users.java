/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Database.Database;
import Database.QueryBuilder;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MEGATRON
 */
public class Users {
    private int id;
    private String login;
    private String admin;
    private String pass;
    private String[] colonne = {"login", "mdp", "admin"};
    private String table = "users";
    private ResultSet res = null;
    private QueryBuilder query = new QueryBuilder(table, colonne);

    public Users(int id, String login, String admin, String pass) {
        this.id = id;
        this.login = login;
        this.admin = admin;
        this.pass = pass;
    }

    public String getAdmin() {
        return admin;
    }

    public String getPass() {
        return pass;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

  

    public String[] getColonne() {
        return colonne;
    }

    public String getTable() {
        return table;
    }

    public ResultSet getRes() {
        return res;
    }

    public QueryBuilder getQuery() {
        return query;
    }
    
    

    public void add(Object[] values) throws SQLException {
        query.Insertion(values);
    }

    public ResultSet find(Object value) throws SQLException {
        res = query.find(colonne[0], value);
        return res;
    }
    
    public void update( Object[]values) throws SQLException{
        query.update(values, getId());
    }
    
    public void delete() throws SQLException{
        query.delete(getId());
    }
    public  ResultSet All() throws SQLException{
        res=query.All();
        return res;
    }
   

}
