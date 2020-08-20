package com.tienda.dao;

import com.tienda.dto.TiendaTiempo;
import com.tienda.entities.Tienda;
import java.util.List;

/**
 *
 * @author Julio
 */
public interface TiendaDAO extends DAO<Tienda,String> {

    
    public List<Tienda> getSearchWithLike(String parameterOfSearch);
    public List<TiendaTiempo> getTiempoTiendaTET(String codigoTiendaOrigen);
    public List<TiendaTiempo> getTiempoTiendaTET();
    public List<TiendaTiempo> getTiempoTiendaTETUseLike(String codigoTiendaOrigen);
    public List<Tienda> getAllTiendaLike(String parameter);
    

}
