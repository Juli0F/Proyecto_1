package Entities;

import java.io.Serializable;
/**
 *
 * @author Julio
 */
public class Tienda implements Serializable{
  private String codigo;
  private String nombre;
  private String direccion;
  private String telefono;
  private String telefono2;
  private String email;
  private String horario;
  private boolean estado;
  private int TiempoDeEnvio_idTiempoDeEnvio;

  public Tienda (String codigo, String nombre, String direccion, String telefono, String telefono2, String email, String horario, boolean estado, int TiempoDeEnvio_idTiempoDeEnvio ){

  this.codigo = codigo;
  this.nombre = nombre;
  this.direccion = direccion;
  this.telefono = telefono;
  this.telefono2 = telefono2;
  this.email = email;
  this.horario = horario;
  this.estado = estado;
  this.TiempoDeEnvio_idTiempoDeEnvio = TiempoDeEnvio_idTiempoDeEnvio;
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

  public String getDireccion(){
      return this.direccion;
  }

  public void setDireccion(String direccion){
      this.direccion = direccion;
  }

  public String getTelefono(){
      return this.telefono;
  }

  public void setTelefono(String telefono){
      this.telefono = telefono;
  }

  public String getTelefono2(){
      return this.telefono2;
  }

  public void setTelefono2(String telefono2){
      this.telefono2 = telefono2;
  }

  public String getEmail(){
      return this.email;
  }

  public void setEmail(String email){
      this.email = email;
  }

  public String getHorario(){
      return this.horario;
  }

  public void setHorario(String horario){
      this.horario = horario;
  }

  public boolean isEstado(){
      return this.estado;
  }

  public void setEstado(boolean estado){
      this.estado = estado;
  }

  public int getTiempoDeEnvio_idTiempoDeEnvio(){
      return this.TiempoDeEnvio_idTiempoDeEnvio;
  }

  public void setTiempoDeEnvio_idTiempoDeEnvio(int TiempoDeEnvio_idTiempoDeEnvio){
      this.TiempoDeEnvio_idTiempoDeEnvio = TiempoDeEnvio_idTiempoDeEnvio;
  }

}
