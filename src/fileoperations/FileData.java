/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fileoperations;

import et.com.inhousetraining.L12.app.InventoryManager;
import et.com.inhousetraining.L12.models.*;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eyu
 */
public class FileData {
    
    public static void main(String[] args) {
        String filePath = "/Users/eyu/Documents/Trainings/Java/Codes/JavaTrainingCodeRepo/src/fileoperations/warehouses.csv";
//        String filePath = "/Users/eyu/Documents/items.csv";

        ReadFile fileReader = new ReadFile(filePath);
        List<Warehouse> warehouses = new ArrayList<>();
        try {
            List<String> csvData = fileReader.openFile();
            for(String s : csvData){
                warehouses.add(extractWarehouse(s));
            }
        } catch (IOException ex) {
            System.out.println("Error Reading file");
        }
        
        for(Warehouse w: warehouses){
            w.display();
        }
    }
    
    public static Warehouse extractWarehouse(String text){
        
        String[] warehouseData = text.split(",");
        Warehouse newWarehouse = new Warehouse();
        newWarehouse.setWarehouseID(Integer.parseInt(warehouseData[0]));
        newWarehouse.setLocation(warehouseData[1]);
        newWarehouse.setCurrentQuantity(Integer.parseInt(warehouseData[2]));
        newWarehouse.setMaxCapacity(Integer.parseInt(warehouseData[3]));

        return newWarehouse;
    }
}
