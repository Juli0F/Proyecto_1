package com.tienda.dao;

import com.tienda.entities.TiempoEntreTiendas;

/**
 *
 * @author Julio
 */
public interface TiempoEntreTiendasDAO extends DAO<TiempoEntreTiendas,Integer> {

    public TiempoEntreTiendas getByIdAndDescripcion(String codigoTienda, String descripcion);

}
