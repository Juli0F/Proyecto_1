package Entities;

import java.io.Serializable;
/**
 *
 * @author Julio
 */
public class Producto implements Serializable{
  private String codigo;
  private String nombre;
  private String fabricante;
  private String Descripcion;
  private int Garantia;
  private boolean estado;

  public Producto (String codigo, String nombre, String fabricante, String Descripcion, int Garantia, boolean estado ){

  this.codigo = codigo;
  this.nombre = nombre;
  this.fabricante = fabricante;
  this.Descripcion = Descripcion;
  this.Garantia = Garantia;
  this.estado = estado;
  }

  public String getCodigo(){
      return this.codigo;
  }

  public void setCodigo(String codigo){
      this.codigo = codigo;
  }

  public String getNombre(){
      return this.nombre;
  }

  public void setNombre(String nombre){
      this.nombre = nombre;
  }

  public String getFabricante(){
      return this.fabricante;
  }

  public void setFabricante(String fabricante){
      this.fabricante = fabricante;
  }

  public String getDescripcion(){
      return this.Descripcion;
  }

  public void setDescripcion(String Descripcion){
      this.Descripcion = Descripcion;
  }

  public int getGarantia(){
      return this.Garantia;
  }

  public void setGarantia(int Garantia){
      this.Garantia = Garantia;
  }

  public boolean isEstado(){
      return this.estado;
  }

  public void setEstado(boolean estado){
      this.estado = estado;
  }

}
