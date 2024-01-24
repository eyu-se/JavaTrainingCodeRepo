/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author eyu
 */
public class Warehouse extends InventoryComponent implements Cloneable {

    private int warehouseID;
    private String location;
    private int currentQuantity;
    private int maxCapacity;
    private List<Section> sections = new ArrayList<>();

    public Warehouse(int warehouseID, String location, int currentQuantity, int maxCapacity) {
        this.warehouseID = warehouseID;
        this.location = location;
        this.currentQuantity = currentQuantity;
        this.maxCapacity = maxCapacity;
    }

    public Warehouse() {
    }

    public Warehouse(int warehouseID, String location, int maxCapacity) {
        this(warehouseID, location, 0, maxCapacity);
    }
    
    public Warehouse(Warehouse w){
        this.warehouseID = w.getWarehouseID();
        this.location = new String(w.getLocation());
        this.currentQuantity = w.getCurrentQuantity();
        this.maxCapacity = w.getMaxCapacity();
        
    }
    
    public Warehouse cloneWarehouse() throws CloneNotSupportedException {
        return (Warehouse) this.clone();
    }

    /**
     * @return the warehouseID
     */
    public int getWarehouseID() {
        return warehouseID;
    }

    /**
     * @param warehouseID the warehouseID to set
     */
    public void setWarehouseID(int warehouseID) {
        this.warehouseID = warehouseID;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the currentQuantity
     */
    public int getCurrentQuantity() {
        return currentQuantity;
    }

    /**
     * @param currentQuantity the currentQuantity to set
     */
    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    /**
     * @return the maxCapacity
     */
    public int getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * @param maxCapacity the maxCapacity to set
     */
    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    /**
     * @return the sections
     */
    public List<Section> getSections() {
        return sections;
    }

    /**
     * @param sections the sections to set
     */
    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Warehouse ID : " + this.getWarehouseID());
        System.out.println("Warehouse Location : " + this.getLocation());
        System.out.println("Warehouse current Quantity : " + this.getCurrentQuantity());
        System.out.println("Warehouse Maximum Capacity : " + this.getMaxCapacity());
        System.out.println("Warehouse has " + (this.getSections() != null ? this.getSections().size() : 0) + " Sections");

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Warehouse other = (Warehouse) obj;
        if (this.warehouseID != other.warehouseID) {
            return false;
        }
        if (this.currentQuantity != other.currentQuantity) {
            return false;
        }
        if (this.maxCapacity != other.maxCapacity) {
            return false;
        }
        if (!this.location.equals(other.location)) {
            return false;
        }
        return true;
    }

}
