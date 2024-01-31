/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package et.com.inhousetraining.L12.util;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 *
 * @author eyu
 */
public class WriteFile {

    private String path;
    private boolean append_to_file = false;

    public WriteFile(String file_path) {
        path = file_path;
    }

    public WriteFile(String file_path, boolean append_value) {
        path = file_path;
        append_to_file = append_value;
    }
    
    public void writeToFile( String textLine ) throws IOException {
        FileWriter write = new FileWriter( path , append_to_file);
        PrintWriter print_line = new PrintWriter( write );
        
        print_line.println(textLine);
        
        print_line.close();

    }

}
