/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.repository;

import et.com.inhousetraining.L12.models.StorageBin;
import java.util.List;

/**
 *
 * @author eyu
 */
public class StorageBinRepository {
    private List<StorageBin> storageBins;

    public StorageBinRepository(List<StorageBin> storageBins) {
        this.storageBins = storageBins;
    }

    public void addStorageBin(StorageBin storageBin) {
        storageBins.add(storageBin);
    }

    public StorageBin getStorageBinById(int binId) {
        for (StorageBin storageBin : storageBins) {
            if (storageBin.getBinID() == binId) {
                return storageBin;
            }
        }
        return null; // Storage bin not found
    }

    public void updateStorageBin(StorageBin updatedStorageBin) {
        for (int i = 0; i < storageBins.size(); i++) {
            if (storageBins.get(i).getBinID() == updatedStorageBin.getBinID()) {
                storageBins.set(i, updatedStorageBin);
                break;
            }
        }
    }

    // Additional methods as needed

    public List<StorageBin> getAllStorageBins() {
        return storageBins;
    }
}
