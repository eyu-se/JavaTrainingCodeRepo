/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author eyu
 */
public class DbConnector {

    public static Connection getConnection() {
        Connection conn = null;
        try {
// This will load the MySQL driver, each DB has its own driver
//            Class.forName("com.mysql.jdbc.Driver");

            // db parameters
            String url = "jdbc:mysql://127.0.0.1:8889/inventoryManagement?autoReconnect=true&useSSL=false";
            String user = "root";
            String password = "root";

            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
            // more processing here
            // ...	
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        return conn;
    }
}
