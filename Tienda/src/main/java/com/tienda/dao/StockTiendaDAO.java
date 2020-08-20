package com.tienda.dao;

import com.tienda.entities.StockTienda;
import java.util.List;

/**
 *
 * @author Julio
 */
public interface StockTiendaDAO extends DAO<StockTienda,Integer> {
    
    public StockTienda existencia(String codigoTienda, String codigoProducot);
    public List<StockTienda> productosEnUnaTienda(String codigoTienda);
}
