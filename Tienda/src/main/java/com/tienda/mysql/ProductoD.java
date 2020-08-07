package com.tienda.mysql;

import com.tienda.dao.ProductoDAO;
import com.tienda.entities.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductoD implements ProductoDAO {

    private Connection connection;
    private final String INSERT = "INSERT INTO Producto (nombre,fabricante,Descripcion,Garantia,estado,) VALUES (?,?,?,?,?)";
    private final String UPDATE = "UPDATE Producto set nombre = ?, set fabricante = ?, set Descripcion = ?, set Garantia = ?, set estado = ? WHERE codigo = ? ";
    private final String DELETE = "DELETE Producto WHERE codigo = ? ";
    private final String GETALL = "SELECT * FROM  Producto  ";
    private final String GETONE = GETALL + "WHERE codigo = ?";

    public ProductoD(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Producto object) {
        PreparedStatement stat = null;;
        try {
            stat = connection.prepareStatement(INSERT);
            stat.setString(1, object.getNombre());
            stat.setString(2, object.getFabricante());
            stat.setString(3, object.getDescripcion());
            stat.setInt(4, object.getGarantia());
            stat.setBoolean(5, object.isEstado());
            if (stat.executeUpdate() == 0) {
                System.out.println("crear popover Producto");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modify(Producto object) {
        PreparedStatement stat = null;;
        try {
            stat = connection.prepareStatement(UPDATE);
            stat.setString(1, object.getNombre());
            stat.setString(2, object.getFabricante());
            stat.setString(3, object.getDescripcion());
            stat.setInt(4, object.getGarantia());
            stat.setBoolean(5, object.isEstado());
            stat.setString(6, object.getCodigo());
            if (stat.executeUpdate() == 0) {
                System.out.println("crear popover Producto");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Producto> obtenerTodo() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Producto> lst = new ArrayList<>();
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
    public Producto obtener(Integer id) {
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
    public void delete(Producto object) {
        PreparedStatement stat = null;
        try {
            stat = connection.prepareStatement(DELETE);
            stat.setString(1, object.getCodigo());
            if (stat.executeUpdate() == 0) {

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Producto convertir(ResultSet rs) {

        try {
            Producto producto = new Producto(rs.getString("codigo"), rs.getString("nombre"), rs.getString("fabricante"), rs.getString("Descripcion"), rs.getInt("Garantia"), rs.getBoolean("estado"));

            return producto;
        } catch (SQLException ex) {
            Logger.getLogger(ProductoD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProductoD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
