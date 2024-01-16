/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.models;

import java.util.List;

/**
 *
 * @author eyu
 */
public class Section {
    
    private int sectionID;
    private String aisleName;
    private int shelfNumber;
    private int maxCapacity;
    private int currentQuantity = 0;
    private List<StorageBin> storageBins;

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
     * @return the aisleName
     */
    public String getAisleName() {
        return aisleName;
    }

    /**
     * @param aisleName the aisleName to set
     */
    public void setAisleName(String aisleName) {
        this.aisleName = aisleName;
    }

    /**
     * @return the shelfNumber
     */
    public int getShelfNumber() {
        return shelfNumber;
    }

    /**
     * @param shelfNumber the shelfNumber to set
     */
    public void setShelfNumber(int shelfNumber) {
        this.shelfNumber = shelfNumber;
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
     * @return the storageBins
     */
    public List<StorageBin> getStorageBins() {
        return storageBins;
    }

    /**
     * @param storageBins the storageBins to set
     */
    public void setStorageBins(List<StorageBin> storageBins) {
        this.storageBins = storageBins;
    }

    
}
