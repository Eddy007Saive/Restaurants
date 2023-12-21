/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author MEGATRON
 */
public class QueryBuilder {

    protected Connection connexion = Database.getConnection(); // Modifiez cette ligne pour récupérer la connexion à partir de DatabaseManager
    protected PreparedStatement statement = null;
    private String Ntable;
    private String[] colonne;
 private StringBuilder query;

    public QueryBuilder(String Table, String[] colonne) {
        this.Ntable = Table;
        this.colonne = colonne;
        query=new StringBuilder();
        
        

    }
    private static final Logger LOG = Logger.getLogger(QueryBuilder.class.getName());

    public void Insertion(Object[] values) throws SQLException {
        String sql = "INSERT INTO " + Ntable + "(" + String.join(",", colonne) + ") VALUES (" + String.join(",", Collections.nCopies(values.length, "?")) + ")";
        statement = connexion.prepareStatement(sql);
        System.out.println(sql);
        for (int i = 0; i < values.length; i++) {
            if (values[i] instanceof String) {
                statement.setString(i + 1, (String) values[i]);
            } else if (values[i] instanceof Integer) {
                statement.setInt(i + 1, (Integer) values[i]);
            } else if (values[i] instanceof Float) {
                statement.setFloat(i + 1, (Float) values[i]);
            } else if (values[i] instanceof Date) {
                statement.setDate(i + 1, (Date) values[i]);
            } else if (values[i] instanceof Boolean) {
                statement.setBoolean(i + 1, (boolean) values[i]);
            }
        }

        statement.executeUpdate();
        statement.closeOnCompletion();
    }

    public ResultSet All() throws SQLException {
        String sql = "SELECT * FROM  " + Ntable;
        statement = connexion.prepareStatement(sql);
        ResultSet res = statement.executeQuery();
        return res;
    }

    public void update(Object[] values, int id) throws SQLException {
        String sql = "UPDATE  " + Ntable + " SET " + String.join("=?, ", colonne) + " =? WHERE id=?";
        statement = connexion.prepareStatement(sql);

        for (int i = 0; i < values.length; i++) {
            if (values[i] instanceof String) {
                statement.setString(i + 1, (String) values[i]);
            } else if (values[i] instanceof Integer) {
                statement.setInt(i + 1, (Integer) values[i]);
            } else if (values[i] instanceof Float) {
                statement.setFloat(i + 1, (Float) values[i]);
            } else if (values[i] instanceof Date) {
                statement.setDate(i + 1, (Date) values[i]);
            } else {
                statement.setBoolean(i + 1, (boolean) values[i]);
            }
        }
        statement.setInt(values.length + 1, id);
        statement.execute();
        statement.closeOnCompletion();

    }

    //recupere un Element avec un parametre Object vaue qui permet d'introduire un String ou int ou float 
    public ResultSet find(String colonnetofind, Object value) throws SQLException {
        String sql = "SELECT * from " + Ntable + " WHERE " + colonnetofind + " = ?";
        statement = connexion.prepareStatement(sql);
        if (value instanceof String) {
            statement.setString(1, (String) value);
        } else if (value instanceof Integer) {
            statement.setInt(1, (Integer) value);
        }

        ResultSet t = statement.executeQuery();
        statement.closeOnCompletion();
        return t;
    }

    /**
     * Suppression de données
     *
     * @param id l(id du données a supprimer
     * @throws SQLException
     */
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM " + Ntable + " WHERE id= ? ";

        statement = connexion.prepareStatement(sql);
        statement.setInt(1, id);
        statement.execute();
        statement.closeOnCompletion();
    }

    public ResultSet FindWhere(String colonne, Object value) throws SQLException {
        String sql = "SELECT * FROM " + Ntable + " WHERE " + colonne + " =? ";
        statement = connexion.prepareStatement(sql);
        if (value instanceof String) {
            statement.setString(1, (String) value);
        } else if (value instanceof Integer) {
            statement.setInt(1, (Integer) value);
        } else if (value instanceof Boolean) {
            statement.setBoolean(1, (boolean) value);
        }

        ResultSet t = statement.executeQuery();
        statement.closeOnCompletion();
        return t;

    }

    // Fermez le Statement après son utilisation
    public void closeStatement() {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            System.out.println("Fermeture base de sattement" + e);
        }
    }

    // Fermez le ResultSet après son utilisation
    public void closeResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            System.out.println("Fermeture base de result" + e);
        }
    }

    public void closeconnexion() {
        try {
            if (connexion != null);

        } catch (Exception e) {
            System.out.println("Fermeture base de donné" + e);

        }
    }

    public ResultSet lastInsertId() throws SQLException {
        String sql = "SELECT MAX(idCom) FROM " + Ntable;
        statement = connexion.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        return rs;
    }

    public ResultSet NaturalJoin(String[] Table) throws SQLException {
        String sql = "SELECT * FROM " + Ntable + " LEFT  JOIN " + String.join(" LEFT  JOIN ", Table);
        statement = connexion.prepareCall(sql);
        System.out.println(sql);
        ResultSet res = statement.executeQuery();
        return res;

    }
    
    public QueryBuilder Select(String ...colums){
        query.append(" SELECT ").append(String.join(" , ", colums));
        return  this;
        
    }
    
    public QueryBuilder from (){
        query.append(" FROM ").append(Ntable);
        return this;
    }
    
    public QueryBuilder leftJoins(String table,String condition){
        query.append("  LEFT JOIN ").append(table).append(" ON ").append(condition);
        return this;
    }
    
    public ResultSet build() throws SQLException{
        statement=connexion.prepareStatement(query.toString());
        ResultSet res =statement.executeQuery();
        return res;
    }
    
    public ResultSet leftJoin() throws SQLException{
        String sql="SELECT p.name , p.price , c.idCom , d.qt FROM commande c "
                + "LEFT JOIN details_commande d ON d.idCom=c.idCom"
                + " LEFT JOIN produits p ON d.idPro=p.id   ";
        statement=connexion.prepareStatement(sql);
        ResultSet res=statement.executeQuery();
        return res;
        
    }
           

}
