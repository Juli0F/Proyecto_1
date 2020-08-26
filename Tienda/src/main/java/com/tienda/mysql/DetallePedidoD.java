package com.tienda.mysql;

import com.tienda.dao.DetallePedidoDAO;
import com.tienda.dto.DetallePedidoProducto;
import com.tienda.entities.DetallePedido;
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
    private final String INSERT = "INSERT INTO DetallePedido (cantidad,estado,Producto_codigo,Pedido_codigo) VALUES (?,?,?,?)";
    private final String UPDATE = "UPDATE DetallePedido SET cantidad = ?, estado = ?, Producto_codigo = ?, Pedido_codigo = ? WHERE idDetallePedido = ? ";
    private final String DELETE = "DELETE DetallePedido WHERE idDetallePedido = ? ";
    private final String GET_ALL = "SELECT * FROM  DetallePedido  ";
    private final String GET_ONE = GET_ALL + "WHERE idDetallePedido = ?";
    private final String GET_DETALLE_POR_CODIGO_DE_PRODUCTO = GET_ALL+" WHERE idDetallePedido = ?";
    private final String GET_CODIGO_PRODUTO_CANTIDAD = "SELECT p.codigo codigo, p.nombre producto, dp.cantidad "
            + "FROM Producto p "
            + "INNER JOIN DetallePedido dp ON dp.Producto_codigo = p.codigo "
            + "WHERE  dp.Pedido_codigo = ? ";

    public DetallePedidoD(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(DetallePedido object) {
        PreparedStatement stat = null;;
        try {
            stat = connection.prepareStatement(INSERT);
            stat.setInt(1, object.getCantidad());
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
            stat.setInt(1, object.getCantidad());
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
            stat = connection.prepareStatement(GET_ALL);
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
            stat = connection.prepareStatement(GET_ONE);
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
            DetallePedido detallePedido = new DetallePedido(rs.getInt("idDetallePedido"), rs.getInt("cantidad"), rs.getBoolean("estado"), rs.getString("Producto_codigo"), rs.getString("Pedido_codigo"));

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

    @Override
    public List<DetallePedido> obtenerDetallePorCodigoDePedido(String codigoPedido) {
         PreparedStatement stat = null;
        ResultSet rs = null;
        List<DetallePedido> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(GET_DETALLE_POR_CODIGO_DE_PRODUCTO);
            stat.setString(1, codigoPedido);
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
    public List<DetallePedidoProducto> getCodigoProductoCantidad(String codigoPedido){
         PreparedStatement stat = null;
        ResultSet rs = null;
        List<DetallePedidoProducto> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(GET_CODIGO_PRODUTO_CANTIDAD);
            stat.setString(1, codigoPedido);
            rs = stat.executeQuery();
            while (rs.next()) {
                lst.add(convertirDetalleProducto(rs));
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }

        
     return null;   
    }
    
    public DetallePedidoProducto convertirDetalleProducto(ResultSet rs) {

        try {
            DetallePedidoProducto detallePedidoProducto = new DetallePedidoProducto(rs.getString("codigo"), rs.getString("producto"), rs.getInt("cantidad"));

            return detallePedidoProducto;
        } catch (SQLException ex) {
            Logger.getLogger(DetallePedidoD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
