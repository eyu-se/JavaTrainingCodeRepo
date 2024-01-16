/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L07;
import java.util.Scanner;

/**
 *
 * @author eyu
 */
public class Main {
    
    public static void main(String[] args) {
        
        
        /*
        Warehouse:
        - WarehouseID: int
        - Location: string
        - Capacity: int
        - SectionsCount: int

        Section:
        - SectionID: int
        - MaxCapacity: int
        - CurrentOccupancy: int
        - WarehouseID: int

        Item:
        - ItemID: int
        - Name: string
        - Description: string
        - Quantity: int
        - SectionID: int
        - Price: double

        */
        
        Scanner sc = new Scanner(System.in);
        
        String[][] warehouses = new String [2][4];
        //123:AA:5000:4,124:DZ:10000:4
        String[][] sections = new String [4][4];
        String[][] items = new String [10][6];
        
        
        boolean exit = false;
        
        while(!exit){
            
            System.out.println("Inventory System");
            System.out.println("Press Enter to Start");
            sc.nextLine();
            System.out.println("Menu");
            System.out.println("1. Manage Warehouses");
            System.out.println("2. Manage Sections");
            System.out.println("3. Manage Items");
            System.out.println("4. Exit The application");
            
            
            
            int primaryMenuChoice;

            System.out.println("Command: ");

            if(sc.hasNextInt()){

                primaryMenuChoice = sc.nextInt();
                sc.nextLine();

                switch(primaryMenuChoice){

                    case 1:
                        System.out.println("Warehouse Management Menu");
                        System.out.println("1. To view all available warehouses");
                        System.out.println("2. To add/update a warehouse at index");
                        System.out.println("3. Exit");

                        System.out.println("Command: ");

                        int warehouseMenuChoice;
                        
                        if(sc.hasNextInt()){

                            warehouseMenuChoice = sc.nextInt();

                            switch(warehouseMenuChoice){
                                case 1:

                                    if(warehouses.length > 0){
                                        for(String[] warehouse: warehouses){

                                            System.out.println("Warehouse ID : "+warehouse[0]);
                                            System.out.println("Warehouse Location : "+warehouse[1]);
                                            System.out.println("Warehouse Capacity : "+warehouse[2]);
                                            System.out.println("Warehouse Sections : "+warehouse[3]);

                                        }
                                    }else{
                                        System.out.println("You have 0 warehouses");
                                    }
                                    break;

                                case 2:
                                    System.out.println("Add/Update a warehouse at index");
                                    System.out.println("1. To Add/Update using single values");
                                    System.out.println("2. To Bulk Add/Update using comma separated values");
                                    System.out.println("3. Exit");
                                    System.out.println("Command: ");
                                    int addUpdateWarehouseChoice;
                                    if(sc.hasNextInt()){

                                        addUpdateWarehouseChoice = sc.nextInt();
                                        
                                        switch(addUpdateWarehouseChoice){
                                            case 1:
                                                System.out.println("Enter index chose from 0 or 1");
                                                int in = sc.nextInt();
                                                sc.nextLine();
                                                String[] warehouse001 = new String[4];
                                                
                                                System.out.println("Enter Warehouse ID : ");
                                                warehouse001[0] = sc.nextLine();
                                                System.out.println("Enter Warehouse Location : ");
                                                warehouse001[1] = sc.nextLine();

                                                System.out.println("Enter Warehouse Capacity : ");
                                                warehouse001[2] = sc.nextLine();

                                                System.out.println("Enter Warehouse Sections : ");
                                                warehouse001[3] = sc.nextLine();

                                                warehouses[in] = warehouse001;
                                               
                                               
                                                break;
                                            case 2:
                                                System.out.println("Enter index");
                                                int i = sc.nextInt();
                                                sc.nextLine();
                                                System.out.println("Enter Warehouses data in the following format separated by comma");
                                                System.out.println("warehouseId:Location:Capacity:NoOfSection");
                                                String warehousesData = sc.nextLine();
                                                String[] warehousesDataSplitted = warehousesData.split(",");
                                              
                                                for(String w : warehousesDataSplitted){
                                                    String[] warehouse = w.split(":");
                                                    warehouses[i++] = warehouse;
                                                }
                                                
                                                for(String[] warehouse: warehouses){

                                                    System.out.println("Warehouse ID : "+warehouse[0]);
                                                    System.out.println("Warehouse Location : "+warehouse[1]);
                                                    System.out.println("Warehouse Capacity : "+warehouse[2]);
                                                    System.out.println("Warehouse Sections : "+warehouse[3]);

                                                }
                                                break;
                                            case 3:
                                                exit = true;
                                                break;
                                                
                                        }
                                        break;
                                    
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
                        System.out.println("Section Management Menu");
                        System.out.println("1. To view all available Sections");
                        System.out.println("2. To add/update a Section at index");
                        System.out.println("3. Exit");

                        System.out.println("Command: ");

                        int sectionMenuChoice;
                        if(sc.hasNextInt()){

                            sectionMenuChoice = sc.nextInt();

                        }else {
                            System.out.println("Exiting --- You haven't entered approppriate Command");
                            
                        }
                        break;
                    case 3:
                        System.out.println("Item Management Menu");
                        System.out.println("1. To view all available Items");
                        System.out.println("2. To add/update a Item at index");
                        System.out.println("3. Exit");

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
                break;


            }else {
                System.out.println("Exiting --- You haven't entered approppriate Command");
            }

        
        }
        
         
        
    }
}
