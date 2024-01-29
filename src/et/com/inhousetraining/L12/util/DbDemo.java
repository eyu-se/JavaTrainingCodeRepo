/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author eyu
 */
public class DbDemo {
    
    public static void main(String[] args) {
      
        Connection conn =  DbConnector.getConnection();
        System.out.println(conn);

//        getDataFromDB();
    }
    
    
    
    static void getDataFromDB() {
    
        String sql = "SELECT warehouseId, location, currentQuantity, maxCapacity " + "FROM warehouse";
        
        try (Connection conn = DbConnector.getConnection();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {
           
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("warehouseId") + "\t" + 
                                   rs.getString("location")  + "\t" +
                                   rs.getString("currentQuantity")+"\t"+
                                   rs.getString("maxCapacity"));
                    
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        
    }

    
}
