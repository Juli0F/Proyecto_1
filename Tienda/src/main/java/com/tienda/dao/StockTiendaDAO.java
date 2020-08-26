package com.tienda.dao;

import com.tienda.dto.CatalogoDto;
import com.tienda.entities.StockTienda;
import java.util.List;

/**
 *
 * @author Julio
 */
public interface StockTiendaDAO extends DAO<StockTienda,Integer> {
    
    public StockTienda existencia(String codigoTienda, String codigoProducot);
    public List<StockTienda> productosEnUnaTienda(String codigoTienda);
    
    public List<CatalogoDto> catalogo();
    public List<CatalogoDto> catalogoEnTienda(String codigoTienda);
    public List<CatalogoDto> catalogoProducto(String matchParameter);
    public List<CatalogoDto> catalogoEnTiendaProducto(String codigoTienda ,String match);
}
