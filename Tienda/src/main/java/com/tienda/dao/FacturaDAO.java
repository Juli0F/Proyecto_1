package com.tienda.dao;

import com.tienda.dto.FacturaDto;
import com.tienda.entities.Factura;
import java.util.List;

/**
 *
 * @author Julio
 */
public interface FacturaDAO extends DAO<Factura,Integer> {
     public List<FacturaDto> reporteCinco(String nitCliente, String codigoTienda, java.sql.Date dateInit, java.sql.Date dateFinal);

}
