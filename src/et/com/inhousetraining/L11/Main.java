/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L11;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eyu
 */
public class Main {

    public static void main(String[] args) {

//        List<String> names = new ArrayList<String>();
//        names.add("Eyuel");
//        names.add("Wonde");
//        names.add(1,"Jhon");
//        
//        List<String> newNames =  new ArrayList<String>();
//        newNames.add("AA");
//        newNames.add("BB");
//        newNames.add("BB");
//        
//        names.addAll(newNames);
//        names.set(4,"CC");
//        names.add("CC");
//
//        //names.remove("CC");
//        names.remove(6);
//        
//        System.out.println(names.get(1));
//        
//        for(String name: names){
//            System.out.println(name);
//        }
        System.out.println(add(3, 2, 6));

    }

    public static int add(int num1, int num2, final int num3) {
        if (num1 > num2) {
            return num1 * num2 + num3;
        }
        return num1 + num2 + num3;

    }
    public static int add(int num1, int num2) {
        if (num1 > num2) {
            return num1 * num2;
        }
        return num1 + num2 ;

    }
    
    public static String add(String num1, String num2) {
        
        return num1 + num2 ;

    }

}
