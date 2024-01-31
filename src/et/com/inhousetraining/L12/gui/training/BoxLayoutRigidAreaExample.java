/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.gui.training;

import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author eyu
 */

public class BoxLayoutRigidAreaExample extends JFrame {

    public BoxLayoutRigidAreaExample() {
        setTitle("RigidArea Example");
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        panel.setBorder(new EmptyBorder(new Insets(40, 60, 40, 60)));
        panel.add(new JButton("Button"));
        
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(new JButton("Button"));
        
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(new JButton("Button"));
        
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(new JButton("Button"));
        
        add(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BoxLayoutRigidAreaExample();
    }
}
