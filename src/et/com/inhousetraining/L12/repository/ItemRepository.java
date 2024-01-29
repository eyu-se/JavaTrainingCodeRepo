/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.repository;

import com.mysql.jdbc.PreparedStatement;
import et.com.inhousetraining.L12.models.Item;
import et.com.inhousetraining.L12.models.Warehouse;
import et.com.inhousetraining.L12.util.MySQLJDBCUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eyu
 */
public class ItemRepository {


    public void addItem(Item item) {
        // for insert a new warehouse
        ResultSet rs = null;

        String sql = "INSERT INTO item(name,description) "
                + "VALUES(?,?)";

        try (
                Connection conn = MySQLJDBCUtil.getConnection(); PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);) {

            // set parameters for statement
            pstmt.setString(1, item.getName());
            pstmt.setString(2, item.getDescription());

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void deleteItem(int itemId) {

        String sql = "DELETE FROM item WHERE itemId = ?";

        try (
                Connection conn = MySQLJDBCUtil.getConnection(); PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);) {

            // set parameters for statement
            pstmt.setInt(1, itemId);

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public Item getItemById(int itemId) {
        ResultSet rs = null;
        String sql = "SELECT itemId, name, description FROM item WHERE itemId = ?";

        try (
                Connection conn = MySQLJDBCUtil.getConnection(); PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);) {

            // set parameters for statement
            pstmt.setInt(1, itemId);

            rs = pstmt.executeQuery();

            while (rs.next()) {

                Item item = new Item();
                item.setItemID(rs.getInt("itemId"));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
                return item;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null; // Warehouse not found
    }

    public void updateItem(Item updatedItem) {

        String sqlUpdate = "UPDATE item "
                + "SET name = ? "
                + ", description = ? "
                + "WHERE itemId = ?";

        try (Connection conn = MySQLJDBCUtil.getConnection(); PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sqlUpdate)) {
            // prepare data for update

            pstmt.setString(1, updatedItem.getName());
            pstmt.setString(2, updatedItem.getDescription());
            pstmt.setInt(3, updatedItem.getItemID());

            int rowAffected = pstmt.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Additional methods as needed
    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();

        String sql = "SELECT itemId, name, description "
                + "FROM item";

        try (Connection conn = MySQLJDBCUtil.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {

                Item item = new Item();
                item.setItemID(rs.getInt("itemId"));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
                items.add(item);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return items;
    }
}
