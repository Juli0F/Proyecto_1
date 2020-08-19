package com.tienda.mysql;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.tienda.dao.EmpleadoDAO;
import com.tienda.dto.EmpleadoDTO;
import com.tienda.entities.Empleado;
import com.tienda.entities.Usuario;

public class EmpleadoD implements EmpleadoDAO {

    private Connection connection;
    private final String INSERT = "INSERT INTO Empleado (codigoEmpleado,nit,email,tipo,estado,Persona_dpi) VALUES (?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE UsuarioSystem set codigoEmpleado = ?,  nit = ?,  email=?, tipo=?, estado = ?,  Persona_dpi = ? WHERE idUsuarioSystem = ? ";
    private final String DELETE = "DELETE UsuarioSystem WHERE Empleado = ? ";
    private final String GETALL = "SELECT * FROM  Empleado  ";
    private final String GETONE = GETALL + "WHERE Empleado = ?";
    private final String GETBYCODEEMPLEADO = GETALL + "WHERE codigoEmpleado = ?";
    private final String GETBYALLUSRANDPERSON = "Select p.dpi,c.nit,p.nombre,p.telefono,p.direccion,c.email,c.usuario, c.tipo from Persona p inner join Empleado c on p.dpi = c.Persona_dpi where c.tipo = 2";


    public EmpleadoD(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Empleado object) {
        PreparedStatement stat = null;;
        try {
            stat = connection.prepareStatement(INSERT);
            stat.setString(1, object.getCodigoEmpleado());
            stat.setString(2, object.getNit());
            stat.setString(3, object.getEmail());
            stat.setInt(4, object.getTipo());
            stat.setBoolean(5, object.isEstado());
            stat.setString(6, object.getPersona_dpi());
            if (stat.executeUpdate() == 0) {
                System.out.println("crear popover UsuarioSystem");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modify(Empleado object) {
        PreparedStatement stat = null;;
        try {
            stat = connection.prepareStatement(UPDATE);
            stat.setString(1, object.getCodigoEmpleado());
            stat.setString(2, object.getNit());
            stat.setString(3, object.getEmail());
            stat.setInt(4, object.getTipo());
            stat.setBoolean(5, object.isEstado());
            stat.setString(6, object.getPersona_dpi());
            stat.setInt(7, object.getIdUsuarioSystem());
            if (stat.executeUpdate() == 0) {
                System.out.println("crear popover UsuarioSystem");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Empleado> obtenerTodo() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Empleado> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                lst.add(convertir(rs));
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Empleado obtener(Integer id) {
        PreparedStatement stat = null;
        ResultSet rs = null;

        try {
            stat = connection.prepareStatement(GETONE);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            while (rs.next()) {
                return (convertir(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Empleado object) {
        PreparedStatement stat = null;
        try {
            stat = connection.prepareStatement(DELETE);
            stat.setInt(1, object.getIdUsuarioSystem());
            if (stat.executeUpdate() == 0) {

            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Empleado convertir(ResultSet rs) {

        try {          
                                                    
            Empleado usuarioSystem = new Empleado(rs.getInt("idUsuarioSystem"), rs.getString("codigoEmpleado"), rs.getString("nit"), rs.getInt("tipo"), rs.getBoolean("estado"),rs.getString("Pesona_dpi"),rs.getString("email"));

            return usuarioSystem;
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Integer lastInsertId() {
        String ultimo = "SELECT last_insert_id()";
        PreparedStatement stat = null;
        ResultSet rs = null;

        try {
            stat = connection.prepareStatement(ultimo);
            rs = stat.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
       @Override
    public Empleado getByCodeUsr(String codigoUsuario) {
        PreparedStatement stat = null;
        ResultSet rs = null;

        try {
            stat = connection.prepareStatement(GETBYCODEEMPLEADO);
            stat.setString(1, codigoUsuario);
            rs = stat.executeQuery();
            while (rs.next()) {
                return (convertir(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<EmpleadoDTO> getByUsuarioDTO() {
         PreparedStatement stat = null;
        ResultSet rs = null;
        List<EmpleadoDTO> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(GETBYALLUSRANDPERSON);
            rs = stat.executeQuery();
            while (rs.next()) {
                lst.add(convertUsuarioDTO(rs));
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    public EmpleadoDTO convertUsuarioDTO(ResultSet rs){
          try {
              //String dpi, String nit, String nombre, String telefono, String direccion, String email, String codigoUsuario, int tipo) {
            EmpleadoDTO usuario = new EmpleadoDTO (rs.getString("dpi"), rs.getString("nit"), rs.getString("nombre"), rs.getString("telefono"), rs.getString("direccion"), rs.getString("email"), rs.getString("codigoEmpleado"),rs.getInt("tipo"));

            return usuario;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
}
