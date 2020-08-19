package com.tienda.dao;

import com.tienda.dto.EmpleadoDTO;
import com.tienda.entities.Empleado;
import com.tienda.entities.Usuario;
import java.util.List;

/**
 *
 * @author Julio
 */
public interface EmpleadoDAO extends DAO<Empleado,Integer> {

public Empleado getByCodeUsr(String codigoUsuario);
    public List<EmpleadoDTO> getByUsuarioDTO();
}
