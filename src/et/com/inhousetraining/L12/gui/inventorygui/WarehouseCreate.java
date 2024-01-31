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



class WarehouseCreate extends JPanel implements ActionListener {
 
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
    private JTextArea resadd;
    
    private InventorySystem inventorySystemFrame;
 
   

    public WarehouseCreate(InventorySystem inventorySystemFrame)
    {
        this.inventorySystemFrame = inventorySystemFrame;

        setBounds(0, 0, 900, 600);


        setLayout(null);
        
        title = new JLabel("Create New Warehouse");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(600, 30);
        title.setLocation(200, 30);
        this.add(title);
 
        location = new JLabel("Location");
        location.setFont(new Font("Arial", Font.PLAIN, 20));
        location.setSize(150, 20);
        location.setLocation(40, 100);
        this.add(location);
 
        tlocation = new JTextField();
        tlocation.setFont(new Font("Arial", Font.PLAIN, 20));
        tlocation.setSize(350, 30);
        tlocation.setLocation(200, 100);
        this.add(tlocation);
 
        currentQuantity = new JLabel("Current Quantity");
        currentQuantity.setFont(new Font("Arial", Font.PLAIN, 20));
        currentQuantity.setSize(150, 20);
        currentQuantity.setLocation(40, 150);
        this.add(currentQuantity);
 
        tcurrentQuantity = new JTextField();
        tcurrentQuantity.setFont(new Font("Arial", Font.PLAIN, 20));
        tcurrentQuantity.setSize(350, 30);
        tcurrentQuantity.setLocation(200, 150);
        this.add(tcurrentQuantity);
 
        maxCapacity = new JLabel("Max Capacity");
        maxCapacity.setFont(new Font("Arial", Font.PLAIN, 20));
        maxCapacity.setSize(150, 20);
        maxCapacity.setLocation(40, 200);
        this.add(maxCapacity);
 
        tmaxCapacity = new JTextField();
        tmaxCapacity.setFont(new Font("Arial", Font.PLAIN, 20));
        tmaxCapacity.setSize(350, 30);
        tmaxCapacity.setLocation(200, 200);
        this.add(tmaxCapacity);
 
       
     
 
        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 20));
        sub.setSize(100, 20);
        sub.setLocation(230, 450);
        sub.addActionListener(this);
        this.add(sub);
 
        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 20));
        reset.setSize(100, 20);
        reset.setLocation(350, 450);
        reset.addActionListener(this);
        this.add(reset);
 

 
        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        this.add(res);

 
        setVisible(true);
    }
 
    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == sub) {
                
                Warehouse ws = new Warehouse(0,tlocation.getText(), Integer.parseInt(tcurrentQuantity.getText()), Integer.parseInt(tmaxCapacity.getText()));
                InventoryService is = new InventoryService();
                is.addWarehouse(ws);
                
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
 
