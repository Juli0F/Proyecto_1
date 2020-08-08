package com.tienda.mysql;

import com.tienda.dao.ClienteDAO;
import com.tienda.entities.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteD implements ClienteDAO {

    private Connection connection;
    private final String INSERT = "INSERT INTO Cliente (email,estado,Pedido_codigo,Persona_dpi) VALUES (?,?,?,?)";
    private final String UPDATE = "UPDATE Cliente set email = ?, set estado = ?, set Pedido_codigo = ?, set Persona_dpi = ? WHERE nit = ? ";
    private final String DELETE = "DELETE Cliente WHERE nit = ? ";
    private final String GETALL = "SELECT * FROM  Cliente  ";
    private final String GETONE = GETALL + "WHERE nit = ?";

    public ClienteD(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Cliente object) {
        PreparedStatement stat = null;;
        try {
            stat = connection.prepareStatement(INSERT);
            stat.setString(1, object.getEmail());
            stat.setBoolean(2, object.isEstado());
            stat.setString(3, object.getPedido_codigo());
            stat.setInt(4, object.getPersona_dpi());
            if (stat.executeUpdate() == 0) {
                System.out.println("crear popover Cliente");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modify(Cliente object) {
        PreparedStatement stat = null;;
        try {
            stat = connection.prepareStatement(UPDATE);
            stat.setString(1, object.getEmail());
            stat.setBoolean(2, object.isEstado());
            stat.setString(3, object.getPedido_codigo());
            stat.setInt(4, object.getPersona_dpi());
            stat.setString(5, object.getNit());
            if (stat.executeUpdate() == 0) {
                System.out.println("crear popover Cliente");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cliente> obtenerTodo() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Cliente> lst = new ArrayList<>();
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
    public Cliente obtener(Integer id) {
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
    public void delete(Cliente object) {
        PreparedStatement stat = null;
        try {
            stat = connection.prepareStatement(DELETE);
            stat.setString(1, object.getNit());
            if (stat.executeUpdate() == 0) {

            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Cliente convertir(ResultSet rs) {

        try {
            Cliente cliente = new Cliente(rs.getString("nit"), rs.getString("email"), rs.getBoolean("estado"), rs.getString("Pedido_codigo"), rs.getInt("Persona_dpi"));

            return cliente;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ClienteD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
