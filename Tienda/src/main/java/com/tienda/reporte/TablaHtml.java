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
public class TablaHtml {

    private String[][] tabla;
    private int columnas;
    private String[] tableHead;

    public TablaHtml(String[][] fila, String[] tableHead) {
        this.tabla = fila;
        this.columnas = tableHead.length;
        this.tableHead = tableHead;
    }

    public TablaHtml(String[][] fila, int columnas, String... tableHead) {
        this.tabla = fila;
        this.columnas = columnas;
        this.tableHead = tableHead;
        
    }

    public void imprimirTabla(JTextArea area) {

        //area.setText(area.getText() + "\n" + "<table  border: 1px solid black;   border-collapse: collapse>");
        area.setText(area.getText() + "\n" + "<table  class=\"table\">");
        
        area.setText(area.getText() + "\n <thead class=\"thead-dark\">");
        area.setText(area.getText() + "\n <tr>");
        for (int i = 0; i < columnas; i++) {
            area.setText(area.getText() + "\n <th> " + tableHead[i] + "</th>");

        }
        area.setText(area.getText() + "\n <tr>");
        area.setText(area.getText() + "\n </thead>");
        
         area.setText(area.getText() + "\n <tbody class=\"\">");
        for (int i = 0; i < tabla.length; i++) {
            area.setText(area.getText() + "\n" + "<tr>");
            for (int j = 0; j < columnas; j++) {
                 System.out.println("000=============>"+  tabla[i][j]);   
                area.setText(area.getText() + "\n" + "<td>" + tabla[i][j] + "</td>");

            }
            area.setText(area.getText() + "\n" + "</tr>");
        }
        area.setText(area.getText() + "\n </tbody>");
        area.setText(area.getText() + "\n" + "</table>");

    }
    

}
