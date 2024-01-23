/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.gui.training;

import java.awt.*;
import javax.swing.JFrame;

/**
 *
 * @author eyu
 */
public class CenterOnScreen extends JFrame {

    public CenterOnScreen() {
        setSize(300, 200);
        setTitle("CenterOnScreen");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2,
                size.height / 2 - getHeight() / 2);
    }

    public static void main(String[] args) {
        CenterOnScreen cos = new CenterOnScreen();
        cos.setVisible(true);
    }
}
