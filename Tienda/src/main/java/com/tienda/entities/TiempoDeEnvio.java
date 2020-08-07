package com.tienda.entities;

import java.io.Serializable;

/**
 *
 * @author Julio
 */
public class TiempoDeEnvio implements Serializable {

    private int idTiempoDeEnvio;
    private String tiempo;
    private boolean estado;

    public TiempoDeEnvio(int idTiempoDeEnvio, String tiempo, boolean estado) {

        this.idTiempoDeEnvio = idTiempoDeEnvio;
        this.tiempo = tiempo;
        this.estado = estado;
    }

    public int getIdTiempoDeEnvio() {
        return this.idTiempoDeEnvio;
    }

    public void setIdTiempoDeEnvio(int idTiempoDeEnvio) {
        this.idTiempoDeEnvio = idTiempoDeEnvio;
    }

    public String getTiempo() {
        return this.tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public boolean isEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
