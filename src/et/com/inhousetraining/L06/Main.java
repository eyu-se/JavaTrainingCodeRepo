/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L06;

import java.util.Scanner;

/**
 *
 * @author eyu
 */
public class Main {
    public static void main(String[] args) {
                //12:Suzuki2023:AB4567:2023:Addis Ababa,14:Toyota2012:CD345:2012:Hawasa,15:Ferari2023:BD4324:2023:Nazret
        Scanner sc = new Scanner(System.in);

        
        System.out.println("Enter Comma Separated Trucks :");
        System.out.println("single truck attributes - truckid:truckModel;LicensePlate:YearOFManifacture:Location");  
        
        String inputValues  = sc.nextLine();

        String[] trucks = inputValues.split(",");
        String[][] truckDb = new String[trucks.length][5];

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
                System.out.println("Truck License PLate : "+truck[2]);
                System.out.println("Truck YEar Of Manifacturing : "+truck[3]);
                System.out.println("Truck Location : "+truck[4]);
            }


        }
            
            
    }
}
