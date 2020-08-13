package com.tienda.dao;

import com.tienda.dto.ClienteDTO;
import com.tienda.entities.Cliente;
import java.util.List;

/**
 *
 * @author Julio
 */
public interface ClienteDAO extends DAO<Cliente,String> {

    public List<ClienteDTO> getClienteForDto();
    public List<ClienteDTO> getClienteForDtoWhitLike(String parameter);
}
