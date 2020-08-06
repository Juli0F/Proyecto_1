package Entities;

import java.io.Serializable;
/**
 *
 * @author Julio
 */
public class Cliente implements Serializable{
  private String nit;
  private String email;
  private boolean estado;
  private String Pedido_codigo;
  private int Persona_dpi;

  public Cliente (String nit, String email, boolean estado, String Pedido_codigo, int Persona_dpi ){

  this.nit = nit;
  this.email = email;
  this.estado = estado;
  this.Pedido_codigo = Pedido_codigo;
  this.Persona_dpi = Persona_dpi;
  }

  public String getNit(){
      return this.nit;
  }

  public void setNit(String nit){
      this.nit = nit;
  }

  public String getEmail(){
      return this.email;
  }

  public void setEmail(String email){
      this.email = email;
  }

  public boolean isEstado(){
      return this.estado;
  }

  public void setEstado(boolean estado){
      this.estado = estado;
  }

  public String getPedido_codigo(){
      return this.Pedido_codigo;
  }

  public void setPedido_codigo(String Pedido_codigo){
      this.Pedido_codigo = Pedido_codigo;
  }

  public int getPersona_dpi(){
      return this.Persona_dpi;
  }

  public void setPersona_dpi(int Persona_dpi){
      this.Persona_dpi = Persona_dpi;
  }

}
