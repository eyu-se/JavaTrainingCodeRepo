/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.gui.training;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author eyu
 */

public class SimpleBorderLayoutExample extends JFrame {

    public SimpleBorderLayoutExample() {
        setTitle("Border Example");
        
        JPanel panel = new JPanel(new BorderLayout());
        
        JPanel top = new JPanel();
        top.setBackground(Color.gray);
        top.setPreferredSize(new Dimension(250, 150));
        
        panel.add(top);
        panel.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));
        
        add(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleBorderLayoutExample();
    }
}
