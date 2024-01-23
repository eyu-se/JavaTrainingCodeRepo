/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.gui.training;

import javax.swing.JFrame;

/**
 *
 * @author eyu
 */

public class EmptyWindow extends JFrame {

    public EmptyWindow() {
        setSize(300, 200);
        setTitle("Simple");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EmptyWindow simple = new EmptyWindow();
        simple.setVisible(true);
    }
}
