package com.tienda.dao;

import com.tienda.dto.DetallePedidoProducto;
import com.tienda.entities.DetallePedido;
import java.util.List;

/**
 *
 * @author Julio
 */
public interface DetallePedidoDAO extends DAO<DetallePedido,Integer> {

    public List<DetallePedido> obtenerDetallePorCodigoDePedido(String codigoPedido);
    public List<DetallePedidoProducto> getCodigoProductoCantidad(String codigoPedido);
}
