package com.tienda.dao;

import com.tienda.entities.TiempoDeEnvio;
import com.tienda.entities.TiempoEntreTiendas;

/**
 *
 * @author Julio
 */
public interface TiempoEntreTiendasDAO extends DAO<TiempoEntreTiendas,Integer> {


    public Integer getTiempoByTwoStore(String codigoTiendaA, String codigoTiendaB);

}
