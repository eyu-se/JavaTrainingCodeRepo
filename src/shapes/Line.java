/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

/**
 *
 * @author eyu
 */
public interface Line {
    double getLargestLineLength(); 
    
    public default void displayType()
    {
        System.out.println(this.getClass().getSimpleName());
    }
}
