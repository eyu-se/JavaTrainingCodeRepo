/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.gui.training;

import et.com.inhousetraining.L12.models.Warehouse;
import et.com.inhousetraining.L12.services.InventoryService;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
/**
 *
 * @author eyu
 */


public class ViewWarehousesList extends JFrame
{
    public ViewWarehousesList()
    {
        //headers for the table
        String[] columns = new String[] {
            "Id", "Location", "Current Quantity", "Max Capacity"
        };
         
        //actual data for the table in a 2d array
        List<Warehouse> warehouses = new InventoryService().getAllWarehouses();
        Object[][] data = new Object[warehouses.size()][4];
        for (int i = 0; i < warehouses.size(); i++) {
            data[i] = new Object[] {warehouses.get(i).getWarehouseID(), warehouses.get(i).getLocation(), warehouses.get(i).getCurrentQuantity(), warehouses.get(i).getMaxCapacity()};
        }
        //create table with data
        JTable table = new JTable(data, columns);
         
        //add the table to the frame
        this.add(new JScrollPane(table));
         
        this.setTitle("Available Warehouses");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        this.pack();
        this.setVisible(true);
    }
     
    public static void main(String[] args)
    {
        
                new ViewWarehousesList();
       
  
    }
}