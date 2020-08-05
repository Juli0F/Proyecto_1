package com.tienda.mysql;

import com.tienda.dao.*;
import Entities.DetallePedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DetallePedidoD implements DetallePedidoDAO {

    private Connection connection;
    private final String INSERT = "INSERT INTO DetallePedido (cantidad,estado,Producto_codigo,Pedido_codigo,) VALUES (?,?,?,?)";
    private final String UPDATE = "UPDATE DetallePedido set cantidad = ?, set estado = ?, set Producto_codigo = ?, set Pedido_codigo = ? WHERE idDetallePedido = ? ";
    private final String DELETE = "DELETE DetallePedido WHERE idDetallePedido = ? ";
    private final String GETALL = "SELECT * FROM  DetallePedido  ";
    private final String GETONE = GETALL + "WHERE idDetallePedido = ?";

    public DetallePedidoD(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(DetallePedido object) {
        PreparedStatement stat = null;;
        try {
            stat = connection.prepareStatement(INSERT);
            stat.setString(1, object.getCantidad());
            stat.setBoolean(2, object.isEstado());
            stat.setString(3, object.getProducto_codigo());
            stat.setString(4, object.getPedido_codigo());
            if (stat.executeUpdate() == 0) {
                System.out.println("crear popover DetallePedido");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modify(DetallePedido object) {
        PreparedStatement stat = null;;
        try {
            stat = connection.prepareStatement(UPDATE);
            stat.setString(1, object.getCantidad());
            stat.setBoolean(2, object.isEstado());
            stat.setString(3, object.getProducto_codigo());
            stat.setString(4, object.getPedido_codigo());
            stat.setInt(5, object.getIdDetallePedido());
            if (stat.executeUpdate() == 0) {
                System.out.println("crear popover DetallePedido");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<DetallePedido> obtenerTodo() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<DetallePedido> lst = new ArrayList<>();
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
    public DetallePedido obtener(Integer id) {
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
    public void delete(DetallePedido object) {
        PreparedStatement stat = null;
        try {
            stat = connection.prepareStatement(DELETE);
            stat.setInt(1, object.getIdDetallePedido());
            if (stat.executeUpdate() == 0) {

            }
        } catch (SQLException ex) {
            Logger.getLogger(DetallePedidoD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DetallePedido convertir(ResultSet rs) {

        try {
            DetallePedido detallePedido = new DetallePedido(rs.getInt("idDetallePedido"), rs.getString("cantidad"), rs.getBoolean("estado"), rs.getString("Producto_codigo"), rs.getString("Pedido_codigo"));

            return detallePedido;
        } catch (SQLException ex) {
            Logger.getLogger(DetallePedidoD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DetallePedidoD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
