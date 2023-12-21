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
public class Commandes {
    private String Table="commande";
    private String Table2="details_commande";
    private String[] colonne={"idT", "etatCom"};
    private String[] colonne2={ "idCom", "idPro", "qt"};
    private String[]Ntable={Table2,"produits"};
     QueryBuilder query=new QueryBuilder(Table, colonne);
     QueryBuilder query2=new QueryBuilder(Table2, colonne2);
     
     public void add(Object[] value) throws SQLException{
         
         query.Insertion(value);
     }
     
     public void update(Object[]value,int id) throws SQLException{
         query.update(value,id);
     }
     
     public void delete(int id) throws SQLException{
         query.delete(id);
     }
     
     public ResultSet lastInsertId() throws SQLException{
         ResultSet res=query.lastInsertId();
         return res;
     }
    
     public ResultSet LeftJoin() throws SQLException{
        
        ResultSet res= query.leftJoin();
        
        return res;
     }

    
}
