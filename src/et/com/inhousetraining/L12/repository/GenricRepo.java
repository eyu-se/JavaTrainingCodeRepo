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
public class GenricRepo<T> {
    public  List<T> generics ;

    public GenricRepo(List<T> generics) {
        this.generics = generics;
    }
    
    public void add(T t) {
        generics.add(t);
    }


     public List<T> getAll() {
        return generics;
    }
    
}