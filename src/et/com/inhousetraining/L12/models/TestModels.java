/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.models;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eyu
 */
public class TestModels {
    public static void main(String[] args) {
        
        
        InventoryComponent it = new InventoryComponent();
        it.display();
        
        Item item1 = new Item();
        System.out.println(item1.getType());
//        Warehouse warehouse1 = new Warehouse();
//        warehouse1.setCurrentQuantity(0);
//        warehouse1.setLocation("DZ");
//        warehouse1.setWarehouseID(3);
//        warehouse1.setMaxCapacity(5000);
//        
//        
//        Warehouse warehouse2 = new Warehouse(3,"DZ",5000);
//        
//        System.out.println(warehouse1.equals(warehouse2));
//        
//        warehouse2.setLocation("Addis Ababa");
//        
//        System.out.println(warehouse1.equals(warehouse2));
//
//        Warehouse warehouse3 = warehouse2;
//        warehouse3.setLocation("Hawasa");
//        System.out.println(warehouse3.equals(warehouse2));
//
////        printWarehouse(warehouse2);
//        
//        Warehouse warehouse4 = new Warehouse(warehouse3);
//        //printWarehouse(warehouse4);
//        //warehouse3.setLocation("Adama");
//        //printWarehouse(warehouse4);
//        try {
//            Warehouse warehouse5 = warehouse3.cloneWarehouse();
//            warehouse3.setLocation("Adama");
//            printWarehouse(warehouse5);
//            
//        } catch (CloneNotSupportedException ex) {
//            System.out.println(ex.getMessage());
//        }
//        
//

        
        
        
    }
    
    
    public static void printWarehouse(Warehouse ws){
        System.out.println("Warehouse ID : "+ws.getWarehouseID());
        System.out.println("Warehouse Location : "+ws.getLocation());
        System.out.println("Warehouse Current Quantity : "+ws.getCurrentQuantity());
        System.out.println("Warehouse Max Capacity : "+ws.getMaxCapacity());



    }
}
