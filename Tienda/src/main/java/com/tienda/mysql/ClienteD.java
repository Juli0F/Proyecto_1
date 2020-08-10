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
    private final String INSERT = "INSERT INTO Cliente (email,estado,Persona_dpi,credito,nit) VALUES (?,?,?,?,?)";
    private final String UPDATE = "UPDATE Cliente set email = ?,  estado = ?, Persona_dpi = ? WHERE nit = ? ";
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
            stat.setString(3, object.getPersona_dpi());
            stat.setBigDecimal(4, object.getCredito());
            stat.setString(5, object.getNit());
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
            stat.setString(3, object.getPersona_dpi());
            stat.setString(4, object.getNit());
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
    public Cliente obtener(String nit) {
        PreparedStatement stat = null;
        ResultSet rs = null;

        try {
            stat = connection.prepareStatement(GETONE);
            stat.setString(1, nit);
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
            Cliente cliente = new Cliente(rs.getString("nit"), rs.getString("email"), rs.getBoolean("estado"), rs.getString("Persona_dpi"),rs.getBigDecimal("credito"));

            return cliente;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ClienteD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
