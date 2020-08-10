package com.tienda.entities;

import java.io.Serializable;

/**
 *
 * @author Julio
 */
public class TiempoDeEnvio implements Serializable {

    private int idTiempoDeEnvio;
    private int tiempo;
    private boolean estado;
    private String descripcion;


    public TiempoDeEnvio(int idTiempoDeEnvio, int tiempo, boolean estado, String descripcion) {

        this.idTiempoDeEnvio = idTiempoDeEnvio;
        this.tiempo = tiempo;
        this.estado = estado;
        this.descripcion = descripcion;
    }

    public int getIdTiempoDeEnvio() {
        return this.idTiempoDeEnvio;
    }

    public void setIdTiempoDeEnvio(int idTiempoDeEnvio) {
        this.idTiempoDeEnvio = idTiempoDeEnvio;
    }

    public int getTiempo() {
        return this.tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public boolean isEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
