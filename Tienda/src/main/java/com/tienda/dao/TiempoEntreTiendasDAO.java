package com.tienda.dao;

import com.tienda.entities.TiempoDeEnvio;
import com.tienda.entities.TiempoEntreTiendas;

/**
 *
 * @author Julio
 */
public interface TiempoEntreTiendasDAO extends DAO<TiempoEntreTiendas,Integer> {


    public Integer getTiempoByTwoStore(String codigoTiendaA, String codigoTiendaB);
    public Integer getTheTimeBetweenStoresWithTheCodeOfTheStoresInvolved(String codigoTiendaA, String codigoTiendaB);

    public TiempoEntreTiendas getCodigoTiendaUsingidTiempoAndCodigoTiendaDestino(String tiendaDestino, int idTiempoDeEnvio);
    
}
