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
public class EncabezoHtml {

    private String encabezado;
    private String nameReport;

    public EncabezoHtml(String encabezado, String nameReport) {
        this.encabezado = encabezado;
        this.nameReport = nameReport;
    }

    public String getEncabezado() {
        return "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<title>"+nameReport+"</title>\n"
                + "</head>\n"
                + " ";
    }
}
