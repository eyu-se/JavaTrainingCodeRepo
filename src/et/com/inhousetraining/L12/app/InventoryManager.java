/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.app;

import et.com.inhousetraining.L12.models.Warehouse;
import et.com.inhousetraining.L12.services.InventoryService;
import java.util.Scanner;

/**
 *
 * @author eyu
 */
public class InventoryManager {
    InventoryService inventoryService = new InventoryService();;

    public void startManager() {
       
     
        
        Scanner sc = new Scanner(System.in);
        
        
        boolean exit = false;
        
        while(!exit){
            
            displayMenu("primaryMenu",sc);

            int primaryMenuChoice;

            System.out.println("Command: ");

            if(sc.hasNextInt()){

                primaryMenuChoice = sc.nextInt();
                sc.nextLine();

                switch(primaryMenuChoice){

                    case 1:
                        displayMenu("wareHouseMenu",sc);

                        System.out.println("Command: ");

                        int warehouseMenuChoice;
                        
                        if(sc.hasNextInt()){

                            warehouseMenuChoice = sc.nextInt();

                            switch(warehouseMenuChoice){
                                
                                case 1:
                                    showAllWareHouses();
                                    break;

                                case 2:
                                    displayMenu("addUpdateWareHouse", sc);
                                    
                                    System.out.println("Command: ");
                                    int addUpdateWarehouseChoice;
                                    if(sc.hasNextInt()){

                                        addUpdateWarehouseChoice = sc.nextInt();
                                        
                                        
                                        switch(addUpdateWarehouseChoice){
                                            case 1:
                                                addNewWarehouse(sc);
                                                break;
                                            case 2:
                                                
                                                
                                                addWarehousesBulk(sc);
                                                
                                                
                                                break;
                                            case 3:
                                                exit = true;
                                                break;
                                                
                                        }
                                    
                                    }else {
                                        System.out.println("Exiting --- You haven't entered approppriate Command");
                                        

                                    }
                                    break;
                                case 3:
                                    exit = true;
                                    break;

                            }

                        }else {
                            System.out.println("Exiting --- You haven't entered approppriate Command");
                            
                        }
                        break;
                    case 2:
                        
                        displayMenu("sectionMenu",sc);

                        System.out.println("Command: ");

                        int sectionMenuChoice;
                        if(sc.hasNextInt()){

                            sectionMenuChoice = sc.nextInt();

                        }else {
                            System.out.println("Exiting --- You haven't entered approppriate Command");
                            
                        }
                        break;
                    case 3:
                        
                        displayMenu("itemMenu",sc);

                        System.out.println("Command: ");

                        int itemChoiceMenu;
                        if(sc.hasNextInt()){

                            itemChoiceMenu = sc.nextInt();


                        }else {
                            System.out.println("Exiting --- You haven't entered approppriate Command");
                            
                        }
                        break;
                        
                    case 4:
                        exit = true;
                        break;
                        

                }


            }else {
                System.out.println("Exiting --- You haven't entered approppriate Command");
            }

        
        }
        
        
        
    }
    
    public void addWarehousesBulk(Scanner sc){
        sc.nextLine();
        System.out.println("Enter Warehouses data in the following format separated by comma");
        System.out.println("warehouseId:Location:MaxCapacity");
        String warehousesData = sc.nextLine();
        String[] warehousesDataSplitted = warehousesData.split(",");

        for(String w : warehousesDataSplitted){
            String[] warehouseString = w.split(":");
            Warehouse warehouse001 = new Warehouse();
            warehouse001.setWarehouseID(Integer.parseInt(warehouseString[0]));
            warehouse001.setLocation(warehouseString[1]);
            warehouse001.setMaxCapacity(Integer.parseInt(warehouseString[2]));
            inventoryService.addWarehouse(warehouse001);

        }
                                                
    }
    
    
    public void addNewWarehouse(Scanner sc){
        
        sc.nextLine();
        Warehouse warehouse001 = new Warehouse();

        System.out.println("Enter Warehouse ID : ");
        warehouse001.setWarehouseID(sc.nextInt());
        sc.nextLine();
        System.out.println("Enter Warehouse Location : ");
        warehouse001.setLocation(sc.nextLine());

        System.out.println("Enter Warehouse Max Capacity : ");
        warehouse001.setMaxCapacity(sc.nextInt());
        sc.nextLine();
        
        inventoryService.addWarehouse(warehouse001);

    
    }
    
    public void showAllWareHouses(){
        if(!inventoryService.getAllWarehouses().isEmpty()){
            for(Warehouse warehouse: inventoryService.getAllWarehouses()){
                
                warehouse.display();
                
                

            }
        }else{
            System.out.println("You don't have any warehouses");
        }
    }
    
   
    
    
    public static void displayMenu(String menuType, Scanner sc){
    
        if(menuType.equalsIgnoreCase("primaryMenu")){
        
            System.out.println("Inventory System");
            System.out.println("Press Enter to Start");
            sc.nextLine();
            System.out.println("Menu");
            System.out.println("1. Manage Warehouses");
            System.out.println("2. Manage Sections");
            System.out.println("3. Manage Items");
            System.out.println("4. Exit The application");
            
        }else if(menuType.equalsIgnoreCase("wareHouseMenu")){
        
            System.out.println("Warehouse Management Menu");
            System.out.println("1. To view all available warehouses");
            System.out.println("2. To add/update a warehouse at index");
            System.out.println("3. Exit");
            
        }else if(menuType.equalsIgnoreCase("sectionMenu")){
        
            System.out.println("Section Management Menu");
            System.out.println("1. To view all available Sections");
            System.out.println("2. To add/update a Section at index");
            System.out.println("3. Exit");
            
        }else if(menuType.equalsIgnoreCase("itemMenu")){
        
            System.out.println("Item Management Menu");
            System.out.println("1. To view all available Items");
            System.out.println("2. To add/update a Item at index");
            System.out.println("3. Exit");
            
        } else if(menuType.equalsIgnoreCase("addUpdateWareHouse")){
            System.out.println("Add/Update a warehouse at index");
            System.out.println("1. To Add/Update using single values");
            System.out.println("2. To Bulk Add/Update using comma separated values");
            System.out.println("3. Exit");
        }
    
    }
}
