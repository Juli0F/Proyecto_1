package com.tienda.mysql;

import com.tienda.dao.DetalleFacturaDAO;
import com.tienda.entities.DetalleFactura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DetalleFacturaD implements DetalleFacturaDAO {

    private Connection connection;
    private final String INSERT = "INSERT INTO DetalleFactura (Factura_idFactura,Producto_codigo) VALUES (?,?)";
    private final String UPDATE = "UPDATE DetalleFactura setFactura_idFactura = ?, Producto_codigo = ? WHERE idDetalleFactura = ? ";
    private final String DELETE = "DELETE DetalleFactura WHERE idDetalleFactura = ? ";
    private final String GETALL = "SELECT * FROM  DetalleFactura  ";
    private final String GETONE = GETALL + "WHERE idDetalleFactura = ?";

    public DetalleFacturaD(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(DetalleFactura object) {
        PreparedStatement stat = null;;
        try {
            stat = connection.prepareStatement(INSERT);
            stat.setInt(1, object.getFactura_idFactura());
            stat.setString(2, object.getProducto_codigo());
            if (stat.executeUpdate() == 0) {
                System.out.println("crear popover DetalleFactura");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modify(DetalleFactura object) {
        PreparedStatement stat = null;;
        try {
            stat = connection.prepareStatement(UPDATE);
            stat.setInt(1, object.getFactura_idFactura());
            stat.setString(2, object.getProducto_codigo());
            stat.setInt(3, object.getIdDetalleFactura());
            if (stat.executeUpdate() == 0) {
                System.out.println("crear popover DetalleFactura");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<DetalleFactura> obtenerTodo() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<DetalleFactura> lst = new ArrayList<>();
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
    public DetalleFactura obtener(Integer id) {
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
    public void delete(DetalleFactura object) {
        PreparedStatement stat = null;
        try {
            stat = connection.prepareStatement(DELETE);
            stat.setInt(1, object.getIdDetalleFactura());
            if (stat.executeUpdate() == 0) {

            }
        } catch (SQLException ex) {
            Logger.getLogger(DetalleFacturaD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DetalleFactura convertir(ResultSet rs) {

        try {
            DetalleFactura detalleFactura = new DetalleFactura(rs.getInt("idDetalleFactura"), rs.getInt("Factura_idFactura"), rs.getString("Producto_codigo"));

            return detalleFactura;
        } catch (SQLException ex) {
            Logger.getLogger(DetalleFacturaD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DetalleFacturaD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
