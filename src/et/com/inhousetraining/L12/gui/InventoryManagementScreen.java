/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;


/**
 *
 * @author eyu
 */
public class InventoryManagementScreen extends JFrame {
    
    public InventoryManagementScreen(){
        setTitle("Inventory Management");
        setSize(900, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        createMenuBar();
        createToolBar();
        
        
        JPanel panel = new JPanel();
        panel.setSize(800, 700);
        panel.setBackground(Color.gray);
        add(panel, BorderLayout.CENTER);
        
    }
    
    
    public void createMenuBar(){
        JMenuBar menubar = new JMenuBar();
        
        JMenu file = new JMenu("File");
        
        ImageIcon icon = new ImageIcon("./src/resources/images/exit.png");
        
        JMenuItem fileClose = new JMenuItem("Close", icon);
        fileClose.setToolTipText("Close the inventory App");
        
        fileClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        
        file.add(fileClose);
        
        JMenu view = new JMenu("View");
        
        JMenuItem fullScreen = new JMenuItem("Full Screen");
        fullScreen.setToolTipText("Expand to full screen mode");
        view.add(fullScreen);
        
        
        menubar.add(file);
        menubar.add(view);
        
        setJMenuBar(menubar);

    }
    
    
    public void createToolBar(){
        
          JToolBar toolbar = new JToolBar(JToolBar.VERTICAL);
          
          ImageIcon iconWarehouses = new ImageIcon(new ImageIcon("src/resources/images/warehouseIcon.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
          ImageIcon iconAddWarehouse = new ImageIcon(new ImageIcon("src/resources/images/warehouseAddIcon.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));


        
        JButton warehousesB = new JButton(iconWarehouses);
        JButton addWarehousesB = new JButton(iconAddWarehouse);

       
        toolbar.add(warehousesB);
        toolbar.add(addWarehousesB);


        add(toolbar, BorderLayout.WEST);

    }
    
}
