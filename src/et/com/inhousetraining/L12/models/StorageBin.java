/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.models;


/**
 *
 * @author eyu
 */
public class StorageBin extends InventoryComponent{
    
    private int binID;
    private int sectionID;
    private int itemId;
    private int quantity = 0;
    private int maxCapacity;

    public StorageBin(int binID, int sectionID, int itemId, int maxCapacity) {
        this.binID = binID;
        this.sectionID = sectionID;
        this.itemId = itemId;
        this.maxCapacity = maxCapacity;
    }
    
    public StorageBin(){
    }

    /**
     * @return the binID
     */
    public int getBinID() {
        return binID;
    }

    /**
     * @param binID the binID to set
     */
    public void setBinID(int binID) {
        this.binID = binID;
    }

    /**
     * @return the sectionID
     */
    public int getSectionID() {
        return sectionID;
    }

    /**
     * @param sectionID the sectionID to set
     */
    public void setSectionID(int sectionID) {
        this.sectionID = sectionID;
    }

    /**
     * @return the itemId
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
    
    
    @Override
    public void display() {
        
        System.out.println("StorageBin ID :"+this.getBinID());
        System.out.println("StorageBin SectionId :"+this.getSectionID());
        System.out.println("StorageBin ItemId :"+this.getItemId());
        System.out.println("StorageBin CurrentQuantity :"+this.getQuantity());
        System.out.println("StorageBin MaxCapacity :"+this.getMaxCapacity());


    }
    
}
