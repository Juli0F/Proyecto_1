package com.tienda.entities;

import java.io.Serializable;
/**
 *
 * @author Julio
 */
public class DetalleFactura implements Serializable{
  private int idDetalleFactura;
  private int Factura_idFactura;
  private String Producto_codigo;

  public DetalleFactura (int idDetalleFactura, int Factura_idFactura, String Producto_codigo ){

  this.idDetalleFactura = idDetalleFactura;
  this.Factura_idFactura = Factura_idFactura;
  this.Producto_codigo = Producto_codigo;
  }

  public int getIdDetalleFactura(){
      return this.idDetalleFactura;
  }

  public void setIdDetalleFactura(int idDetalleFactura){
      this.idDetalleFactura = idDetalleFactura;
  }

  public int getFactura_idFactura(){
      return this.Factura_idFactura;
  }

  public void setFactura_idFactura(int Factura_idFactura){
      this.Factura_idFactura = Factura_idFactura;
  }

  public String getProducto_codigo(){
      return this.Producto_codigo;
  }

  public void setProducto_codigo(String Producto_codigo){
      this.Producto_codigo = Producto_codigo;
  }

}
