/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.gui.training;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author eyu
 */

public class NullManagerAbsolutePosition extends JFrame {

    public NullManagerAbsolutePosition() {
        
        setTitle("Absolute positioning");
        
        setLayout(null);
        
        JButton ok = new JButton("OK");
        ok.setBounds(50, 150, 80, 25);
        
        JButton close = new JButton("Close");
        close.setBounds(150, 150, 80, 25);
        
        add(ok);
        add(close);
        
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }

    public static void main(String[] args) {
        
        new NullManagerAbsolutePosition();
        
    }
}
