/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.gui.training;
import et.com.inhousetraining.L12.models.Warehouse;
import et.com.inhousetraining.L12.services.InventoryService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author eyu
 */



// Driver Code
class EditWarehouseForm {
 
    public static void main(String[] args) throws Exception
    {
        InventoryService is = new InventoryService();
        
        //WarehouseEdit f = new WarehouseEdit(is.getWarehouseById(1));
        
    }
}

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
    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;
    private InventorySystem inventorySystemFrame;

    
    private Warehouse warehouseToEdit;
   

    public WarehouseEdit(Warehouse warehouse, InventorySystem inventorySystemFrame)
    {
        this.inventorySystemFrame = inventorySystemFrame;
        this.warehouseToEdit = warehouse;
        
//        setTitle("Create Warehouse Form");
        setBounds(0, 0, 900, 600);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setResizable(false);
 
//        c = getContentPane();
//        c.setLayout(null);
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
 
        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 20));
        reset.setSize(100, 20);
        reset.setLocation(270, 450);
        reset.addActionListener(this);
        this.add(reset);
 
        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 20));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        this.add(tout);
 
        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        this.add(res);
 
        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(true);
        this.add(resadd);
        
        
        
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
                String display = "Warehouse Location : "+ws.getLocation()+
                        "\nWarehouse Current Quantity : "+ws.getCurrentQuantity()+
                        "\nWarehouse Max Capacity : "+ws.getMaxCapacity();
                tout.setText(display);
                tout.setEditable(false);
                
                res.setText("Warehouse Created Successfully..");
            
        }
 
        else if (e.getSource() == reset) {
            String def = "";
            tlocation.setText(def);
            tcurrentQuantity.setText(def);
            tmaxCapacity.setText(def);
            res.setText(def);
            tout.setText(def);
            resadd.setText(def);
        }
    }
}
 
