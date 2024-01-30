/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.gui.training;

import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.UIManager;

/**
 *
 * @author eyu
 */

public class VerticalToolbar extends JFrame {

    public VerticalToolbar() {
        setTitle("Vertical toolbar");
        JToolBar toolbar = new JToolBar(JToolBar.VERTICAL);
        ImageIcon iconNew = new ImageIcon(new ImageIcon("src/resources/images/new.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));

        ImageIcon iconOpen = new ImageIcon(new ImageIcon("src/resources/images/open.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));

        ImageIcon iconSave = new ImageIcon(new ImageIcon("src/resources/images/save.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));

        ImageIcon iconClose = new ImageIcon(new ImageIcon("src/resources/images/exit.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));

   
        JButton newb = new JButton(iconNew);
        JButton openb = new JButton(iconOpen);
        JButton saveb = new JButton(iconSave);
        JButton closeb = new JButton(iconClose);
       
        toolbar.add(newb);
        toolbar.add(openb);
        toolbar.add(saveb);
        toolbar.add(closeb);
      
        add(toolbar, BorderLayout.WEST);
        
        setSize(250, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
      
        new VerticalToolbar();
    }
}
