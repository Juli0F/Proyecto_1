package com.tienda.entities;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Julio
 */
public class DetalleFactura implements Serializable {

    private int idDetalleFactura;
    private int Factura_idFactura;
    private String Producto_codigo;
    private int cantidad;
    private BigDecimal subtotal;

    
    public DetalleFactura(int idDetalleFactura, int Factura_idFactura, String Producto_codigo, int cantidad, BigDecimal subtotal) {

        this.idDetalleFactura = idDetalleFactura;
        this.Factura_idFactura = Factura_idFactura;
        this.Producto_codigo = Producto_codigo;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    
    public int getIdDetalleFactura() {
        return this.idDetalleFactura;
    }

    public void setIdDetalleFactura(int idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    public int getFactura_idFactura() {
        return this.Factura_idFactura;
    }

    public void setFactura_idFactura(int Factura_idFactura) {
        this.Factura_idFactura = Factura_idFactura;
    }

    public String getProducto_codigo() {
        return this.Producto_codigo;
    }

    public void setProducto_codigo(String Producto_codigo) {
        this.Producto_codigo = Producto_codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    

}
