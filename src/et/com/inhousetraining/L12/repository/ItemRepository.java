/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.repository;

import et.com.inhousetraining.L12.models.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eyu
 */
public class ItemRepository {
    private static List<Item> items = new ArrayList<Item>();

    
    public void addItem(Item item) {
        items.add(item);
    }

    public Item getItemById(int itemId) {
        for (Item item : items) {
            if (item.getItemID() == itemId) {
                return item;
            }
        }
        return null; // Item not found
    }

    public void updateItem(Item updatedItem) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getItemID() == updatedItem.getItemID()) {
                items.set(i, updatedItem);
                break;
            }
        }
    }

    // Additional methods as needed

    public List<Item> getAllItems() {
        return items;
    }
}
