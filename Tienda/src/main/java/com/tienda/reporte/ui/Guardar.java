/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.reporte.ui;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author julio
 */
public class Guardar {
    
    
    public String guardarEn(){
        JFileChooser jChooser = new JFileChooser();
        jChooser.setSize(700, 600);
        jChooser.showSaveDialog(null);
        jChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        File file = jChooser.getCurrentDirectory();
        
        System.out.println(file.getAbsolutePath()+"es directorio: "+file.isDirectory());
        return file.getAbsolutePath();
    }
}
