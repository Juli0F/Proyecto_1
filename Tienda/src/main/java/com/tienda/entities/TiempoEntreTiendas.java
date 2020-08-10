package com.tienda.entities;

import java.io.Serializable;

/**
 *
 * @author Julio
 */
public class TiempoEntreTiendas implements Serializable {

    private int idTiempoEntreTiendas;
    private int TiempoDeEnvio_idTiempoDeEnvio;
    private String Tienda_codigo;
    private String descripcion;

    public TiempoEntreTiendas(int idTiempoEntreTiendas, int TiempoDeEnvio_idTiempoDeEnvio, String Tienda_codigo, String descripcion) {

        this.idTiempoEntreTiendas = idTiempoEntreTiendas;
        this.TiempoDeEnvio_idTiempoDeEnvio = TiempoDeEnvio_idTiempoDeEnvio;
        this.Tienda_codigo = Tienda_codigo;
        this.descripcion = descripcion;
    }

    public int getIdTiempoEntreTiendas() {
        return this.idTiempoEntreTiendas;
    }

    public void setIdTiempoEntreTiendas(int idTiempoEntreTiendas) {
        this.idTiempoEntreTiendas = idTiempoEntreTiendas;
    }

    public int getTiempoDeEnvio_idTiempoDeEnvio() {
        return this.TiempoDeEnvio_idTiempoDeEnvio;
    }

    public void setTiempoDeEnvio_idTiempoDeEnvio(int TiempoDeEnvio_idTiempoDeEnvio) {
        this.TiempoDeEnvio_idTiempoDeEnvio = TiempoDeEnvio_idTiempoDeEnvio;
    }

    public String getTienda_codigo() {
        return this.Tienda_codigo;
    }

    public void setTienda_codigo(String Tienda_codigo) {
        this.Tienda_codigo = Tienda_codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}
