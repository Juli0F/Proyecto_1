package com.tienda.mysql;

import com.tienda.dao.ProductoDAO;
import com.tienda.dto.ProductoTableDto;
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
    private final String INSERT = "INSERT INTO Producto (nombre,fabricante,Descripcion,Garantia,estado , codigo) VALUES (?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE Producto SET nombre = ?, fabricante = ?, Descripcion = ?, Garantia = ?, estado = ? WHERE codigo = ? ";
    private final String DELETE = "DELETE Producto WHERE codigo = ? ";
    private final String GET_ALL = "SELECT * FROM  Producto  ";
    private final String GETONE = GET_ALL + "WHERE codigo = ?";
    private final String GETBYPARAMETER = GET_ALL
            + "WHERE nombre LIKE ?"
            + "OR fabricante LIKE ?"
            + "OR Descripcion LIKE ?"
            + "OR codigo LIKE ? ";
    //
    private final String GETPRODUCTOTABLE = "SELECT p.codigo, p.nombre, s.cantidad, s.precio FROM  Producto p inner join StockTienda s on p.codigo = s.Producto_codigo WHERE p.estado = 1 and s.estado = 1 and s.Tienda_codigo = ?";

    private final String GET_PRODUCTOS_QUE_NO_ESTAN_EN_LA_TIENDA = "SELECT * FROM Producto p WHERE codigo not in (select st.Producto_codigo from StockTienda st inner join Tienda t ON st.Tienda_codigo=t.codigo where t.codigo = ?) ";

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
            stat.setString(6, object.getCodigo());

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
    public Producto obtener(String id) {
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
            Logger.getLogger(ProductoD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    @Override
    public List<Producto> getSearchWithLike(String parameterOfSearch) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Producto> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(GETBYPARAMETER);
            stat.setString(1, "%" + parameterOfSearch + "%");
            stat.setString(2, "%" + parameterOfSearch + "%");
            stat.setString(3, "%" + parameterOfSearch + "%");
            stat.setString(4, "%" + parameterOfSearch + "%");
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
    public List<ProductoTableDto> getProductoTableDto(String codigoTienda) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<ProductoTableDto> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(GETPRODUCTOTABLE);
            stat.setString(1, codigoTienda);
            rs = stat.executeQuery();
            while (rs.next()) {
                lst.add(convertProductoTable(rs));
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private ProductoTableDto convertProductoTable(ResultSet rs) {

        try {
            return new ProductoTableDto(rs.getString("codigo"), rs.getString("nombre"), rs.getInt("cantidad"), rs.getBigDecimal("precio"));

        } catch (SQLException ex) {
            Logger.getLogger(ProductoD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public List<Producto> getProductoQueNoEstanAsignadosEnTienda(String codigoTienda) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Producto> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(GET_PRODUCTOS_QUE_NO_ESTAN_EN_LA_TIENDA);
            stat.setString(1, codigoTienda);
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
