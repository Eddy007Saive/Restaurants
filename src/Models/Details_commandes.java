/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Database.QueryBuilder;
import java.sql.SQLException;

/**
 *
 * @author MEGATRON
 */
public class Details_commandes {
       
    private String Table2="details_commande";
    private String[] colonne={"idT", "etatCom"};
    private String[] colonne2={ "idCom", "idPro", "qt"};
     QueryBuilder query2=new QueryBuilder(Table2, colonne2);
     
     public void add(Object[] value) throws SQLException{
         
         query2.Insertion(value);
     }
     
     public void update(Object[]value,int id) throws SQLException{
         query2.update(value,id);
     }
     
     public void delete(int id) throws SQLException{
         query2.delete(id);
     }
}
