/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author MEGATRON
 */
public class Database {
    public static  Connection connexion = null;
 

    public static Connection getConnection() {
        if (connexion==null){
              try {
            Class.forName("com.mysql.cj.jdbc.Driver");
      
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        try {
            connexion = DriverManager.getConnection("jdbc:mysql://localhost/restaurant", "root", "");
            
        } catch (SQLException e) {
            System.out.println(e);
        }

        }
      return  connexion;
    }
}
