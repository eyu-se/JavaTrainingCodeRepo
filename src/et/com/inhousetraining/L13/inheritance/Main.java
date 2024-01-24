/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L13.inheritance;

/**
 *
 * @author eyu
 */
public class Main {

    public static void main(String[] args) {
        
        
        C c = new C();
        
        
        
        
        
        
        
//        Cat wuro = new Cat(5, "Wuro");
//
//        System.out.println("Name: " + wuro.getName());
//        System.out.println("Scrachs : " + wuro.getScrachCount());
//
//        Dog buchi = new Dog("Buchi");
//        System.out.println("Name: " + buchi.getName());
//
//        Animal genericAnimal = new Cat(6, "Scrachy");
//        ((Cat) genericAnimal).setScrachCount(6);
//
//        System.out.println("Name: " + genericAnimal.getName());
//        System.out.println("Scrachs : " + ((Cat) genericAnimal).getScrachCount());

    }

}

class A {

    public A() {
        System.out.println("I'm A");
    }
}

class B extends A {

    public B() {
        super();
        System.out.println("I'm B");
    }
}

class C extends B {

    public C() {
        super();
        System.out.println("I'm C");
    }
}
