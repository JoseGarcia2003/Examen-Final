/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author _mrodriguezb
 */
public class ConexionDB {
 
    public static Connection getConexion() {
        Connection cnx = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
          //  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           // cnx = DriverManager.getConnection("jdbc:sqlserver://MARB:1433;databaseName=BD_CitasMedicas;user:sa;password=cenizo");
        	
        	Class.forName(driver);
        	cnx = DriverManager.getConnection("jdbc:mysql://localhost:3307/bdproductos","root","Admin123");
            

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(""+e.toString());
        }
        return cnx;
    }

}
