/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.gui.training;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 *
 * @author eyu
 */

public class MultipleToolbars extends JFrame {

    public MultipleToolbars() {
        setTitle("Toolbars");
        JToolBar toolbar1 = new JToolBar();
        JToolBar toolbar2 = new JToolBar();
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        ImageIcon newi = new ImageIcon(new ImageIcon("src/resources/images/new.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        ImageIcon open = new ImageIcon(new ImageIcon("src/resources/images/open.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        ImageIcon save = new ImageIcon(new ImageIcon("src/resources/images/save.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        ImageIcon exit = new ImageIcon(new ImageIcon("src/resources/images/exit.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));

        JButton newb = new JButton(newi);
        JButton openb = new JButton(open);
        JButton saveb = new JButton(save);
        toolbar1.add(newb);
        toolbar1.add(openb);
        toolbar1.add(saveb);
        toolbar1.setAlignmentX(0);
        
        JButton exitb = new JButton(exit);
        toolbar2.add(exitb);
        toolbar2.setAlignmentX(0);
        
        exitb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        
        panel.add(toolbar1);
        panel.add(toolbar2);
        
        add(panel, BorderLayout.NORTH);
        
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MultipleToolbars();
    }
}
