package com.tienda.dao;

import com.tienda.entities.Pedido;
import java.util.List;

/**
 *
 * @author Julio
 */
public interface PedidoDAO extends DAO<Pedido,String> {


    public List<Pedido> sinEntregarEnDestino();
    public List<Pedido> buscarCoincidenciaSinEntregarEnDestino(String matchParameter);
    public List<Pedido> buscarCoincidenciaPedidosEntregadosEnTiendaDestino(String matchParameter);
    public List<Pedido> paraRecogerSeEncuentraEnDestino();
}
