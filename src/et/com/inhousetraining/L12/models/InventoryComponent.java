/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.models;

/**
 *
 * @author eyu
 */
abstract public class InventoryComponent {
    protected String type = "InventoryComponent";
    
    public String getType(){
        return this.type;
    }
    
    abstract public void display();
    
    abstract public String convertToCSVFormat();
    
}
