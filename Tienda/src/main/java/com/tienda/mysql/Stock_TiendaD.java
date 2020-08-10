package com.tienda.mysql;

import com.tienda.dao.Stock_TiendaDAO;
import com.tienda.entities.Stock_Tienda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Stock_TiendaD implements Stock_TiendaDAO {

    private Connection connection;
    private final String INSERT = "INSERT INTO Stock_Tienda (tienda_codigo,producto_codigo,estado,cantidad,) VALUES (?,?,?,?)";
    private final String UPDATE = "UPDATE Stock_Tienda set tienda_codigo = ?, set producto_codigo = ?, set estado = ?, set cantidad = ? WHERE idStockTienda = ? ";
    private final String DELETE = "DELETE Stock_Tienda WHERE idStockTienda = ? ";
    private final String GETALL = "SELECT * FROM  Stock_Tienda  ";
    private final String GETONE = GETALL + "WHERE idStockTienda = ?";

    public Stock_TiendaD(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Stock_Tienda object) {
        PreparedStatement stat = null;;
        try {
            stat = connection.prepareStatement(INSERT);
            stat.setString(1, object.getTienda_codigo());
            stat.setString(2, object.getProducto_codigo());
            stat.setBoolean(3, object.isEstado());
            stat.setString(4, object.getCantidad());
            if (stat.executeUpdate() == 0) {
                System.out.println("crear popover Stock_Tienda");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modify(Stock_Tienda object) {
        PreparedStatement stat = null;;
        try {
            stat = connection.prepareStatement(UPDATE);
            stat.setString(1, object.getTienda_codigo());
            stat.setString(2, object.getProducto_codigo());
            stat.setBoolean(3, object.isEstado());
            stat.setString(4, object.getCantidad());
            stat.setInt(5, object.getIdStockTienda());
            if (stat.executeUpdate() == 0) {
                System.out.println("crear popover Stock_Tienda");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Stock_Tienda> obtenerTodo() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Stock_Tienda> lst = new ArrayList<>();
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
    public Stock_Tienda obtener(Integer id) {
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
    public void delete(Stock_Tienda object) {
        PreparedStatement stat = null;
        try {
            stat = connection.prepareStatement(DELETE);
            stat.setInt(1, object.getIdStockTienda());
            if (stat.executeUpdate() == 0) {

            }
        } catch (SQLException ex) {
            Logger.getLogger(Stock_TiendaD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Stock_Tienda convertir(ResultSet rs) {

        try {
            Stock_Tienda stock_Tienda = new Stock_Tienda(rs.getInt("idStockTienda"), rs.getString("tienda_codigo"), rs.getString("producto_codigo"), rs.getBoolean("estado"), rs.getString("cantidad"));

            return stock_Tienda;
        } catch (SQLException ex) {
            Logger.getLogger(Stock_TiendaD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Stock_TiendaD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
