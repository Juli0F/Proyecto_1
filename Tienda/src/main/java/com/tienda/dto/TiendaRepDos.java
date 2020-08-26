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
public class TiendaRepDos extends TiendaRepUno {
    
    private int diasEnTransito;
    private int tiempoEstimado;
    
    public TiendaRepDos(String codigoTienda, String nombre, String codigoPedido, String fecha, int diasEnTransito, int tiempoEstimado, String total, String nit, String cliente) {
        super(codigoTienda, nombre, codigoPedido, fecha, total, nit , cliente);
        this.diasEnTransito = diasEnTransito;
        this.tiempoEstimado = tiempoEstimado;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(int tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    
    public int getDiasEnTransito() {
        return diasEnTransito;
    }

    public void setDiasEnTransito(int diasEnTransito) {
        this.diasEnTransito = diasEnTransito;
    }
    
    
}
