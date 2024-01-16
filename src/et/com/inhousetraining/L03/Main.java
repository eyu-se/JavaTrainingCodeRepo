/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L03;
import java.util.Dictionary;
import java.util.Scanner;
/**
 *
 * @author eyu
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Truck information
//        System.out.println("Truck information");
//        System.out.println("Enter Truck info");
//        
//        System.out.println("Truck ID:");
//        int truckId = Integer.parseInt(sc.nextLine());
//        
//        
//        System.out.println("License Plate:");
//        String licensePlate = sc.nextLine();
//        
//        System.out.println("Model:");
//        String model = sc.nextLine();
//        sc.nextLine();
//        
//        System.out.println("Manifacturing Year:");
//        int manifacturingYear = Integer.parseInt(sc.nextLine());
//        
//        System.out.println("Capacity:");
//        double capacity = Double.parseDouble(sc.nextLine());
//        
//        System.out.println("Location Latitude:");
//        double lat = Double.parseDouble(sc.nextLine());
//        
//        System.out.println("Location Longtude:");
//        double lng = Double.parseDouble(sc.nextLine());
//        
//        System.out.println("Current Status:");
//        String status = sc.nextLine();
//        
//        
//        System.out.println("You have entered the following Truck information");
//        System.out.println("Truck ID: "+truckId);
//        System.out.println("License Plate: "+licensePlate);
//        System.out.println("Model: "+model);
//        System.out.println("Manifacturing Year: "+manifacturingYear);
//        System.out.println("Capacity: "+capacity);
//        System.out.println("Location Latitude: "+lat);
//        System.out.println("Location Longtude: "+lng);
//        System.out.println("Current Status: "+status);
            
            //12:Suzuki2023,14:Toyota2012
            
            System.out.println("Enter Comma Separated Trucks :");
            
            String inputValues  = sc.nextLine();
            
            String[] trucks = inputValues.split(",");
            String[][] truckDb = new String[trucks.length][2];
            
            for(int i=0; i<trucks.length;i++){
                
                String[] truckInfo = trucks[i].split(":");
                truckDb[i] = truckInfo;
                System.out.println("Truck Id : "+truckInfo[0]);
                System.out.println("Truck Model : "+truckInfo[1]);

            }
            
            System.out.println("Search Truck by Model :");
            
            String searchQuery  = sc.nextLine();
            
            for(String[] truck: truckDb){
                
               
                if(truck[1].contains(searchQuery)){
                    System.out.println("Truck Id : "+truck[0]);
                    System.out.println("Truck Model : "+truck[1]);
                }
                

            }
            
        
   

        
    }
    
}
