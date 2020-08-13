package com.tienda.dao;


import com.tienda.dto.UsuarioDTO;
import com.tienda.entities.Usuario;
import java.util.List;

/**
 *
 * @author Julio
 */
public interface UsuarioDAO extends DAO<Usuario,Integer> {

    public Usuario getByCodeUsr(String codigoUsuario);
    public List<UsuarioDTO> getByUsuarioDTO();
    

}
