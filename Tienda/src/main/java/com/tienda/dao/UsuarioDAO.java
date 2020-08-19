package com.tienda.dao;


import com.tienda.dto.EmpleadoDTO;
import com.tienda.entities.Usuario;
import java.util.List;

/**
 *
 * @author Julio
 */
public interface UsuarioDAO extends DAO<Usuario,Integer> {

    public Usuario getUsuarioByUsrAndPassword(String usuario, String password);
    

}
