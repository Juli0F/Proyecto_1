/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.dto;

/**
 *
 * @author julio
 */
public class SinVender {
    
    private String codigoTienda;
    private String nombreTienda;
    private String codigoProducto;
    private String nombreProducto;

    public SinVender(String codigoTienda, String nombreTienda, String codigoProducto, String nombreProducto) {
        this.codigoTienda = codigoTienda;
        this.nombreTienda = nombreTienda;
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
    }

    
    public String getCodigoTienda() {
        return codigoTienda;
    }

    public void setCodigoTienda(String codigoTienda) {
        this.codigoTienda = codigoTienda;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    
    
}
