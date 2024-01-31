/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.app;

import et.com.inhousetraining.L12.gui.inventorygui.InventorySystem;
import et.com.inhousetraining.L12.services.*;
import et.com.inhousetraining.L12.models.*;
import et.com.inhousetraining.L12.repository.*;
import java.util.List;

import java.util.Scanner;

/**
 *
 * @author eyu
 */
public class Main {
    
    public static void main(String[] args) {
        //Command Line Menu Based
//        InventoryManager inventoryManager = new InventoryManager();
//        inventoryManager.startManager();

        //GUI Based
        InventorySystem inventorySystem = new InventorySystem();
        inventorySystem.setVisible(true);
    }
    
    
    
}



