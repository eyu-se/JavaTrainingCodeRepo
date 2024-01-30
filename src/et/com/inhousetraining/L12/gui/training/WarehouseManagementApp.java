/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.gui.training;


import et.com.inhousetraining.L12.models.Warehouse;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author eyu
 */


public class WarehouseManagementApp extends JFrame implements ActionListener {
    private DefaultTableModel tableModel;
    private JTable warehouseTable;
    private JScrollPane scrollPane;
    private JButton addBtn, editBtn, viewBtn, deleteBtn;
    private WarehouseForm warehouseForm;

    public WarehouseManagementApp() {
        setTitle("Warehouse Management App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);

        // Create a vertical toolbar on the left side
        createToolBar();

        // Initialize the table
        initializeTable();

        // Initialize buttons
        addBtn = new JButton("Add Warehouse");
        editBtn = new JButton("Edit Warehouse");
        viewBtn = new JButton("View Warehouse");
        deleteBtn = new JButton("Delete Warehouse");

        // Add action listeners to buttons
        addBtn.addActionListener(this);
        editBtn.addActionListener(this);
        viewBtn.addActionListener(this);
        deleteBtn.addActionListener(this);

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        buttonPanel.add(addBtn);
        buttonPanel.add(editBtn);
        buttonPanel.add(viewBtn);
        buttonPanel.add(deleteBtn);

        // Create a container
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        // Add the button panel to the west (left) side
        container.add(buttonPanel, BorderLayout.WEST);

        // Add the table with scroll pane to the center
        container.add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private void createToolBar() {
        JToolBar toolBar = new JToolBar(JToolBar.VERTICAL);
        toolBar.setFloatable(false);

        JButton option1 = new JButton("Option 1");
        JButton option2 = new JButton("Option 2");
        JButton option3 = new JButton("Option 3");

        toolBar.add(option1);
        toolBar.add(option2);
        toolBar.add(option3);

        getContentPane().add(toolBar, BorderLayout.WEST);
    }

    private void initializeTable() {
        // Create a table model with column names
        String[] columnNames = {"ID", "Location", "Current Quantity", "Max Capacity"};
        tableModel = new DefaultTableModel(columnNames, 0);

        // Create a JTable with the table model
        warehouseTable = new JTable(tableModel);
        warehouseTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        warehouseTable.setAutoCreateRowSorter(true);

        // Create a scroll pane and add the table to it
        scrollPane = new JScrollPane(warehouseTable);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {
            // Open the warehouse form for adding a new warehouse
            warehouseForm = new WarehouseForm(this, "Add Warehouse", null);
        } else if (e.getSource() == editBtn) {
            // Check if a row is selected
            int selectedRow = warehouseTable.getSelectedRow();
            if (selectedRow != -1) {
                // Get the warehouse ID from the selected row
                int warehouseID = (int) warehouseTable.getValueAt(selectedRow, 0);

                // Open the warehouse form for editing
                warehouseForm = new WarehouseForm(this, "Edit Warehouse", getWarehouseByID(warehouseID));
            } else {
                JOptionPane.showMessageDialog(this, "Please select a warehouse to edit.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == viewBtn) {
            // Check if a row is selected
            int selectedRow = warehouseTable.getSelectedRow();
            if (selectedRow != -1) {
                // Get the warehouse ID from the selected row
                int warehouseID = (int) warehouseTable.getValueAt(selectedRow, 0);

                // Open the warehouse form for viewing
                warehouseForm = new WarehouseForm(this, "View Warehouse", getWarehouseByID(warehouseID));
            } else {
                JOptionPane.showMessageDialog(this, "Please select a warehouse to view.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == deleteBtn) {
            // Check if a row is selected
            int selectedRow = warehouseTable.getSelectedRow();
            if (selectedRow != -1) {
                // Get the warehouse ID from the selected row
                int warehouseID = (int) warehouseTable.getValueAt(selectedRow, 0);

                // Confirm deletion
                int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this warehouse?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    // Delete the warehouse
                    deleteWarehouse(warehouseID);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a warehouse to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void addWarehouse(Warehouse warehouse) {
        // Add a new row to the table
        Object[] rowData = {warehouse.getWarehouseID(), warehouse.getLocation(), warehouse.getCurrentQuantity(), warehouse.getMaxCapacity()};
        tableModel.addRow(rowData);
    }

    public void updateWarehouse(Warehouse warehouse) {
        // Find the row index based on the warehouse ID
        int rowIndex = findRowIndex(warehouse.getWarehouseID());
        if (rowIndex != -1) {
            // Update the values in the corresponding row
            warehouseTable.setValueAt(warehouse.getLocation(), rowIndex, 1);
            warehouseTable.setValueAt(warehouse.getCurrentQuantity(), rowIndex, 2);
            warehouseTable.setValueAt(warehouse.getMaxCapacity(), rowIndex, 3);
        }
    }

    private void deleteWarehouse(int warehouseID) {
        // Find the row index based on the warehouse ID
        int rowIndex = findRowIndex(warehouseID);
        if (rowIndex != -1) {
            // Remove the corresponding row
            tableModel.removeRow(rowIndex);
        }
    }

    private int findRowIndex(int warehouseID) {
        // Iterate through rows to find the index of the row with the specified warehouse ID
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if ((int) tableModel.getValueAt(i, 0) == warehouseID) {
                return i;
            }
        }
        return -1; // Warehouse ID not found
    }

    private Warehouse getWarehouseByID(int warehouseID) {
        // Retrieve a Warehouse object based on the warehouse ID
        // This is a placeholder method; you might have your own mechanism for fetching data.
        // Here, it simply creates a Warehouse object with dummy data.
        return new Warehouse(warehouseID, "Sample Location", 50, 100);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WarehouseManagementApp());
    }
    
}