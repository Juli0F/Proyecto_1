/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.loaddata;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author julio
 */
public class ReadFile {
    private LoadFile loadFile;
    private  FileReader fileReader;
    

    public ReadFile() {
       
    }

    public ReadFile(LoadFile loadFile) {
        this.loadFile = loadFile;
    }
    
    
    public void read(String pathFile) throws FileNotFoundException, IOException{
        

        
        try {
            File file = new File(pathFile);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public static void main(String[] args) {
       
        String direccion = "/home/julio/Descargas/simple data.txt";
        try {
            ReadFile readfile = new ReadFile();
            readfile.read(direccion);
        } catch (IOException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
