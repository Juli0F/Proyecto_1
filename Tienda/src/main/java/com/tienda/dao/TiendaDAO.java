package com.tienda.dao;

import com.tienda.entities.Tienda;
import java.util.List;

/**
 *
 * @author Julio
 */
public interface TiendaDAO extends DAO<Tienda,String> {

    
    public List<Tienda> getSearchWithLike(String parameterOfSearch);

}
