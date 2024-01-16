/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.repository;

import et.com.inhousetraining.L12.models.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eyu
 */
public class WarehouseRepository {
    
    private static List<Warehouse> warehouses = new ArrayList<>();;

    
    public void addWarehouse(Warehouse warehouse) {
        warehouses.add(warehouse);
    }

    public Warehouse getWarehouseById(int warehouseId) {
        for (Warehouse warehouse : warehouses) {
            if (warehouse.getWarehouseID() == warehouseId) {
                return warehouse;
            }
        }
        return null; // Warehouse not found
    }
    

    public void updateWarehouse(Warehouse updatedWarehouse) {
        for (int i = 0; i < warehouses.size(); i++) {
            if (warehouses.get(i).getWarehouseID() == updatedWarehouse.getWarehouseID()) {
                warehouses.set(i, updatedWarehouse);
                break;
            }
        }
    }

    // Additional methods as needed

    public List<Warehouse> getAllWarehouses() {
        return warehouses;
    }
}
