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

}
