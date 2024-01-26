/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

/**
 *
 * @author eyu
 */
public class Circle extends Shape{
    double radius;

    public Circle(double radius) {
        this.radius = radius;
        setSides(0);
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2); // PI*r2
    }

   
    
    
}
