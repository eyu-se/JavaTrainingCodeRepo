/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

/**
 *
 * @author eyu
 */
abstract public class Shape {
    
    private int  sides;
    
    public int getSides(){
        return sides;
    }
    
    public void setSides(int sides){
        this.sides = sides;
    }
    
    abstract public double calculateArea();
    
}
