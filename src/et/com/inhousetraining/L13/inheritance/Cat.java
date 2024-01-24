/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L13.inheritance;

/**
 *
 * @author eyu
 */
public class Cat extends Animal {
    public int scrachCount;

    public Cat(int scrachCount, String name) {
        super(name);

        this.scrachCount = scrachCount;
    }

    public int getScrachCount() {
        return scrachCount;
    }

    public void setScrachCount(int scrachCount) {
        this.scrachCount = scrachCount;
    }
    
}
