package com.tienda.mysql;

import com.tienda.dao.UsuarioDAO;
import com.tienda.dto.EmpleadoDTO;
import com.tienda.entities.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioD implements UsuarioDAO {

    private Connection connection;
    private final String INSERT = "INSERT INTO Usuario (usuario,password,tipo,estado,Persona_dpi,email) VALUES (?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE Usuario SET usuario = ?, password = ?, tipo = ?, estado = ?, Persona_dpi = ?, email = ?  WHERE idUsuario = ? ";
    private final String DELETE = "DELETE Usuario WHERE idUsuario = ? ";
    private final String GETALL = "SELECT * FROM  Usuario  ";
    private final String GETONE = GETALL + "WHERE idUsuario = ?";
    private final String GETUSRPASSWORD = GETALL + " AS U WHERE U.usuario = ? AND U.password = ? ";
    
    public UsuarioD(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Usuario object) {
        PreparedStatement stat = null;;
        try {
            stat = connection.prepareStatement(INSERT);
            stat.setString(1, object.getUsuario());
            stat.setString(2, object.getPassword());
            stat.setInt(3, object.getTipo());
            stat.setBoolean(4, object.isEstado());
            stat.setString(5, object.getPersona_dpi());
            stat.setString(6, object.getEmail());
            if (stat.executeUpdate() == 0) {
                System.out.println("crear popover Usuario");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modify(Usuario object) {
        PreparedStatement stat = null;;
        try {
            stat = connection.prepareStatement(UPDATE);
            stat.setString(1, object.getUsuario());
            stat.setString(2, object.getPassword());
            stat.setInt(3, object.getTipo());
            stat.setBoolean(4, object.isEstado());
            stat.setString(5, object.getPersona_dpi());
            stat.setString(6, object.getEmail());
            stat.setInt(7, object.getIdUsuario());
            if (stat.executeUpdate() == 0) {
                System.out.println("crear popover Usuario");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Usuario> obtenerTodo() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Usuario> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(GETALL + "WHERE estado = 1");
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
    public Usuario obtener(Integer id) {
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
    public void delete(Usuario object) {
        PreparedStatement stat = null;
        try {
            stat = connection.prepareStatement(DELETE);
            stat.setInt(1, object.getIdUsuario());
            if (stat.executeUpdate() == 0) {

            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario convertir(ResultSet rs) {

        try {
            Usuario usuario = new Usuario(rs.getInt("idUsuario"), rs.getString("usuario"), rs.getString("password"), rs.getInt("tipo"), rs.getBoolean("estado"), rs.getString("Persona_dpi"), rs.getString("email"));

            return usuario;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UsuarioD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public Usuario getUsuarioByUsrAndPassword(String usuario, String password) {
         PreparedStatement stat = null;
        ResultSet rs = null;

        try {
            stat = connection.prepareStatement(GETUSRPASSWORD);
            stat.setString(1, usuario);
            stat.setString(2, password);
            rs = stat.executeQuery();
            while (rs.next()) {
                return (convertir(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

 
}
