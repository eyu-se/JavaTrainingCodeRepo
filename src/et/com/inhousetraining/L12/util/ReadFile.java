/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.util;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.*;

/**
 *
 * @author eyu
 */
public class ReadFile {

    private String path;

    public ReadFile(String filePath) {
        this.path = filePath;
    }

   

    public List<String> readFile() throws IOException {
        
        BufferedReader bufferedReader = null;
        
        List<String> textData = new ArrayList<String>();
        
        FileReader fr = new FileReader(path);
        bufferedReader = new BufferedReader(fr);
        String line = bufferedReader.readLine();
        while (line != null) {
            textData.add(line);
           
            line = bufferedReader.readLine();
            
        }

        if (bufferedReader != null) {
            bufferedReader.close();
        }
        
        return textData;

    }

}
