/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.gui.training;

import et.com.inhousetraining.L12.models.*;
import java.awt.Container;
import javax.swing.*;

/**
 *
 * @author eyu
 */
public class InventorySystem extends JFrame {
    private Container container;
    private WarehouseCreate warehouseCreatePanel;
    private WarehouseEdit warehouseUpdatePanel;
    private JPanel contentPanel = new JPanel();


    public InventorySystem(){
        setTitle("Inventory System");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false); 
        container = getContentPane();
        container.setLayout(null);
        container.add(contentPanel);
        
        
        
    }
    
    
    public void changeToAddNewWarehouse(WarehouseCreate warehouseCreatePanel){
        setVisible(false);
        this.warehouseCreatePanel = warehouseCreatePanel;
        container.remove(this.contentPanel);
        contentPanel = warehouseCreatePanel;
        container.add(this.contentPanel);
        setVisible(true);
    }
    
    
    public void changeToEditWarehouse(WarehouseEdit warehouseUpdatePanel){
        setVisible(false);
        this.warehouseUpdatePanel = warehouseUpdatePanel;
        container.remove(this.contentPanel);
        contentPanel = warehouseUpdatePanel;
        container.add(this.contentPanel);
        setVisible(true);
    }
    
    
    public static void main(String[] args) {
        InventorySystem inventorySystem = new InventorySystem();
//        inventorySystem.getContentPane().add(new WarehouseEdit(new Warehouse(1,"Addis Ababa", 0, 200)));
//        inventorySystem.container.add(new WarehouseCreate());

        inventorySystem.setVisible(true);
        
        inventorySystem.changeToAddNewWarehouse(new WarehouseCreate(inventorySystem));
        
        inventorySystem.changeToEditWarehouse(new WarehouseEdit(new Warehouse(1,"Addis Ababa", 0, 200), inventorySystem));
        
        
        
        
    }
    
}
