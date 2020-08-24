/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.reporte;

import java.util.List;

/**
 *
 * @author julio
 */
public class FilaHtml {
    private String[] fila;
    
    public FilaHtml(List<String> fila){
        this.fila = new String[fila.size()];
        for (int i = 0; i < fila.size(); i++) {
            this.fila[i] = fila.get(i);
            
        }
    }
    public FilaHtml(String[] fila) {
        this.fila = fila;
    }
    
    public String numberColumn(int index){
        return this.fila[index];
    }
    public static void main(String... args) {
        
    }
}
