/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.gui.training;




import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTree;

/**
 *
 * @author eyu
 */

public class FlowTest extends JFrame {

    public FlowTest() {
        
        setTitle("FlowLayout Example");
        
        JPanel panel = new JPanel();
        
        //FlowLayout(int align, int hgap, int vgap)
        
//        panel.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
//        panel.setLayout(new FlowLayout(FlowLayout.RIGHT,10,10));
//        panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        
        JTextArea area = new JTextArea("text area");
        area.setPreferredSize(new Dimension(100, 100));
        
        JButton button = new JButton("button");
        
        JTree tree = new JTree();
        
        panel.add(button);
        panel.add(tree);
        panel.add(area);
        
        add(panel);
        
        pack();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FlowTest();
    }
}
