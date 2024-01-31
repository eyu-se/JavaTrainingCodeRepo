/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.gui.inventorygui;
import et.com.inhousetraining.L12.models.Warehouse;
import et.com.inhousetraining.L12.services.InventoryService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author eyu
 */





class WarehouseEdit extends JPanel implements ActionListener {
 
    // Components of the Form
    private Container c;
    private JLabel title;
    private JLabel location;
    private JTextField tlocation;
    private JLabel currentQuantity;
    private JTextField tcurrentQuantity;
    private JLabel maxCapacity;
    private JTextField tmaxCapacity;
    
    
     private JCheckBox term;
    private JButton sub;
    private JButton reset;
//    private JTextArea tout;
    private JLabel res;
//    private JTextArea resadd;
    private InventorySystem inventorySystemFrame;

    
    private Warehouse warehouseToEdit;
   

    public WarehouseEdit(int id, InventorySystem inventorySystemFrame)
    {
        this.inventorySystemFrame = inventorySystemFrame;
        this.warehouseToEdit = inventorySystemFrame.inventoryService.getWarehouseById(id);
        
        setBounds(0, 0, 900, 600);

        setLayout(null);

 
        title = new JLabel("Update Warehouse");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        this.add(title);
 
        location = new JLabel("Location");
        location.setFont(new Font("Arial", Font.PLAIN, 20));
        location.setSize(150, 20);
        location.setLocation(40, 100);
        this.add(location);
 
        tlocation = new JTextField();
        tlocation.setFont(new Font("Arial", Font.PLAIN, 20));
        tlocation.setSize(190, 30);
        tlocation.setLocation(200, 100);
        this.add(tlocation);
 
        currentQuantity = new JLabel("Current Quantity");
        currentQuantity.setFont(new Font("Arial", Font.PLAIN, 20));
        currentQuantity.setSize(150, 20);
        currentQuantity.setLocation(40, 150);
        this.add(currentQuantity);
 
        tcurrentQuantity = new JTextField();
        tcurrentQuantity.setFont(new Font("Arial", Font.PLAIN, 20));
        tcurrentQuantity.setSize(190, 30);
        tcurrentQuantity.setLocation(200, 150);
        this.add(tcurrentQuantity);
 
        maxCapacity = new JLabel("Max Capacity");
        maxCapacity.setFont(new Font("Arial", Font.PLAIN, 20));
        maxCapacity.setSize(150, 20);
        maxCapacity.setLocation(40, 200);
        this.add(maxCapacity);
 
        tmaxCapacity = new JTextField();
        tmaxCapacity.setFont(new Font("Arial", Font.PLAIN, 20));
        tmaxCapacity.setSize(190, 30);
        tmaxCapacity.setLocation(200, 200);
        this.add(tmaxCapacity);
 
       
     
 
        sub = new JButton("Update");
        sub.setFont(new Font("Arial", Font.PLAIN, 20));
        sub.setSize(100, 20);
        sub.setLocation(150, 450);
        sub.addActionListener(this);
        this.add(sub);

 
        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        this.add(res);
 

        
        
        SetOriginalValues();
 
        setVisible(true);
        
        
        
    }
    
    public void SetOriginalValues(){
        tlocation.setText(this.warehouseToEdit.getLocation());
        tcurrentQuantity.setText(this.warehouseToEdit.getCurrentQuantity()+"");
        tmaxCapacity.setText(this.warehouseToEdit.getMaxCapacity()+"");


    }
    
 
    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == sub) {
                
                Warehouse ws = new Warehouse(this.warehouseToEdit.getWarehouseID(),tlocation.getText(), Integer.parseInt(tcurrentQuantity.getText()), Integer.parseInt(tmaxCapacity.getText()));
                
                InventoryService is = new InventoryService();
                is.updateWarehouse(ws);
                
                inventorySystemFrame.changeToViewWarehouses();
                
            
        }
 
        else if (e.getSource() == reset) {
            String def = "";
            tlocation.setText(def);
            tcurrentQuantity.setText(def);
            tmaxCapacity.setText(def);
            res.setText(def);

        }
    }
}
 
