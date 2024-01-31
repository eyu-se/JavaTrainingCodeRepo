/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.gui.training;

import et.com.inhousetraining.L12.models.*;
import et.com.inhousetraining.L12.services.InventoryService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author eyu
 */

public class WarehouseForm extends JDialog implements ActionListener {
    private JLabel locationLabel, currentQuantityLabel, maxCapacityLabel;
    private JTextField locationField, currentQuantityField, maxCapacityField;
    private JButton saveBtn, cancelBtn;
    private InventoryService inventoryService = new InventoryService();
    private WarehouseManagementApp parent;
    private Warehouse warehouse;
    private String mode;  // "Add", "Edit", or "View"

    public WarehouseForm(WarehouseManagementApp parent, String mode, Warehouse warehouse) {
        //super(parent, "Warehouse Details", true);
        this.parent = parent;
        this.mode = mode;
        this.warehouse = warehouse;

        initializeComponents();
        setupLayout();
        setupListeners();

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void initializeComponents() {
        locationLabel = new JLabel("Location:");
        currentQuantityLabel = new JLabel("Current Quantity:");
        maxCapacityLabel = new JLabel("Max Capacity:");

        locationField = new JTextField(20);
        currentQuantityField = new JTextField(10);
        maxCapacityField = new JTextField(10);

        saveBtn = new JButton("Save");
        cancelBtn = new JButton("Cancel");

        // If editing or viewing, fill the fields with warehouse details
        if (mode.equals("Edit") || mode.equals("View")) {
            locationField.setText(warehouse.getLocation());
            currentQuantityField.setText(String.valueOf(warehouse.getCurrentQuantity()));
            maxCapacityField.setText(String.valueOf(warehouse.getMaxCapacity()));
        }

        // If viewing, make fields read-only
        if (mode.equals("View")) {
            locationField.setEditable(false);
            currentQuantityField.setEditable(false);
            maxCapacityField.setEditable(false);
            saveBtn.setEnabled(false);
        }
    }

    private void setupLayout() {
        setLayout(new GridLayout(4, 2, 10, 10));

        add(locationLabel);
        add(locationField);

        add(currentQuantityLabel);
        add(currentQuantityField);

        add(maxCapacityLabel);
        add(maxCapacityField);

        add(saveBtn);
        add(cancelBtn);
    }

    private void setupListeners() {
        saveBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveBtn) {
            // Validate input
            if (locationField.getText().isEmpty() || currentQuantityField.getText().isEmpty() || maxCapacityField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Create a new Warehouse object with input values
            Warehouse newWarehouse = new Warehouse(
                    (mode.equals("Edit") ? warehouse.getWarehouseID(): 0),
                    locationField.getText(),
                    Integer.parseInt(currentQuantityField.getText()),
                    Integer.parseInt(maxCapacityField.getText())
            );

            // Perform the appropriate action based on the mode
            if (mode.equals("Add")) {
                
                inventoryService.addWarehouse(newWarehouse);
            } else if (mode.equals("Edit")) {
                inventoryService.updateWarehouse(newWarehouse);
            }

            // Close the form
            dispose();
        } else if (e.getSource() == cancelBtn) {
            // Close the form without saving
            dispose();
        }
    }
}
