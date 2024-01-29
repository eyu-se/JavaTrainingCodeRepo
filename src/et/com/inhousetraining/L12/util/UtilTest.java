/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.util;

import java.sql.PreparedStatement;
import java.io.*;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author eyu
 */
public class UtilTest {

    public static void main(String[] args) {

        //readFromFile();
        //writeToFile();
        //connectToDB();
        
        System.out.println("Geting existing data \n\n");
        getDataFromDB();
        System.out.println("Generated primary key for warehouse "+insertDataInDB());
        System.out.println("Geting  data after insert \n\n");
        getDataFromDB();

//        System.out.println("Inserting new Data into  \n\n");
//        insertDataInDB();
//
//        System.out.println("Get The new data   \n\n");
//        getDataFromDB();


    }
    
    
    static void readFromFile(){
        try {
            ReadFile rf = new ReadFile("/Users/eyu/Documents/test.txt");
            List<String> textData = rf.readFile();
            
            for(String s: textData){
                System.out.println(s);
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        } catch (IOException e) {
            System.out.println("Error reading from file");
        }
    }
    
    
    static void writeToFile(){
        try {
            WriteFile wf = new WriteFile("/Users/eyu/Documents/test.txt", true);
            
            wf.writeToFile("Jhon Jack, Liam, Test");
            
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    
    
    static void connectToDB(){
         // create a new connection from MySQLJDBCUtil
        try (Connection conn = MySQLJDBCUtil.getConnection()) {
            
            // print out a message
            System.out.println(String.format("Connected to database %s "
                    + "successfully.", conn.getCatalog()));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    
    static void getDataFromDB() {
    
        String sql = "SELECT warehouseID, location, currentQuantity, maxCapacity " +
                     "FROM warehouse";
        
        try (Connection conn = MySQLJDBCUtil.getConnection();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {
           
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("warehouseID") + "\t" + 
                                   rs.getString("location")  + "\t" +
                                   rs.getInt("currentQuantity")  + "\t" +
                                   rs.getInt("maxCapacity"));
                    
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        
    }
    
    
    static void updateDataInDB() {


         String sqlUpdate = "UPDATE warehouse "
                + "SET location = ? "
                + ", currentQuantity = ? "
                + ", maxCapacity = ? "
                + "WHERE warehouseID = ?";


        try (Connection conn = MySQLJDBCUtil.getConnection();
                PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sqlUpdate)) {
            // prepare data for update
            String newLocation = "DebreZeit";
            int newCurrentQuantity = 20;
            int newMaxCapacity = 9000;
            int warehouseID = 3;
            
            pstmt.setString(1, newLocation);
            pstmt.setInt(2, newCurrentQuantity);
            pstmt.setInt(3, newMaxCapacity);
            pstmt.setInt(4, warehouseID);
            
            int rowAffected = pstmt.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));
            
            
               
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    
    static int insertDataInDB() {
        
        // for insert a new warehouse
        ResultSet rs = null;
        int warehouseId = 0;
        
        String sql = "INSERT INTO warehouse(location,currentQuantity,maxCapacity) "
                   + "VALUES(?,?,?)";
        
        try (
                Connection conn = MySQLJDBCUtil.getConnection();
                PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ) {
            
            // set parameters for statement
            pstmt.setString(1, "Gonder");
            pstmt.setInt(2, 0);
            pstmt.setInt(3, 9000);
     

            int rowAffected = pstmt.executeUpdate();
            if(rowAffected == 1)
            {
                // get candidate id
                rs = pstmt.getGeneratedKeys();
                if(rs.next())
                    warehouseId = rs.getInt(1);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if(rs != null)  rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        
        return warehouseId;
    }


    
    
    
}
