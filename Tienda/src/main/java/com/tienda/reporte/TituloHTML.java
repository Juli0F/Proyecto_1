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
public class TituloHTML {

    private int size;

    public TituloHTML(int size) {
        this.size = size;

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void imprimirTitulo(JTextArea area, String titulo) {

        area.setText(area.getText() + "\n<h"+size+"align=\"center\">"+ titulo+"</h"+size+"></br>");
    }
}
