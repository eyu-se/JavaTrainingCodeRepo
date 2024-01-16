/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L11.models;

import java.util.List;

/**
 *
 * @author eyu
 */
public class Section {
    
    public int sectionID;
    public String aisleName;
    public int shelfNumber;
    public int maxCapacity;
    public int currentQuantity;
    public List<StorageBin> storageBins;

    
}
