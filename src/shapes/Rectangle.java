/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

/**
 *
 * @author eyu
 */
public class Rectangle extends Shape implements Polygone, Line {
    
    double length;
    double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
        setSides(4);
    }

    @Override
    public double calculateArea() {
        return length*width;
    }

    @Override
    public double calculatePerimater() {
        return 2*(length+width);
    }

    @Override
    public double getLargestLineLength() {
        return length >= width ? length : width;
    }

   
    @Override
    public void displayType()
    {
        System.out.println("Overiden Response : "+this.getClass().getSimpleName());
    }

    @Override
    public String toString() {
        return "Rectangle{" + "length=" + length + ", width=" + width + '}';
    }
    
    
}
