/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.reporte;

/**
 *
 * @author julio
 */
public class ParseHtml {
    
    private String[] encabezado;
    
    public ParseHtml(String[] encabezado) {
        this.encabezado = encabezado;
    }
    
    
    public String getEncabezadoIndex(int indice){
        return this.encabezado[indice];
    }
    
}
