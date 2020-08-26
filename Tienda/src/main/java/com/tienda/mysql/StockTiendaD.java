package com.tienda.mysql;

import com.tienda.dao.StockTiendaDAO;
import com.tienda.dto.CatalogoDto;
import com.tienda.entities.StockTienda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StockTiendaD implements StockTiendaDAO {

    private Connection connection;
    private final String INSERT = "INSERT INTO StockTienda (Tienda_codigo,Producto_codigo,estado,cantidad,precio) VALUES (?,?,?,?,?)";
    private final String UPDATE = "UPDATE StockTienda SET Tienda_codigo = ?, Producto_codigo = ?, estado = ?, cantidad = ? WHERE idStockTienda = ? ";
    private final String DELETE = "DELETE StockTienda WHERE idStockTienda = ? ";
    private final String GETALL = "SELECT * FROM  StockTienda  ";
    private final String GETONE = GETALL + "WHERE idStockTienda = ?";
    private final String GETSTOCKBYIDTIENDAANDPRODUCTO = GETALL + "WHERE Tienda_codigo = ? AND  Producto_codigo = ?";
    private final String GETALLPRODUCTINSTORE = GETALL + "WHERE Tienda_codigo = ? AND estado = 1";
    private final String CATALOGO_SIN_PARAMETRO = "select t.nombre as tienda , p.codigo, p.nombre, st.precio from StockTienda st inner join Tienda t on st.Tienda_codigo = t.codigo inner join Producto p on p.codigo = st.Producto_codigo where t.codigo in (select x.codigo from Tienda x )";

    private final String CATALOGO_CON_PARAMETRO_PRODUCTO = "select t.nombre as tienda , p.codigo, p.nombre, st.precio from StockTienda st inner join Tienda t on st.Tienda_codigo = t.codigo inner join Producto p on p.codigo = st.Producto_codigo where p.codigo like ? or p.nombre like ? ";
    private final String CATALOGO_CON_PARAMETRO_TIENDA = "select t.nombre as tienda , p.codigo, p.nombre, st.precio from StockTienda st inner join Tienda t on st.Tienda_codigo = t.codigo inner join Producto p on p.codigo = st.Producto_codigo where t.codigo = ?";
    private final String CATALOGO_CON_PARAMETRO_TIENDA_PRODUCTO = "select t.nombre as tienda , p.codigo, p.nombre, st.precio from StockTienda st inner join Tienda t on st.Tienda_codigo = t.codigo inner join Producto p on p.codigo = st.Producto_codigo where t.codigo = ? and (p.codigo like ? or p.nombre like ? )";
   //and (p.codigo like "%O%" or p.nombre like "%O%" )
    public StockTiendaD(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(StockTienda object) {
        PreparedStatement stat = null;;
        try {
            stat = connection.prepareStatement(INSERT);
            stat.setString(1, object.getTienda_codigo());
            stat.setString(2, object.getProducto_codigo());
            stat.setBoolean(3, object.isEstado());
            stat.setInt(4, object.getCantidad());
            stat.setBigDecimal(5, object.getPrecio());
            if (stat.executeUpdate() == 0) {
                System.out.println("crear popover StockTienda");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modify(StockTienda object) {
        PreparedStatement stat = null;;
        try {
            stat = connection.prepareStatement(UPDATE);
            stat.setString(1, object.getTienda_codigo());
            stat.setString(2, object.getProducto_codigo());
            stat.setBoolean(3, object.isEstado());
            stat.setInt(4, object.getCantidad());
            stat.setInt(5, object.getIdStockTienda());
            if (stat.executeUpdate() == 0) {
                System.out.println("crear popover StockTienda");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<StockTienda> obtenerTodo() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<StockTienda> lst = new ArrayList<>();
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
    public StockTienda obtener(Integer id) {
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
    public void delete(StockTienda object) {
        PreparedStatement stat = null;
        try {
            stat = connection.prepareStatement(DELETE);
            stat.setInt(1, object.getIdStockTienda());
            if (stat.executeUpdate() == 0) {

            }
        } catch (SQLException ex) {
            Logger.getLogger(StockTiendaD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public StockTienda convertir(ResultSet rs) {

        try {
            StockTienda stockTienda = new StockTienda(rs.getInt("idStockTienda"), rs.getString("Tienda_codigo"), rs.getString("Producto_codigo"), rs.getBoolean("estado"), rs.getInt("cantidad"), rs.getBigDecimal("precio"));

            return stockTienda;
        } catch (SQLException ex) {
            Logger.getLogger(StockTiendaD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(StockTiendaD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public StockTienda existencia(String codigoTienda, String codigoProducto) {

        PreparedStatement stat = null;
        ResultSet rs = null;

        try {
            stat = connection.prepareStatement(GETSTOCKBYIDTIENDAANDPRODUCTO);
            stat.setString(1, codigoTienda);
            stat.setString(2, codigoProducto);
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
    public List<StockTienda> productosEnUnaTienda(String codigoTienda) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<StockTienda> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(GETALLPRODUCTINSTORE);
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

    @Override
    public List<CatalogoDto> catalogo() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<CatalogoDto> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(CATALOGO_SIN_PARAMETRO);

            rs = stat.executeQuery();
            while (rs.next()) {
                lst.add(convertirCatalogo(rs));
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    @Override
    public List<CatalogoDto> catalogoEnTienda(String codigoTienda) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<CatalogoDto> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(CATALOGO_CON_PARAMETRO_TIENDA);
            stat.setString(1, codigoTienda);
            rs = stat.executeQuery();
            while (rs.next()) {
                lst.add(convertirCatalogo(rs));
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    @Override
    public List<CatalogoDto> catalogoEnTiendaProducto(String codigoTienda, String match) {
         PreparedStatement stat = null;
        ResultSet rs = null;
        List<CatalogoDto> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(CATALOGO_CON_PARAMETRO_TIENDA_PRODUCTO);
            stat.setString(1, codigoTienda);
            stat.setString(2, "%"+match+"%");
            stat.setString(3, "%"+match+"%");
            rs = stat.executeQuery();
            while (rs.next()) {
                lst.add(convertirCatalogo(rs));
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    @Override
    public List<CatalogoDto> catalogoProducto(String match) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<CatalogoDto> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(CATALOGO_CON_PARAMETRO_PRODUCTO);
            
            stat.setString(1, "%"+match+"%");
            stat.setString(2, "%"+match+"%");
            rs = stat.executeQuery();
            while (rs.next()) {
                lst.add(convertirCatalogo(rs));
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
    
    

    public CatalogoDto convertirCatalogo(ResultSet rs) {

        try {
            return new CatalogoDto(rs.getString("tienda"), rs.getString("codigo"), rs.getString("nombre"), rs.getString("precio"));

        } catch (SQLException ex) {
            Logger.getLogger(StockTiendaD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
