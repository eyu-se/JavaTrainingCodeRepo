/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 *
 * @author eyu
 */
public class Demo {
    
    public static void main(String[] args) {
        try{
             System.out.println(5/0);
        }
        catch(ArithmeticException e){
            System.out.println("Error You have tried to devide by 0");
        }
        
        try{
            System.out.println(5/0);
            int[] numbers = new int[]{1,3,4};
            numbers[7] = 8;  
            
        }catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("You tried to access an array with an index that is larger than the length");
        }
             
        
        System.out.println("You are here");
       
        
    }
}
