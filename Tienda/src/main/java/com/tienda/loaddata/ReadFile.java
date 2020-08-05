/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.loaddata;

import java.io.BufferedReader;
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

    public ReadFile(LoadFile loadFile) {
        this.loadFile = loadFile;
    }
    
    public void read() throws FileNotFoundException, IOException{
        
      //  fileReader = new FileReader(loadFile.getFile());
        //BufferedReader bufferReader = new BufferedReader(fileReader);
        Scanner scanner = new Scanner(loadFile.getFile());
        String linea = "";
        while (scanner.hasNext()) {
          //  linea = bufferReader.readLine();
          linea = scanner.nextLine();
            System.out.println(linea);
            
            //Object nextElement = bufferReader.nextElement();
            
        }
        
    }
    
    public static void main(String[] args) {
        ReadFile readFile = new ReadFile(new LoadFile("/home/julio/Descargas/simple data.txt"));
        try {
            
            readFile.read();
            
        } catch (IOException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
