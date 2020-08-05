package Entities;

import java.io.Serializable;
/**
 *
 * @author Julio
 */
public class Persona implements Serializable{
  private int dpi;
  private String nombre;
  private String telefono;
  private String direccion;
  private boolean estado;

  public Persona (int dpi, String nombre, String telefono, String direccion, boolean estado ){

  this.dpi = dpi;
  this.nombre = nombre;
  this.telefono = telefono;
  this.direccion = direccion;
  this.estado = estado;
  }

  public int getDpi(){
      return this.dpi;
  }

  public void setDpi(int dpi){
      this.dpi = dpi;
  }

  public String getNombre(){
      return this.nombre;
  }

  public void setNombre(String nombre){
      this.nombre = nombre;
  }

  public String getTelefono(){
      return this.telefono;
  }

  public void setTelefono(String telefono){
      this.telefono = telefono;
  }

  public String getDireccion(){
      return this.direccion;
  }

  public void setDireccion(String direccion){
      this.direccion = direccion;
  }

  public boolean isEstado(){
      return this.estado;
  }

  public void setEstado(boolean estado){
      this.estado = estado;
  }

}
