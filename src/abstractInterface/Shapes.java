/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractInterface;

/**
 *
 * @author eyu
 */
public class Shapes {
    
    public static void main(String[] args) {
        Shape sh1 = new Circle(4.5);
        Rectangle r1 = new Rectangle(4,5);
        calculateArea(sh1);
        calculateArea(r1);
        printLargestSide(r1);
    }
    
    static void calculateArea(Shape sh){
        System.out.println("Area : "+sh.calculateArea());
    }
    
    static void printLargestSide(Line ln){
        System.out.println("Largest Side Length : "+ln.largestSideLength());
    }
    
}


abstract class Shape {
    public int sides;
    
    public int getSides(){
        return sides;
    }
    
    abstract public double calculateArea();
}

class Rectangle extends Shape implements Polygone, Line {

    double width;
    double height;
    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
        sides = 2;
    
    }
    
    public double calculateArea() {
        
        return width * height;
        
    }

    @Override
    public double largestSideLength() {
        return width >= height ? width:height;
    }

    @Override
    public double calculatePerimeter() {
        return 2*width*height;
    }


}


class Circle extends Shape {

    double radius;
    public Circle(double radius){
        this.radius = radius;
        sides = 0;
    }
    
    public double calculateArea() {
        
        return Math.PI*Math.pow(radius, 2);
        
    }


}



interface Polygone {
    String name = "Polygone";
    
    static void printName(){
        System.out.println(name);
    }
    
    double calculatePerimeter();
}


interface Line {
    
    
    static void printIfLine(){
        System.out.println("I have Lines");
    }
    
    double largestSideLength();
}