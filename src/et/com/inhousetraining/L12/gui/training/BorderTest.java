/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.gui.training;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author eyu
 */

public class BorderTest extends JFrame {

    public BorderTest() {

        setTitle("BorderLayout");
        
        JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("File");
        menubar.add(file);
        setJMenuBar(menubar);
        
        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);
        
        ImageIcon iconClose = new ImageIcon(new ImageIcon("src/resources/images/exit.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        JButton bexit = new JButton(iconClose);
        bexit.setBorder(new EmptyBorder(0, 0, 0, 0));
        toolbar.add(bexit);
        
        add(toolbar, BorderLayout.NORTH);
        
        JToolBar vertical = new JToolBar(JToolBar.VERTICAL);
        vertical.setFloatable(true);
        vertical.setMargin(new Insets(10, 5, 5, 5));
        
        ImageIcon iconNew = new ImageIcon(new ImageIcon("src/resources/images/new.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        ImageIcon iconOpen = new ImageIcon(new ImageIcon("src/resources/images/open.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        ImageIcon iconSave = new ImageIcon(new ImageIcon("src/resources/images/save.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));

        
        JButton newB = new JButton(iconNew);
        newB.setPreferredSize(new Dimension(200,200));
        newB.setBorder(new EmptyBorder(3, 0, 3, 0));
        
        JButton openB = new JButton(iconOpen);
        openB.setBorder(new EmptyBorder(3, 0, 3, 0));
        
        JButton saveB = new JButton(iconSave);
        saveB.setBorder(new EmptyBorder(3, 0, 3, 0));
        
        vertical.add(newB);
        vertical.add(openB);
        vertical.add(saveB);
        
        add(vertical, BorderLayout.WEST);
        add(new JTextArea(), BorderLayout.CENTER);
        
        JToolBar rightSideToolbar = new JToolBar(JToolBar.VERTICAL);
        rightSideToolbar.add(new JButton(new ImageIcon(new ImageIcon("src/resources/images/new.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH))));
        rightSideToolbar.add(new JButton(new ImageIcon(new ImageIcon("src/resources/images/save.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH))));
        rightSideToolbar.add(new JButton(new ImageIcon(new ImageIcon("src/resources/images/open.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH))));

  
        rightSideToolbar.setFloatable(false);

        //add(rightSideToolbar, BorderLayout.EAST);

        JLabel statusbar = new JLabel(" Statusbar");
        statusbar.setPreferredSize(new Dimension(-1, 22));
        statusbar.setBorder(LineBorder.createGrayLineBorder());
        
        add(statusbar, BorderLayout.SOUTH);
        
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BorderTest();
    }
}
