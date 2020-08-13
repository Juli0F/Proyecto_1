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
    private boolean estado;
    private String Persona_dpi;
    private String email;

    public Usuario(int idUsuario, String usuario, String password, int tipo, boolean estado, String Persona_dpi,String email) {

        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
        this.tipo = tipo;
        this.estado = estado;
        this.Persona_dpi = Persona_dpi;
        this.email = email;
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

    public boolean isEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getPersona_dpi() {
        return this.Persona_dpi;
    }

    public void setPersona_dpi(String Persona_dpi) {
        this.Persona_dpi = Persona_dpi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
