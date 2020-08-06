package Entities;

import java.io.Serializable;
/**
 *
 * @author Julio
 */
public class StockTienda implements Serializable{
  private int idStockTienda;
  private String Tienda_codigo;
  private String Producto_codigo;
  private boolean estado;
  private String cantidad;

  public StockTienda (int idStockTienda, String Tienda_codigo, String Producto_codigo, boolean estado, String cantidad ){

  this.idStockTienda = idStockTienda;
  this.Tienda_codigo = Tienda_codigo;
  this.Producto_codigo = Producto_codigo;
  this.estado = estado;
  this.cantidad = cantidad;
  }

  public int getIdStockTienda(){
      return this.idStockTienda;
  }

  public void setIdStockTienda(int idStockTienda){
      this.idStockTienda = idStockTienda;
  }

  public String getTienda_codigo(){
      return this.Tienda_codigo;
  }

  public void setTienda_codigo(String Tienda_codigo){
      this.Tienda_codigo = Tienda_codigo;
  }

  public String getProducto_codigo(){
      return this.Producto_codigo;
  }

  public void setProducto_codigo(String Producto_codigo){
      this.Producto_codigo = Producto_codigo;
  }

  public boolean isEstado(){
      return this.estado;
  }

  public void setEstado(boolean estado){
      this.estado = estado;
  }

  public String getCantidad(){
      return this.cantidad;
  }

  public void setCantidad(String cantidad){
      this.cantidad = cantidad;
  }

}
