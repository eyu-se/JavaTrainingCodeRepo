/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.gui.inventorygui;

import et.com.inhousetraining.L12.services.InventoryService;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author eyu
 */
public class InventorySystem extends JFrame implements ActionListener {
    public Container container;
    private WarehouseCreate warehouseCreatePanel;
    private WarehouseEdit warehouseUpdatePanel;
    private TableWarehousesListJpanel warehousesListPanel;
    private JPanel contentPanel = new JPanel();
    public InventoryService inventoryService;

    
    private JButton allBtn, addBtn, allItemBtn, addItemBtn;

    public InventorySystem(){
        setTitle("Inventory System");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false); 
        
        warehouseCreatePanel = new WarehouseCreate(this);
        warehousesListPanel = new TableWarehousesListJpanel(this);
        inventoryService = new InventoryService();
        
        
        container = getContentPane();
        container.setLayout(null);
        container.add(contentPanel);
        
        init();
        
    }
    
    
     public void init() {

        // Initialize buttons
        allBtn = new JButton("View Warehouses");
        addBtn = new JButton("Add Warehouse");
        allItemBtn = new JButton("View Items");
        addItemBtn = new JButton("Add Item");

        // Add action listeners to buttons
        allBtn.addActionListener(this);
        addBtn.addActionListener(this);
        allItemBtn.addActionListener(this);
        addItemBtn.addActionListener(this);

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        buttonPanel.add(allBtn);
        buttonPanel.add(addBtn);
        buttonPanel.add(allItemBtn);
        buttonPanel.add(addItemBtn);

        // Create a container
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        // Add the button panel to the west (left) side
        container.add(buttonPanel, BorderLayout.WEST);
        contentPanel = new TableWarehousesListJpanel(this);
        // Add the table with scroll pane to the center
        container.add(contentPanel, BorderLayout.CENTER);

        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {
            changeToAddNewWarehouse();

        }
        else if (e.getSource() == allBtn) {
            changeToViewWarehouses();
            
        }

    }
    
    
    public void changeToAddNewWarehouse(){
        this.warehouseCreatePanel = new WarehouseCreate(this);
        container.remove(this.contentPanel);
        contentPanel = warehouseCreatePanel;
        container.add(this.contentPanel);
        setVisible(true);
    }
    
    
    public void changeToEditWarehouse(int warehouseId){
        this.warehouseUpdatePanel = new WarehouseEdit(warehouseId, this);
        container.remove(this.contentPanel);
        contentPanel = warehouseUpdatePanel;
        container.add(this.contentPanel);
        setVisible(true);
    }
    
    
     public void changeToViewWarehouses(){
        this.warehousesListPanel = new TableWarehousesListJpanel(this);
        container.remove(this.contentPanel);
        contentPanel = this.warehousesListPanel;
        container.add(this.contentPanel);
        setVisible(true);
    }
    
    
    public static void main(String[] args) {
        InventorySystem inventorySystem = new InventorySystem();
        inventorySystem.setVisible(true);
        
    }
    
}
