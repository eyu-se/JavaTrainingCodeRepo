/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.repository;

import et.com.inhousetraining.L12.models.*;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.PreparedStatement;
import et.com.inhousetraining.L12.util.MySQLJDBCUtil;
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
public class WarehouseRepository {
    
   
    
    public void addWarehouse(Warehouse warehouse) {
        // for insert a new warehouse
            ResultSet rs = null;

            String sql = "INSERT INTO warehouse(location,currentQuantity,maxCapacity) "
                       + "VALUES(?,?,?)";

            try (
                    Connection conn = MySQLJDBCUtil.getConnection();
                    PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
                ) {

                // set parameters for statement
                pstmt.setString(1, warehouse.getLocation());
                pstmt.setInt(2, warehouse.getCurrentQuantity());
                pstmt.setInt(3, warehouse.getMaxCapacity());


                pstmt.executeUpdate();
               
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            } 

    }
    
    
    
    public void deleteWarehouse(int warehouseId){
        

            String sql = "DELETE FROM warehouse WHERE warehouseID = ?";

            try (
                    Connection conn = MySQLJDBCUtil.getConnection();
                    PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
                ) {

                // set parameters for statement
                pstmt.setInt(1, warehouseId);
                
                pstmt.executeUpdate();
               
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            } 
        
    }
    
    public Warehouse getWarehouseById(int warehouseId) {
            ResultSet rs = null;
            String sql = "SELECT warehouseId, location, currentQuantity, maxCapacity FROM warehouse WHERE warehouseID = ?";

            try (
                    Connection conn = MySQLJDBCUtil.getConnection();
                    PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
                ) {

                // set parameters for statement
                pstmt.setInt(1, warehouseId);
                
                rs = pstmt.executeQuery();
                
                while (rs.next()) {
                    
                    Warehouse warehouse = new Warehouse();
                    warehouse.setWarehouseID(rs.getInt("warehouseId"));
                    warehouse.setLocation(rs.getString("location"));
                    warehouse.setCurrentQuantity(rs.getInt("currentQuantity"));
                    warehouse.setMaxCapacity(rs.getInt("maxCapacity"));
                    return warehouse;
                }
               
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            } 
            
        return null; // Warehouse not found
    }
    

    public void updateWarehouse(Warehouse updatedWarehouse) {
        
             String sqlUpdate = "UPDATE warehouse "
                    + "SET location = ? "
                    + ", currentQuantity = ? "
                    + ", maxCapacity = ? "
                    + "WHERE warehouseID = ?";


            try (Connection conn = MySQLJDBCUtil.getConnection();
                    PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sqlUpdate)) {
                // prepare data for update
                String newLocation = updatedWarehouse.getLocation();
                int newCurrentQuantity = updatedWarehouse.getCurrentQuantity();
                int newMaxCapacity = updatedWarehouse.getMaxCapacity();
                int warehouseID = updatedWarehouse.getWarehouseID();

                pstmt.setString(1, updatedWarehouse.getLocation());
                pstmt.setInt(2, updatedWarehouse.getCurrentQuantity());
                pstmt.setInt(3, updatedWarehouse.getMaxCapacity());
                pstmt.setInt(4, updatedWarehouse.getWarehouseID());

                int rowAffected = pstmt.executeUpdate();
                System.out.println(String.format("Row affected %d", rowAffected));

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
    }

    // Additional methods as needed

    public List<Warehouse> getAllWarehouses() {
        List<Warehouse> warehouses = new ArrayList<>();
        
        String sql = "SELECT warehouseID, location, currentQuantity, maxCapacity " +
                         "FROM warehouse";

            try (Connection conn = MySQLJDBCUtil.getConnection();
                 Statement stmt  = conn.createStatement();
                 ResultSet rs    = stmt.executeQuery(sql)) {
                
                
                // loop through the result set
                while (rs.next()) {
                    
                    Warehouse warehouse = new Warehouse();
                    warehouse.setWarehouseID(rs.getInt("warehouseID"));
                    warehouse.setLocation(rs.getString("location"));
                    warehouse.setCurrentQuantity(rs.getInt("currentQuantity"));
                    warehouse.setMaxCapacity(rs.getInt("maxCapacity"));
                    warehouses.add(warehouse);
                }
                
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        return warehouses; 
    }
}
