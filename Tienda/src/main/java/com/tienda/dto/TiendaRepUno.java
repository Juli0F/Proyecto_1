/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.dto;

import java.sql.Date;

/**
 *
 * @author julio
 */
public class TiendaRepUno {
    
    private String codigoTienda;
    private String nombre;
    private String codigoPedido;
    private String fecha;
    private String total;

    public TiendaRepUno(String codigoTienda, String nombre, String codigoPedido, String fecha, String total) {
        this.codigoTienda = codigoTienda;
        this.nombre = nombre;
        this.codigoPedido = codigoPedido;
        this.fecha = fecha;
        this.total = total;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    
    public String getCodigoTienda() {
        return codigoTienda;
    }

    public void setCodigoTienda(String codigoTienda) {
        this.codigoTienda = codigoTienda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
}
