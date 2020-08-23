package com.tienda.dao;

import com.tienda.dto.ProductoTableDto;
import com.tienda.entities.Producto;
import java.util.List;

/**
 *
 * @author Julio
 */
public interface ProductoDAO extends DAO<Producto,String> {

    public List<Producto> getSearchWithLike(String parameterOfSearch);
    public List<ProductoTableDto> getProductoTableDto(String codigoTienda);
    /**
     * obtiene los productos que no estan en la tienda que se 
     * @param codigoTienda identificador  de la tienda / se buscan los productos que no esten en esa tienda
     * @return 
     */
    public List<Producto> getProductoQueNoEstanAsignadosEnTienda(String codigoTienda);

}
