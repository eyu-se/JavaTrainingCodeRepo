/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.gui.training;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;

/**
 *
 * @author eyu
 */

public class Tooltips extends JFrame {

    private Toolkit toolkit;

    public Tooltips() {
        setTitle("Tooltip");
        setSize(300, 200);
        
        toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation((size.width - getWidth()) / 2, (size.height
                - getHeight()) / 2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);
        
        panel.setToolTipText("A Panel container");
        
        JButton button = new JButton("Button");
        button.setBounds(100, 60, 80, 30);
        
        button.setToolTipText("A button component");
        panel.add(button);
    }

    public static void main(String[] args) {
        Tooltips tooltip = new Tooltips();
        tooltip.setVisible(true);
    }
}
