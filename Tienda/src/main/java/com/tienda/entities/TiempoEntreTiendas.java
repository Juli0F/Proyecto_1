package com.tienda.entities;

import java.io.Serializable;

/**
 *
 * @author Julio
 */
public class TiempoEntreTiendas implements Serializable {

    private int idTiempoEntreTiendas;
    private int tiempoDeEnvio_idTiempoDeEnvio;
    private String tienda_codigo;

    public TiempoEntreTiendas(int idTiempoEntreTiendas, int tiempoDeEnvio_idTiempoDeEnvio, String tienda_codigo) {

        this.idTiempoEntreTiendas = idTiempoEntreTiendas;
        this.tiempoDeEnvio_idTiempoDeEnvio = tiempoDeEnvio_idTiempoDeEnvio;
        this.tienda_codigo = tienda_codigo;
    }

    public int getIdTiempoEntreTiendas() {
        return this.idTiempoEntreTiendas;
    }

    public void setIdTiempoEntreTiendas(int idTiempoEntreTiendas) {
        this.idTiempoEntreTiendas = idTiempoEntreTiendas;
    }

    public int getTiempoDeEnvio_idTiempoDeEnvio() {
        return this.tiempoDeEnvio_idTiempoDeEnvio;
    }

    public void setTiempoDeEnvio_idTiempoDeEnvio(int tiempoDeEnvio_idTiempoDeEnvio) {
        this.tiempoDeEnvio_idTiempoDeEnvio = tiempoDeEnvio_idTiempoDeEnvio;
    }

    public String getTienda_codigo() {
        return this.tienda_codigo;
    }

    public void setTienda_codigo(String tienda_codigo) {
        this.tienda_codigo = tienda_codigo;
    }

}
