/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fileoperations;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.*;


/**
 *
 * @author eyu
 */
public class ReadFile {
    String path;

    public ReadFile(String path) {
        this.path = path;
    }
    
    public List<String> openFile() throws IOException {
        
        List<String> textData = new ArrayList<String>();

        FileReader fr = new FileReader(path);
        BufferedReader reader = new BufferedReader(fr);
        
        String line = reader.readLine();
        
        while (line != null) {
            
            textData.add(line);
           
            line = reader.readLine();
            
        }

        if (reader != null) {
            reader.close();
        }

        return textData;
    }
    
}
