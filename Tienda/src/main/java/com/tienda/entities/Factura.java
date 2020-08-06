package Entities;

import java.io.Serializable;
/**
 *
 * @author Julio
 */
public class Factura implements Serializable{
  private int idFactura;
  private String descripcion;
  private boolean estado;
  private int Usuario_idUsuario;

  public Factura (int idFactura, String descripcion, boolean estado, int Usuario_idUsuario ){

  this.idFactura = idFactura;
  this.descripcion = descripcion;
  this.estado = estado;
  this.Usuario_idUsuario = Usuario_idUsuario;
  }

  public int getIdFactura(){
      return this.idFactura;
  }

  public void setIdFactura(int idFactura){
      this.idFactura = idFactura;
  }

  public String getDescripcion(){
      return this.descripcion;
  }

  public void setDescripcion(String descripcion){
      this.descripcion = descripcion;
  }

  public boolean isEstado(){
      return this.estado;
  }

  public void setEstado(boolean estado){
      this.estado = estado;
  }

  public int getUsuario_idUsuario(){
      return this.Usuario_idUsuario;
  }

  public void setUsuario_idUsuario(int Usuario_idUsuario){
      this.Usuario_idUsuario = Usuario_idUsuario;
  }

}
