/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.util;

import et.com.inhousetraining.L12.app.InventoryManager;
import et.com.inhousetraining.L12.models.*;
import et.com.inhousetraining.L12.repository.*;
import et.com.inhousetraining.L12.services.InventoryService;
import java.io.*;
import java.util.*;

/**
 *
 * @author eyu
 */
public class FileData {

    public static void main(String[] args) {
//        InventoryService is = new InventoryService();
//        is.addWarehousesDatabseFromFile("/Users/eyu/Documents/warehouses.csv");
//        
//        InventoryManager inventoryManager = new InventoryManager();
//        inventoryManager.startManager();

        try {
            WriteFile fileWriter = new WriteFile("/Users/eyu/Documents/test.csv",true);
            fileWriter.writeToFile("3,Nokia,Feature phone");
           

        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    static void writeToFile() {
        try {
            WriteFile wf = new WriteFile("/Users/eyu/Documents/test.txt", true);

            wf.writeToFile("Jhon Jack, Liam, Test");

        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
