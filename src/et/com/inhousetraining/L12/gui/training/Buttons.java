/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.gui.training;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author eyu
 */
public class Buttons extends JFrame {

    private Toolkit toolkit;

    public Buttons() {
        setTitle("Buttons");
        setSize(300, 200);
        toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation((size.width - getWidth()) / 2, (size.height
                - getHeight()) / 2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);
        
        JButton beep = new JButton("Beep");
        beep.setBounds(150, 60, 80, 30);
        beep.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                toolkit.beep();
            }
        });
        
        JButton close = new JButton("Close");
        close.setBounds(50, 60, 80, 30);
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        
        close.setToolTipText("Clcik this button to close the window");
        
        panel.add(beep);
        panel.add(close);
    }

    public static void main(String[] args) {
        Buttons buttons = new Buttons();
        buttons.setVisible(true);
    }
}
