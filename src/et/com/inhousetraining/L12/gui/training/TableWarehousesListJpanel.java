/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.gui.training;

import et.com.inhousetraining.L12.models.*;
import et.com.inhousetraining.L12.services.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.List;
/**
 *
 * @author eyu
 */



public class TableWarehousesListJpanel extends JPanel {
    private JTable table;
    private List<Warehouse> warehouses;
    private JFrame parentFrame;

    public TableWarehousesListJpanel(JFrame parentFrame) {
        this.parentFrame = parentFrame;
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

//        this.setTitle("Available Warehouses");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.pack();
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

        // Create and show a JDialog with the row information
        JDialog dialog = new JDialog(this.parentFrame, "Warehouse Information", true);
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("ID:"));
        panel.add(new JLabel(id));
        panel.add(new JLabel("Location:"));
        panel.add(new JLabel(location));
        panel.add(new JLabel("Current Quantity:"));
        panel.add(new JLabel(currentQuantity));
        panel.add(new JLabel("Max Capacity:"));
        panel.add(new JLabel(maxCapacity));

        dialog.add(panel);
        dialog.setSize(300, 150);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

   
}
