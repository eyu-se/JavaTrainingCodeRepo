/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.repository;

import et.com.inhousetraining.L12.models.Section;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eyu
 */
public class SectionRepository {
    
    private List<Section> sections;

    public SectionRepository(List<Section> sections) {
        this.sections = sections;
    }

    public void addSection(Section section) {
        sections.add(section);
    }

    public Section getSectionById(int sectionId) {
        for (Section section : sections) {
            if (section.getSectionID() == sectionId) {
                return section;
            }
        }
        return null; // Section not found
    }

    public void updateSection(Section updatedSection) {
        for (int i = 0; i < sections.size(); i++) {
            if (sections.get(i).getSectionID() == updatedSection.getSectionID()) {
                sections.set(i, updatedSection);
                break;
            }
        }
    }

    // Additional methods as needed

    public List<Section> getAllSections() {
        return sections;
    }
    
    
}
