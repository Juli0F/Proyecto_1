package com.tienda.dao;

import com.tienda.dto.TiendaTiempo;
import com.tienda.entities.Tienda;
import java.util.List;

/**
 *
 * @author Julio
 */
public interface TiendaDAO extends DAO<Tienda,String> {

    /**
     * busca tiendas activas que coincidan con el parametro enviado
     * busca el parametro en todos los atributos de  Tienda
     * @param parameterOfSearch
     * @return 
     */
    public List<Tienda> getSearchWithLike(String parameterOfSearch);
    /**
     * Busca en la tablas TiempoEntreTiendas TiempoDeEnvio y Tienda,la tienda con el codigo que se le envia por parametro
     * 
     * @param codigoTiendaOrigen
     * @return 
     */
    public List<TiendaTiempo> getTiempoTiendaTET(String codigoTiendaOrigen);
    
    /**
     * Lista todas las tiendas que tienen tiempo de envio 
     * por lo que hace una busqueda en las tablas TiempoEntreTiendas TiempoDeEnvio y Tienda
     * y devuelve todas las tiendas activas que se encuentren en esa tabla
     * @return 
     */
    public List<TiendaTiempo> getTiempoTiendaTET();
    
    public List<TiendaTiempo> getTiendasSinTiempoConRespectoAOtra(String codigoTienda);
    public List<TiendaTiempo> getTiempoTiendaTETUseLike(String codigoTiendaOrigen);
    public List<Tienda> getAllTiendaLike(String parameter);
    
    /**
     * Este metodo devuelve las tiendas que no tienen tiempo relacionado
     * con otra tienda
     *
     * 
     * @param codigoTienda
     * @return Lista del Tipo Tienda
     */
    public List<Tienda> getTiendaSinRelacionDeTiempoConRespectoAOtra(String codigoTienda);

}
