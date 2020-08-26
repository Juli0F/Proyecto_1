/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.reporte;

import javax.swing.JTextArea;

/**
 *
 * @author julio
 */
public class ParrafoHtml {
    
    private String[] parrafo;

    public ParrafoHtml(String[] parrafo) {
        this.parrafo = parrafo;
    }
    
    public void printParrafo(JTextArea area){
        
        for (int i = 0; i < parrafo.length; i++) {
            area.setText(area.getText() +"\n<p>"+parrafo[i]+"</p>");    
        }
    }
}
