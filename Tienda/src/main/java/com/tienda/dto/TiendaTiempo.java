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
public class TiendaTiempo {
    private String codigo;
    private String tienda;
    private int tiempo;

    public TiendaTiempo(String codigo, String tienda, int tiempo) {
        this.codigo = codigo;
        this.tienda = tienda;
        this.tiempo = tiempo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
    
}
