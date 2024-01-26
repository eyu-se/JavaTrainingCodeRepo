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
public class TestRepositories {
    public static void main(String[] args) {
        GenericRepository<Item> itemsRepo = new GenericRepository<Item>(new ArrayList<Item>());
        itemsRepo.add(new Item(1,"Item1", "Test Description"));
        
        for(Item i: itemsRepo.getAll() ){
            i.display();
        }
    }
}
