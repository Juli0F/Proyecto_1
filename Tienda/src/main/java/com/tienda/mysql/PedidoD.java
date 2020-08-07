package com.tienda.mysql;

import com.tienda.dao.PedidoDAO;
import com.tienda.entities.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PedidoD implements PedidoDAO {

    private Connection connection;
    private final String INSERT = "INSERT INTO Pedido (fecha,entregado,retraso,destino,estado,TiempoDeEnvio_idTiempoDeEnvio,) VALUES (?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE Pedido set fecha = ?, set entregado = ?, set retraso = ?, set destino = ?, set estado = ?, set TiempoDeEnvio_idTiempoDeEnvio = ? WHERE codigo = ? ";
    private final String DELETE = "DELETE Pedido WHERE codigo = ? ";
    private final String GETALL = "SELECT * FROM  Pedido  ";
    private final String GETONE = GETALL + "WHERE codigo = ?";

    public PedidoD(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Pedido object) {
        PreparedStatement stat = null;;
        try {
            stat = connection.prepareStatement(INSERT);
            stat.setDate(1, object.getFecha());
            stat.setBoolean(2, object.isEntregado());
            stat.setInt(3, object.getRetraso());
            stat.setBoolean(4, object.isDestino());
            stat.setBoolean(5, object.isEstado());
            stat.setInt(6, object.getTiempoDeEnvio_idTiempoDeEnvio());
            if (stat.executeUpdate() == 0) {
                System.out.println("crear popover Pedido");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modify(Pedido object) {
        PreparedStatement stat = null;;
        try {
            stat = connection.prepareStatement(UPDATE);
            stat.setDate(1, object.getFecha());
            stat.setBoolean(2, object.isEntregado());
            stat.setInt(3, object.getRetraso());
            stat.setBoolean(4, object.isDestino());
            stat.setBoolean(5, object.isEstado());
            stat.setInt(6, object.getTiempoDeEnvio_idTiempoDeEnvio());
            stat.setString(7, object.getCodigo());
            if (stat.executeUpdate() == 0) {
                System.out.println("crear popover Pedido");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pedido> obtenerTodo() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Pedido> lst = new ArrayList<>();
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
    public Pedido obtener(Integer id) {
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
    public void delete(Pedido object) {
        PreparedStatement stat = null;
        try {
            stat = connection.prepareStatement(DELETE);
            stat.setString(1, object.getCodigo());
            if (stat.executeUpdate() == 0) {

            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Pedido convertir(ResultSet rs) {

        try {
            Pedido pedido = new Pedido(rs.getString("codigo"), rs.getDate("fecha"), rs.getBoolean("entregado"), rs.getInt("retraso"), rs.getBoolean("destino"), rs.getBoolean("estado"), rs.getInt("TiempoDeEnvio_idTiempoDeEnvio"));

            return pedido;
        } catch (SQLException ex) {
            Logger.getLogger(PedidoD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PedidoD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
