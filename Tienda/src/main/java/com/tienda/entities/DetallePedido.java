package com.tienda.entities;

import java.io.Serializable;
/**
 *
 * @author Julio
 */
public class DetallePedido implements Serializable{
  private int idDetallePedido;
  private int cantidad;
  private boolean estado;
  private String Producto_codigo;
  private String Pedido_codigo;

  public DetallePedido (int idDetallePedido, int cantidad, boolean estado, String Producto_codigo, String Pedido_codigo ){

  this.idDetallePedido = idDetallePedido;
  this.cantidad = cantidad;
  this.estado = estado;
  this.Producto_codigo = Producto_codigo;
  this.Pedido_codigo = Pedido_codigo;
  }

  public int getIdDetallePedido(){
      return this.idDetallePedido;
  }

  public void setIdDetallePedido(int idDetallePedido){
      this.idDetallePedido = idDetallePedido;
  }

  public int getCantidad(){
      return this.cantidad;
  }

  public void setCantidad(int cantidad){
      this.cantidad = cantidad;
  }

  public boolean isEstado(){
      return this.estado;
  }

  public void setEstado(boolean estado){
      this.estado = estado;
  }

  public String getProducto_codigo(){
      return this.Producto_codigo;
  }

  public void setProducto_codigo(String Producto_codigo){
      this.Producto_codigo = Producto_codigo;
  }

  public String getPedido_codigo(){
      return this.Pedido_codigo;
  }

  public void setPedido_codigo(String Pedido_codigo){
      this.Pedido_codigo = Pedido_codigo;
  }

}
