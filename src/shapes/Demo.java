/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

/**
 *
 * @author eyu
 */
public class Demo {
    
    public static void main(String[] args) {
        Rectangle rec1 = new Rectangle(4,5);
        
        
        System.out.println("Sides : "+rec1.getSides());
        System.out.println("Area : "+rec1.calculateArea());
        System.out.println("Area : "+rec1.calculatePerimater());
        System.out.println("Area : "+rec1.getLargestLineLength());
        rec1.displayType();
        
        System.out.println(rec1);
        
        Circle cr1 = new Circle(5);
        
        
        System.out.println("Sides : "+cr1.getSides());
        System.out.println("Area : "+cr1.calculateArea());
        
        

        
    }
}
