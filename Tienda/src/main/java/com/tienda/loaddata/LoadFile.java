/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.loaddata;

import java.io.File;

/**
 *clase encargada de cargar el archivo 
 * que alimentara la base de datos
 * @author julio
 */
public class LoadFile {
    private File file;
    private String path;

    public LoadFile(String path) {
        this.path = path;
    }
    

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    
    public void loadFile(String absolutePath){
        this.file = new File (absolutePath);
        
        
    }
    
}
