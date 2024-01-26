/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.app;

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
        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.inventoryService.addWarehousesDatabseFromFile("/Users/eyu/Documents/warehouses.csv");
        inventoryManager.startManager();
        inventoryManager.inventoryService.exportWarehousesDatabseToFile("/Users/eyu/Documents/warehouses.csv");


        
        
        
    }
    
    
    
}



