package com.tienda.dao;

import com.tienda.dto.DetallePedidoProducto;
import com.tienda.entities.DetalleFactura;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Julio
 */
public interface DetalleFacturaDAO extends DAO<DetalleFactura, Integer> {

    public List<DetallePedidoProducto> getCodigoProductoCantidad(String codigoPedido);
    public List<DetallePedidoProducto> reporteSiete(java.sql.Date dateInit,java.sql.Date dateFinal);
    public List<DetallePedidoProducto> reporteOcho(String tienda, Date dateInit, Date dateFinal);
}
