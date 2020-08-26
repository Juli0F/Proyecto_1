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
public class EncabezoHtml {

    private String encabezado;
    private String nameReport;

    public EncabezoHtml(String nameReport) {

        this.nameReport = nameReport;
    }

    public void imprimirEncabezado(JTextArea area) {
        String stilo =   "<style>\n"
                + "table {\n"
                + "  font-family: arial, sans-serif;\n"
                + "  border-collapse: collapse;\n"
                + "  width: 100%;\n"
                + "}\n"
                + "\n"
                + "td, th {\n"
                + "  border: 1px solid #dddddd;\n"
                + "  text-align: left;\n"
                + "  padding: 8px;\n"
                + "}\n"
                + "\n"
                + "tr:nth-child(even) {\n"
                + "  background-color: #dddddd;\n"
                + "}\n"
                + "</style>";
        
        
        area.setText("<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
               
                + "<meta charset=\"utf-8\">\n"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n"
                + "\n"
                + "    <!-- Bootstrap CSS -->\n"
                + "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\">"
                + "<title>" + nameReport + "</title>\n"
                + "</head>\n"
                + " ");

    }
}
