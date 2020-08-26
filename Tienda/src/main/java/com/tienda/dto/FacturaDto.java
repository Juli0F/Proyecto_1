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
public class FacturaDto {

    private String idFactura;
    private String tienda;
    private String codigoTienda;
    private String fecha;
    private String total;
    private String descripcion;

    public FacturaDto(String idFactura, String tienda, String codigoTienda, String fecha, String total, String descripcion) {
        this.idFactura = idFactura;
        this.tienda = tienda;
        this.codigoTienda = codigoTienda;
        this.fecha = fecha;
        this.total = total;
        this.descripcion = descripcion;
    }
    
    
    

    public FacturaDto(String idFactura, String tienda, String codigoTienda, String fecha, String total) {
        this.idFactura = idFactura;
        this.tienda = tienda;
        this.codigoTienda = codigoTienda;
        this.fecha = fecha;
        this.total = total;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

        
    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

    public String getCodigoTienda() {
        return codigoTienda;
    }

    public void setCodigoTienda(String codigoTienda) {
        this.codigoTienda = codigoTienda;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

}
