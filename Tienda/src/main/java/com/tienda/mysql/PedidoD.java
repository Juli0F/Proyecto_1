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
    private final String INSERT = "INSERT INTO Pedido (fecha,entregado,retraso,destino,estado,TiempoDeEnvio_idTiempoDeEnvio,Cliente_nit,subtotal,anticipo,codigo,Tienda_codigo) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE Pedido SET fecha = ?, entregado = ?, retraso = ?, destino = ?, estado = ?, TiempoDeEnvio_idTiempoDeEnvio = ?, Cliente_nit = ? WHERE codigo = ? ";
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
            stat.setString(7, object.getCliente_nit());
            stat.setBigDecimal(8, object.getSubtotal());
            stat.setBigDecimal(9, object.getAnticipo());
            stat.setString(10, object.getCodigo());
            stat.setString(11, object.getCodigoDestino());
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
            stat.setString(7, object.getCliente_nit());
            stat.setString(8, object.getCodigo());
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
    public Pedido obtener(String id) {
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
            Pedido pedido = new Pedido(rs.getString("codigo"), rs.getDate("fecha"), rs.getBoolean("entregado"), rs.getInt("retraso"), rs.getBoolean("destino"), rs.getBoolean("estado"), rs.getInt("TiempoDeEnvio_idTiempoDeEnvio"), rs.getString("Cliente_nit"), rs.getBigDecimal("anticipo"),rs.getBigDecimal("subtotal"),rs.getString("Tienda_codigo"));

            return pedido;
        } catch (SQLException ex) {
            Logger.getLogger(PedidoD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PedidoD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    @Override
    public List<Pedido> sinEntregarEnDestino() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Pedido> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(GETALL + " WHERE destino = 0");
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
    public List<Pedido> buscarCoincidenciaSinEntregarEnDestino(String matchParameter) {
       PreparedStatement stat = null;
        ResultSet rs = null;
        List<Pedido> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(GETALL +" WHERE (Cliente_nit  LIKE ? OR  codigo LIKE ?) AND  destino = 0 ");
            stat.setString(1, "%"+matchParameter+"%");
            stat.setString(2, "%"+matchParameter+"%");
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
    public List<Pedido> buscarCoincidenciaPedidosEntregadosEnTiendaDestino(String matchParameter) {
       PreparedStatement stat = null;
        ResultSet rs = null;
        List<Pedido> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(GETALL +" WHERE (Cliente_nit  LIKE ? OR  codigo LIKE ?) AND  destino = 1 ");
            stat.setString(1, "%"+matchParameter+"%");
            stat.setString(2, "%"+matchParameter+"%");
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
     public List<Pedido> paraRecogerSeEncuentraEnDestino() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Pedido> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(GETALL + " WHERE destino = 1 AND entregado = 0");
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
}
