package com.tienda.entities;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Julio
 */
public class Stock_Tienda implements Serializable {

    private int idStockTienda;
    private String tienda_codigo;
    private String producto_codigo;
    private boolean estado;
    private int cantidad;
    private BigDecimal precio;

    public Stock_Tienda(int idStockTienda, String tienda_codigo, String producto_codigo, boolean estado, int cantidad, BigDecimal precio) {

        this.idStockTienda = idStockTienda;
        this.tienda_codigo = tienda_codigo;
        this.producto_codigo = producto_codigo;
        this.estado = estado;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getIdStockTienda() {
        return this.idStockTienda;
    }

    public void setIdStockTienda(int idStockTienda) {
        this.idStockTienda = idStockTienda;
    }

    public String getTienda_codigo() {
        return this.tienda_codigo;
    }

    public void setTienda_codigo(String tienda_codigo) {
        this.tienda_codigo = tienda_codigo;
    }

    public String getProducto_codigo() {
        return this.producto_codigo;
    }

    public void setProducto_codigo(String producto_codigo) {
        this.producto_codigo = producto_codigo;
    }

    public boolean isEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    

}
