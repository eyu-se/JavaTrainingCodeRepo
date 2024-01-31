/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.gui.inventorygui;

import et.com.inhousetraining.L12.models.*;
import et.com.inhousetraining.L12.services.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
/**
 *
 * @author eyu
 */



public class TableWarehousesListJpanel extends JPanel {
    private JTable table;
    private List<Warehouse> warehouses;
    private InventorySystem inventorySystemFrame;

    public TableWarehousesListJpanel(InventorySystem inventorySystemFrame) {
        this.inventorySystemFrame = inventorySystemFrame;
        setBounds(0, 0, 900, 600);
        // headers for the table
        String[] columns = new String[]{
                "Id", "Location", "Current Quantity", "Max Capacity"
        };

        // actual data for the table in a 2d array
        warehouses = new InventoryService().getAllWarehouses();
        Object[][] data = new Object[warehouses.size()][4];
        for (int i = 0; i < warehouses.size(); i++) {
            data[i] = new Object[]{warehouses.get(i).getWarehouseID(), warehouses.get(i).getLocation(), warehouses.get(i).getCurrentQuantity(), warehouses.get(i).getMaxCapacity()};
        }

        // create table with data
        table = new JTable(data, columns);

        // add the table to the frame
        this.add(new JScrollPane(table));

        // Add selection listener to the table
        table.getSelectionModel().addListSelectionListener(new TableSelectionListener());

        this.setVisible(true);
    }

    private class TableSelectionListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    // Display row information in a JDialog
                    displayRowInfo(selectedRow);
                }
            }
        }
    }

    private void displayRowInfo(int row) {
        // Get data from the selected row
        String id = table.getValueAt(row, 0).toString();
        String location = table.getValueAt(row, 1).toString();
        String currentQuantity = table.getValueAt(row, 2).toString();
        String maxCapacity = table.getValueAt(row, 3).toString();

        JButton editB = new JButton("Edit");
        JButton deleteB = new JButton("Delete");
        
        
        
        // Create and show a JDialog with the row information
        JDialog dialog = new JDialog(this.inventorySystemFrame, "Warehouse Information", true);
        JPanel panel = new JPanel(new GridLayout(5, 2));
        
        editB.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        inventorySystemFrame.changeToEditWarehouse(Integer.parseInt(id));
                        dialog.setVisible(false);
                    }
                });
        
        deleteB.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        inventorySystemFrame.inventoryService.deleteWarehouse(Integer.parseInt(id));
                        inventorySystemFrame.changeToViewWarehouses();
                        dialog.setVisible(false);
                    }
                });
        
        panel.add(new JLabel("ID:"));
        panel.add(new JLabel(id));
        panel.add(new JLabel("Location:"));
        panel.add(new JLabel(location));
        panel.add(new JLabel("Current Quantity:"));
        panel.add(new JLabel(currentQuantity));
        panel.add(new JLabel("Max Capacity:"));
        panel.add(new JLabel(maxCapacity));

        panel.add(editB);
        panel.add(deleteB);
        
        
        
        dialog.add(panel);
        dialog.setSize(300, 150);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

   
}
