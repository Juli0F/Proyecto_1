package com.tienda.dao;

import com.tienda.entities.StockTienda;

/**
 *
 * @author Julio
 */
public interface StockTiendaDAO extends DAO<StockTienda,Integer> {
    
    public StockTienda existencia(String codigoTienda, String codigoProducot);

}
