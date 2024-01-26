/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.repository;

import et.com.inhousetraining.L12.models.*;
import java.util.*;

/**
 *
 * @author eyu
 */
public class Demo {
    public static void main(String[] args) {
        GenricRepo<Item> itemsRepo = new GenricRepo<Item>(new ArrayList<Item>());
        itemsRepo.add(new Item(2,"Item 2", "Test Description for item 1"));
        
        itemsRepo.add(new Item(3,"Item 3", "Test Description for item 3"));
        
        
        for(Item i : itemsRepo.getAll()){
            i.display();
        }
        
        GenricRepo<Section> sectionsRepo = new GenricRepo<Section>(new ArrayList<Section>());
        sectionsRepo.add(new Section(1,"Aisle A", 1, 4000));
        sectionsRepo.add(new Section(2,"Aisle B", 2, 6000));
        for(Section s : sectionsRepo.getAll()){
            s.display();
        }


        
    }
}
