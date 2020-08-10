package com.tienda.entities;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Julio
 */
public class Cliente implements Serializable {

    private String nit;
    private String email;
    private boolean estado;
    private String Persona_dpi;
    private BigDecimal credito;

    public Cliente(String nit, String email, boolean estado, String Persona_dpi, BigDecimal credito) {

        this.nit = nit;
        this.email = email;
        this.estado = estado;
        this.Persona_dpi = Persona_dpi;
        this.credito = credito;
    }

    public String getNit() {
        return this.nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public BigDecimal getCredito() {
        return credito;
    }

    public void setCredito(BigDecimal credito) {
        this.credito = credito;
    }
    

}
