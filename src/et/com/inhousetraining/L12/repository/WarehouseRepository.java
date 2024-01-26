/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.repository;

import et.com.inhousetraining.L12.models.*;
import et.com.inhousetraining.L12.util.ReadFile;
import et.com.inhousetraining.L12.util.WriteFile;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eyu
 */
public class WarehouseRepository {
    
    public static List<Warehouse> warehouses = new ArrayList<>();

    
    public void addWarehouse(Warehouse warehouse) {
        warehouses.add(warehouse);
    }
    
    public void deleteWarehouse(int warehouseId){
        
//        Warehouse warehouseToDelete = this.getWarehouseById(warehouseId);
//        warehouses.remove(warehouseToDelete);

        for (int i = 0; i < warehouses.size(); i++) {
            if(warehouseId == warehouses.get(i).getWarehouseID()){
                warehouses.remove(i);
                break;
            }
        }
        
    }
    public Warehouse getWarehouseById(int warehouseId) {
        for (Warehouse warehouse : warehouses) {
            if (warehouse.getWarehouseID() == warehouseId) {
                return warehouse;
            }
        }
        return null; // Warehouse not found
    }
    

    public void updateWarehouse(Warehouse updatedWarehouse) {
        for (int i = 0; i < warehouses.size(); i++) {
            if (warehouses.get(i).getWarehouseID() == updatedWarehouse.getWarehouseID()) {
                warehouses.set(i, updatedWarehouse);
                break;
            }
        }
    }

    // Additional methods as needed

    public List<Warehouse> getAllWarehouses() {
        return warehouses;
    }
    
    
    public Warehouse parseWarehouse(String line){
        String[] warehouseData = line.split(",");
        Warehouse ws = new Warehouse();
        ws.setWarehouseID(Integer.parseInt(warehouseData[0]));
        ws.setLocation(warehouseData[1]);
        ws.setCurrentQuantity(Integer.parseInt(warehouseData[2]));
        ws.setMaxCapacity(Integer.parseInt(warehouseData[3]));

        return ws;
        
    }
    
    public List<Warehouse> readWarehousesFromFile(String path){
        try {
            ReadFile rf = new ReadFile(path);
            List<String> textData = rf.readFile();
            List<Warehouse> warehouses = new ArrayList<>();
            
            for(String s: textData){
                warehouses.add(parseWarehouse(s));
            }
            
            return warehouses;
            
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        } catch (IOException e) {
            System.out.println("Error reading from file");
        }
        return null;
    }
    
    
    
    
    public void writeWarehouseToFile(String warehouse, String path, boolean append) {
        try {
            WriteFile wf = new WriteFile(path, append);

            wf.writeToFile(warehouse);

        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void exportWarehousesToFile(String path) {
        
        for(int i=0; i< warehouses.size();i++){
            if(i == 0){
                writeWarehouseToFile(warehouses.get(i).convertToCSVFormat(),path, false);
                continue;
            }
            writeWarehouseToFile(warehouses.get(i).convertToCSVFormat(),path, true);
        }
    }
}
