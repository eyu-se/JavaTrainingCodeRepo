/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.repository;

import et.com.inhousetraining.L12.models.InventoryComponent;
import et.com.inhousetraining.L12.models.Item;
import et.com.inhousetraining.L12.models.Warehouse;
import java.util.*;

/**
 *
 * @author eyu
 */
public class GenericRepository<T> {
    private List<T> genericComponenets = new ArrayList<>();

    public GenericRepository(List<T> genericComponenets) {
        this.genericComponenets = genericComponenets;
       
    }
    
    
     public void add(T t) {
        genericComponenets.add(t);
    }

    public T getById(int id) {
        for (T t : genericComponenets) {
            if (getID((InventoryComponent)t) == id) {
                return t;
            }
        }
        return null; // Item not found
    }


   public List<T> getAll() {
       return genericComponenets;
  }
  
    
    int getID(InventoryComponent ic) {

        if (ic instanceof Item) {
            return ((Item) ic).getItemID();
        }
        
        if (ic instanceof Warehouse) {
            return ((Warehouse) ic).getWarehouseID();
        }
        return 0;
    }
    
    
    
}
