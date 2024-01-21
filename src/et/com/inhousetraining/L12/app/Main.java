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
//        InventoryManager inventoryManager = new InventoryManager();
//        inventoryManager.startManager();

        InventoryService inventoryService = new InventoryService();
        
        Warehouse ws1 = new Warehouse();
        ws1.setWarehouseID(2);
        ws1.setLocation("Addis Ababa");
        ws1.setMaxCapacity(3000);
        ws1.setCurrentQuantity(0);
        
        Section w1s1 = new Section();
        w1s1.setSectionID(1);
        w1s1.setShelfNumber(1);
        w1s1.setAisleName("Aisle A");
        w1s1.setCurrentQuantity(0);
        w1s1.setMaxCapacity(400);
        
        
        
        inventoryService.addWarehouse(ws1);
        
        inventoryService.addSection(w1s1, ws1);
        
        if(inventoryService.getAllWarehouses().size() == 0){
            System.out.println("you dont have any warehouses yet");
        }
        for(Warehouse ws: inventoryService.getAllWarehouses()){
            
            System.out.println(ws.getWarehouseID());
            System.out.println(ws.getLocation());
            System.out.println(ws.getCurrentQuantity());
            System.out.println(ws.getMaxCapacity());
            
            System.out.println("Sections Count: "+ws.getSections()!=null ? ws.getSections().size():0 );
            
            if(!ws.getSections().isEmpty()) {
                for(Section s : ws.getSections() ){
                    System.out.println("Section ID : "+s.getSectionID());
                    System.out.println("Section getShelfNumber : "+s.getShelfNumber());
                    System.out.println("Section getAisleName : "+s.getAisleName());
                    System.out.println("Section getCurrentQuantity : "+s.getCurrentQuantity());
                    System.out.println("Section getMaxCapacity : "+s.getMaxCapacity());




                }
                    
            }

            
           
           
           
        }
        
        System.out.println("========After Update===========");
        
        Section w1s1updated = inventoryService.getSectionById(1, ws1);
        w1s1updated.setAisleName("Aisle B");
           
        inventoryService.updateSection(w1s1updated, ws1);

            
        for(Warehouse ws: inventoryService.getAllWarehouses()){
            
            System.out.println(ws.getWarehouseID());
            System.out.println(ws.getLocation());
            System.out.println(ws.getCurrentQuantity());
            System.out.println(ws.getMaxCapacity());
            
            System.out.println("Sections Count: "+ws.getSections()!=null ? ws.getSections().size():0 );
            
            if(!ws.getSections().isEmpty()) {
                for(Section s : ws.getSections() ){
                    System.out.println("Section ID : "+s.getSectionID());
                    System.out.println("Section getShelfNumber : "+s.getShelfNumber());
                    System.out.println("Section getAisleName : "+s.getAisleName());
                    System.out.println("Section getCurrentQuantity : "+s.getCurrentQuantity());
                    System.out.println("Section getMaxCapacity : "+s.getMaxCapacity());




                }
                    
            }

            
           
           
           
        }
        
        
    }
    
    
    
}



