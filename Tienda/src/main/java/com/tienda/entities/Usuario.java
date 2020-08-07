package com.tienda.entities;

import java.io.Serializable;

/**
 *
 * @author Julio
 */
public class Usuario implements Serializable {

    private int idUsuario;
    private String usuario;
    private String password;
    private int tipo;
    private String estado;
    private int Persona_dpi;

    public Usuario(int idUsuario, String usuario, String password, int tipo, String estado, int Persona_dpi) {

        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
        this.tipo = tipo;
        this.estado = estado;
        this.Persona_dpi = Persona_dpi;
    }

    public int getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTipo() {
        return this.tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPersona_dpi() {
        return this.Persona_dpi;
    }

    public void setPersona_dpi(int Persona_dpi) {
        this.Persona_dpi = Persona_dpi;
    }

}
