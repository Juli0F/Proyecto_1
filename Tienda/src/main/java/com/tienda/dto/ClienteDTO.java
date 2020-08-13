/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.dto;

import java.math.BigDecimal;

/**
 *
 * @author julio
 */
public class ClienteDTO {
 
    private String dpi;
    private String nit;
    private String nombre;
    private String telefono;
    private String direccion;
    private String email;
    private BigDecimal credito;

    public ClienteDTO(String dpi, String nit,String nombre, String telefono, String direccion, String email, BigDecimal credito) {
        this.dpi = dpi;
        this.nit = nit;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.credito = credito;
        this.nombre = nombre;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getCredito() {
        return credito;
    }

    public void setCredito(BigDecimal credito) {
        this.credito = credito;
    }
    
}
