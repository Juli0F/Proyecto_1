package com.tienda.dao;

import com.tienda.entities.TiempoDeEnvio;

/**
 *
 * @author Julio
 */
public interface TiempoDeEnvioDAO extends DAO<TiempoDeEnvio,Integer> {

 public TiempoDeEnvio getTiempoUsandoTiendaAAndTiendaB(String codeTiendaA, String codeTiendaB);
 public int datediff(java.sql.Date diaPedido, java.sql.Date diaEntrega);
    
}
