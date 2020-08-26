package com.tienda.dao;

import com.tienda.dto.FacturaDto;
import com.tienda.entities.Pedido;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Julio
 */
public interface PedidoDAO extends DAO<Pedido, String> {

    public List<Pedido> sinEntregarEnDestino(String tiendaDestino);

    public List<Pedido> buscarCoincidenciaSinEntregarEnDestino(String matchParameter);

    public List<Pedido> buscarCoincidenciaPedidosEntregadosEnTiendaDestino(String matchParameter);

    public List<Pedido> paraRecogerSeEncuentraEnDestino(String tiendaDestino);

    public List<FacturaDto> reporteSeis(String nitCliente, String codigoTienda, Date dateInit, Date dateFinal);

    public List<FacturaDto> paraMostrarAlCliente(String nitCliente, String codigoTienda, Date dateInit, Date dateFinal);

    public List<FacturaDto> paraMostrarAlClienteOrdenado(String nitCliente, String codigoTienda, Date dateInit, Date dateFinal, String orderBy);
    
    public List<FacturaDto> paraMostrarAlClienteConLike(String nitCliente, String codigoTienda, Date dateInit, Date dateFinal ,String like, String conFecha);
}
