/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.services;

import et.com.inhousetraining.L12.models.*;
import et.com.inhousetraining.L12.repository.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eyu
 */
public class InventoryService {
    
    private WarehouseRepository warehouseRepository;
    private ItemRepository itemRepository;

   

    public InventoryService() {
        this.warehouseRepository = new WarehouseRepository(); 
        this.itemRepository = new ItemRepository();
    }

    // Warehouse Operations

    public void addWarehouse(Warehouse warehouse) {
        warehouseRepository.addWarehouse(warehouse);
    }

    public Warehouse getWarehouseById(int warehouseId) {
        return warehouseRepository.getWarehouseById(warehouseId);
    }

    public void updateWarehouse(Warehouse updatedWarehouse) {
        warehouseRepository.updateWarehouse(updatedWarehouse);
    }

    public List<Warehouse> getAllWarehouses() {
        return warehouseRepository.getAllWarehouses();
    }

    // Section Operations

    public void addSection(Section section, Warehouse warehouse ) {
        SectionRepository sr = new SectionRepository(warehouse.getSections());
        sr.addSection(section);
        warehouse.setSections(sr.getAllSections());
        this.updateWarehouse(warehouse);
    }

    public Section getSectionById(int sectionId, Warehouse warehouse ) {
        SectionRepository sr = new SectionRepository(warehouse.getSections());
        return sr.getSectionById(sectionId);
    }

    public void updateSection(Section updatedSection, Warehouse warehouse  ) {
        SectionRepository sr = new SectionRepository(warehouse.getSections());
        sr.updateSection(updatedSection);
        warehouse.setSections(sr.getAllSections());
        this.updateWarehouse(warehouse);
    }

    public List<Section> getAllSections() {
        List<Section> allSections = new ArrayList<Section>();
        for(Warehouse w: this.getAllWarehouses()){
            allSections.addAll(w.getSections());
        }
        return allSections;
    }

    // StorageBin Operations

    public void addStorageBin(StorageBin storageBin, Section section, Warehouse warehouse) {
        StorageBinRepository storageR = new StorageBinRepository(section.getStorageBins());
        SectionRepository sectionR = new SectionRepository(warehouse.getSections());
        storageR.addStorageBin(storageBin);
        section.setStorageBins(storageR.getAllStorageBins());
        sectionR.updateSection(section);
        warehouse.setSections(sectionR.getAllSections());
        this.updateWarehouse(warehouse);
    }

    public StorageBin getStorageBinById(int binId, Warehouse warehouse) {
        
        SectionRepository sectionR = new SectionRepository(warehouse.getSections());
        for(Section section: warehouse.getSections()){
            StorageBinRepository storageR = new StorageBinRepository(section.getStorageBins());
            StorageBin sb = storageR.getStorageBinById(binId);
            if(sb != null){
                return sb;
            }
        }
        return null;
    }

    public void updateStorageBin(StorageBin updatedStorageBin, Section section, Warehouse warehouse) {
        StorageBinRepository storageR = new StorageBinRepository(section.getStorageBins());
        SectionRepository sectionR = new SectionRepository(warehouse.getSections());
        storageR.updateStorageBin(updatedStorageBin);
        section.setStorageBins(storageR.getAllStorageBins());
        sectionR.updateSection(section);
        warehouse.setSections(sectionR.getAllSections());
        this.updateWarehouse(warehouse);
        
    }

    public List<StorageBin> getAllStorageBins() {
        List<StorageBin> allStorageBins = new ArrayList<StorageBin>();
        for(Warehouse w: this.getAllWarehouses()){
            for(Section s: w.getSections()){
                allStorageBins.addAll(s.getStorageBins());
            }
        }
        return allStorageBins;
        
    }

    // Item Operations

    public void addItem(Item item, int quantity, Section section, Warehouse warehouse) {
        if(this.itemRepository.getItemById(item.getItemID()) == null){
            this.itemRepository.addItem(item);
        }
        StorageBinRepository storageR = new StorageBinRepository(section.getStorageBins());
        SectionRepository sectionR = new SectionRepository(warehouse.getSections());
        for(StorageBin sb: storageR.getAllStorageBins()){
            if(sb.getItemId() == item.getItemID() && sb.getQuantity()+quantity <= sb.getMaxCapacity()){
                sb.setQuantity(sb.getQuantity()+quantity);
                storageR.updateStorageBin(sb);
                section.setStorageBins(storageR.getAllStorageBins());
                sectionR.updateSection(section);
                warehouse.setSections(sectionR.getAllSections());
                this.updateWarehouse(warehouse);
            }
        }
        
    }

    public Item getItemById(int itemId) {
        return itemRepository.getItemById(itemId);
    }

    public void updateItem(Item updatedItem) {
        itemRepository.updateItem(updatedItem);
    }

    public List<Item> getAllItems() {
        return itemRepository.getAllItems();
    }
}
