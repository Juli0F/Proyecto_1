package com.tienda.entities;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Julio
 */
public class Factura implements Serializable {

    private int idFactura;
    private String descripcion;
    private boolean estado;
    private int Usuario_idUsuario;
    private String Tienda_codigo;
    private String nit;
    private BigDecimal total;
    
    public Factura(int idFactura, String descripcion, boolean estado, int Usuario_idUsuario, String Tienda_codigo, String nit,BigDecimal total) {

        this.idFactura = idFactura;
        this.descripcion = descripcion;
        this.estado = estado;
        this.Usuario_idUsuario = Usuario_idUsuario;
        this.Tienda_codigo = Tienda_codigo;
        this.nit = nit;
        this.total = total;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    

    public int getIdFactura() {
        return this.idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getUsuario_idUsuario() {
        return this.Usuario_idUsuario;
    }

    public void setUsuario_idUsuario(int Usuario_idUsuario) {
        this.Usuario_idUsuario = Usuario_idUsuario;
    }

    public String getTienda_codigo() {
        return this.Tienda_codigo;
    }

    public void setTienda_codigo(String Tienda_codigo) {
        this.Tienda_codigo = Tienda_codigo;
    }

}
