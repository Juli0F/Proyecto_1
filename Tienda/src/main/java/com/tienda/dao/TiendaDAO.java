package com.tienda.dao;

import com.tienda.dto.TiendaRepDos;
import com.tienda.dto.TiendaRepUno;
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
    
    /**
     * metodo que debe traer los datos para el reporte 1
     * datos a traer codigo de tienda, nombre de tienda, codigo de pedido y fecha del pedido
     * @param codigoTiendaDestino
     * @return 
     */
    public List<TiendaRepUno> pedidosSinFecha(String codigoTiendaDestino);
    /**
     * metodo que busca pedidos con una fecha en adelante
     * @param codigoTiendaDestino
     * @param dateInit
     * @return 
     */
    public List<TiendaRepUno> pedidosFechaInicial(String codigoTiendaDestino, java.sql.Date dateInit);
    /**
     * busca todos los pedidos con una fecha limite, de la fecha
     * que se le pasa por parametro para atras
     * @param codigoTiendaDestino
     * @param dateFinal
     * @return 
     */
    public List<TiendaRepUno> pedidosFechaFinal(String codigoTiendaDestino, java.sql.Date dateFinal);
    /**
     * pedidos en un rango de fechas
     * @param codigoTiendaDestino
     * @param dateInit
     * @param dateFinal
     * @return 
     */
    public List<TiendaRepUno> pedidosEntreFechas(String codigoTiendaDestino, java.sql.Date dateInit, java.sql.Date dateFinal);
    
    /**
     * devuelve todos los pedidos que estan en falta de verificacion,
     * @param codigoTienda
     * @param date
     * @return Lista de objetos del tipo TiendaRepDos, objeto contiene codigo y nombre de tienda, codigo y fecha de pedido, y los dias que han pasado desde que se hizo el pedido
     */
    public List<TiendaRepDos> pedidosFaltaVerificacion(String codigoTienda, java.sql.Date date);
    
    /**
     * encuentra todos los pedidos con  atraso 
     * @param codigoTienda
     * @param date
     * @return 
     */
    public List<TiendaRepDos> pedidosConAtraso(String codigoTienda, java.sql.Date date);
    /**
     * pedidos que abastace una tienda
     * @param codigoTiendaOrigen
     * @param date
     * @return 
     */
    public List<TiendaRepDos> pedidosDespachadosPorUnaTienda(String codigoTiendaOrigen, java.sql.Date date);

}
