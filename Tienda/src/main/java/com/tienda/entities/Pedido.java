package com.tienda.entities;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Julio
 */
public class Pedido implements Serializable {

    private String codigo;
    private java.sql.Date fecha;
    private boolean entregado;
    private int retraso;
    private boolean destino;
    private boolean estado;
    private int TiempoDeEnvio_idTiempoDeEnvio;
    private String Cliente_nit;
    private BigDecimal anticipo;
    private BigDecimal subtotal;
    
    public Pedido(String codigo, java.sql.Date fecha, boolean entregado, int retraso, boolean destino, boolean estado, int TiempoDeEnvio_idTiempoDeEnvio, String Cliente_nit, BigDecimal anticipo,BigDecimal subtotal) {

        this.codigo = codigo;
        this.fecha = fecha;
        this.entregado = entregado;
        this.retraso = retraso;
        this.destino = destino;
        this.estado = estado;
        this.TiempoDeEnvio_idTiempoDeEnvio = TiempoDeEnvio_idTiempoDeEnvio;
        this.Cliente_nit = Cliente_nit;
        this.anticipo = anticipo;
        this.subtotal = subtotal;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public java.sql.Date getFecha() {
        return this.fecha;
    }

    public void setFecha(java.sql.Date fecha) {
        this.fecha = fecha;
    }

    public boolean isEntregado() {
        return this.entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    public int getRetraso() {
        return this.retraso;
    }

    public void setRetraso(int retraso) {
        this.retraso = retraso;
    }

    public boolean isDestino() {
        return this.destino;
    }

    public void setDestino(boolean destino) {
        this.destino = destino;
    }

    public boolean isEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getTiempoDeEnvio_idTiempoDeEnvio() {
        return this.TiempoDeEnvio_idTiempoDeEnvio;
    }

    public void setTiempoDeEnvio_idTiempoDeEnvio(int TiempoDeEnvio_idTiempoDeEnvio) {
        this.TiempoDeEnvio_idTiempoDeEnvio = TiempoDeEnvio_idTiempoDeEnvio;
    }

    public String getCliente_nit() {
        return this.Cliente_nit;
    }

    public void setCliente_nit(String Cliente_nit) {
        this.Cliente_nit = Cliente_nit;
    }

    public BigDecimal getAnticipo() {
        return anticipo;
    }

    public void setAnticipo(BigDecimal anticipo) {
        this.anticipo = anticipo;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
    
    

}
