package com.tienda.entities;

import java.io.Serializable;

/**
 *
 * @author Julio
 */
public class Empleado implements Serializable {

    private int idUsuarioSystem;
    private String codigoEmpleado;
    private String nit;
    private String email;
    private int tipo;
    private boolean estado;
    private String Persona_dpi;

    public Empleado(int idUsuario, String codigoEmpleado, String nit, int tipo, boolean estado, String Persona_dpi, String email) {
        this.idUsuarioSystem = idUsuario;
        this.codigoEmpleado = codigoEmpleado;
        this.nit = nit;
        this.email = email;
        this.tipo = tipo;
        this.Persona_dpi = Persona_dpi;
    }

    public int getIdUsuarioSystem() {
        return idUsuarioSystem;
    }

    public void setIdUsuarioSystem(int idUsuarioSystem) {
        this.idUsuarioSystem = idUsuarioSystem;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getPersona_dpi() {
        return Persona_dpi;
    }

    public void setPersona_dpi(String Persona_dpi) {
        this.Persona_dpi = Persona_dpi;
    }

  
}
