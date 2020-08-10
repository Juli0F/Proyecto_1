package com.tienda.mysql;

import com.tienda.dao.TiendaDAO;
import com.tienda.entities.Tienda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TiendaD implements TiendaDAO {

    private Connection connection;
    private final String INSERT = "INSERT INTO Tienda (nombre,direccion,telefono,telefono2,email,horario,estado,codigo) VALUES (?,?,?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE Tienda set nombre = ?, set direccion = ?, set telefono = ?, set telefono2 = ?, set email = ?, set horario = ?, set estado = ? WHERE codigo = ? ";
    private final String DELETE = "DELETE Tienda WHERE codigo = ? ";
    private final String GETALL = "SELECT * FROM  Tienda  ";
    private final String GETONE = GETALL + "WHERE codigo = ?";

    public TiendaD(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Tienda object) {
        PreparedStatement stat = null;;
        try {
            stat = connection.prepareStatement(INSERT);
            stat.setString(1, object.getNombre());
            stat.setString(2, object.getDireccion());
            stat.setString(3, object.getTelefono());
            stat.setString(4, object.getTelefono2());
            stat.setString(5, object.getEmail());
            stat.setString(6, object.getHorario());
            stat.setBoolean(7, object.isEstado());
            stat.setString(8, object.getCodigo());
            if (stat.executeUpdate() == 0) {
                System.out.println("crear popover Tienda");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modify(Tienda object) {
        PreparedStatement stat = null;;
        try {
            stat = connection.prepareStatement(UPDATE);
            stat.setString(1, object.getNombre());
            stat.setString(2, object.getDireccion());
            stat.setString(3, object.getTelefono());
            stat.setString(4, object.getTelefono2());
            stat.setString(5, object.getEmail());
            stat.setString(6, object.getHorario());
            stat.setBoolean(7, object.isEstado());
            stat.setString(8, object.getCodigo());
            if (stat.executeUpdate() == 0) {
                System.out.println("crear popover Tienda");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Tienda> obtenerTodo() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Tienda> lst = new ArrayList<>();
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
    public Tienda obtener(String id) {
        PreparedStatement stat = null;
        ResultSet rs = null;

        try {
            stat = connection.prepareStatement(GETONE);
            stat.setString(1, id);
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
    public void delete(Tienda object) {
        PreparedStatement stat = null;
        try {
            stat = connection.prepareStatement(DELETE);
            stat.setString(1, object.getCodigo());
            if (stat.executeUpdate() == 0) {

            }
        } catch (SQLException ex) {
            Logger.getLogger(TiendaD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Tienda convertir(ResultSet rs) {

        try {
            Tienda tienda = new Tienda(rs.getString("codigo"), rs.getString("nombre"), rs.getString("direccion"), rs.getString("telefono"), rs.getString("telefono2"), rs.getString("email"), rs.getString("horario"), rs.getBoolean("estado"));

            return tienda;
        } catch (SQLException ex) {
            Logger.getLogger(TiendaD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String lastInsertId() {
        String ultimo = "SELECT last_insert_id()";
        PreparedStatement stat = null;
        ResultSet rs = null;

        try {
            stat = connection.prepareStatement(ultimo);
            rs = stat.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TiendaD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
