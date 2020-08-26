/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.reporte;

import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JTextArea;

/**
 *
 * @author julio
 */
public class ParseHtml {
    public void imprimirReporte(String path, JTextArea area, String nombreReporte){
        
        
        try(FileWriter fichero =  new FileWriter(path+"/"+nombreReporte+".html"); PrintWriter pw = new PrintWriter(fichero))
        {
                pw.println(area.getText());
                
        } catch (Exception e) {
            e.printStackTrace();
        } 
        
        
    }
    
}
