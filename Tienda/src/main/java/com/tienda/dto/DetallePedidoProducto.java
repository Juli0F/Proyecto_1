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
public class DetallePedidoProducto {

    private String codigo;
    private String producto;
    private int cantidad;
    private String amoung;

    public DetallePedidoProducto(String codigo, String producto,  String amoung) {
        this.codigo = codigo;
        this.producto = producto;
        this.amoung = amoung;
    }

    public String getAmoung() {
        return amoung;
    }

    public void setAmoung(String amoung) {
        this.amoung = amoung;
    }
    

    public DetallePedidoProducto(String codigo, String producto, int cantidad) {
        this.codigo = codigo;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    

}
