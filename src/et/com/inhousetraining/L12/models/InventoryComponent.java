/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.models;

/**
 *
 * @author eyu
 */
public class InventoryComponent {
    protected String type = "InventoryComponent";
    
    public String getType(){
        return this.type;
    }
    
    public void display(){
        
        System.out.println("ObjectID : " +this.toString());
        
    }
    
}
