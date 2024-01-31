/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.gui.training;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author eyu
 */
public class SimpleSubMenu extends JFrame {

    public SimpleSubMenu() {
        setTitle("Simple Submenu");

        JMenuBar menubar = new JMenuBar();

        ImageIcon iconNew = new ImageIcon(new ImageIcon("src/resources/images/new.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

        ImageIcon iconOpen = new ImageIcon(new ImageIcon("src/resources/images/open.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

        ImageIcon iconSave = new ImageIcon(new ImageIcon("src/resources/images/save.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

        ImageIcon iconClose = new ImageIcon(new ImageIcon("src/resources/images/exit.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);

        JMenu imp = new JMenu("Import");
        imp.setMnemonic(KeyEvent.VK_M);

        JMenuItem newsf = new JMenuItem("Import newsfeed list...");
        JMenuItem bookm = new JMenuItem("Import bookmarks...");
        JMenuItem mail = new JMenuItem("Import mail...");
        imp.add(newsf);
        imp.add(bookm);
        imp.add(mail);

        JMenuItem fileNew = new JMenuItem("New", iconNew);
        fileNew.setMnemonic(KeyEvent.VK_N);

        JMenuItem fileOpen = new JMenuItem("Open", iconOpen);
        fileNew.setMnemonic(KeyEvent.VK_O);

        JMenuItem fileSave = new JMenuItem("Save", iconSave);
        fileSave.setMnemonic(KeyEvent.VK_S);

        JMenuItem fileClose = new JMenuItem("Close", iconClose);
        fileClose.setMnemonic(KeyEvent.VK_C);
        fileClose.setToolTipText("Exit application");
        fileClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        fileClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        
        
        file.add(fileNew);
        file.add(fileOpen);
        file.add(fileSave);
        
        file.addSeparator();
        
        file.add(imp);
        
        file.addSeparator();
        
        file.add(fileClose);

        menubar.add(file);
        setJMenuBar(menubar);
        setSize(360, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleSubMenu();
    }
}
