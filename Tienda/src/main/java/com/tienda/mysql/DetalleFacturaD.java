package com.tienda.mysql;

import com.tienda.dao.DetalleFacturaDAO;
import com.tienda.dto.DetallePedidoProducto;
import com.tienda.entities.DetalleFactura;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DetalleFacturaD implements DetalleFacturaDAO {

    private Connection connection;
    private final String INSERT = "INSERT INTO DetalleFactura (Factura_idFactura,Producto_codigo,cantidad,subtotal) VALUES (?,?,?,?)";
    private final String UPDATE = "UPDATE DetalleFactura setFactura_idFactura = ?, Producto_codigo = ? ,cantidad =?, subtotal = ? WHERE idDetalleFactura = ? ";
    private final String DELETE = "DELETE DetalleFactura WHERE idDetalleFactura = ? ";
    private final String GETALL = "SELECT * FROM  DetalleFactura  ";
    private final String GETONE = GETALL + "WHERE idDetalleFactura = ?";
    private final String GET_CODIGO_PRODUCTO_CANTIDAD = "SELECT p.codigo codigo, p.nombre producto, dp.cantidad "
            + "FROM Producto p "
            + "INNER JOIN DetalleFactura dp ON dp.Producto_codigo = p.codigo "
            + "WHERE  dp.Factura_idFactura = ?";

    private final String REPORTE_SIETE = "SELECT p.codigo, p.nombre as producto, sum( st.cantidad) as cantidad "
            + "from Producto p "
            + "inner join DetalleFactura st on p.codigo = st.Producto_codigo "
            + "inner join Factura f on f.idFactura = st.Factura_idFactura "
            + "where f.fecha between  ifnull(?,'2010-01-01') and  ifnull(?,sysdate()) group by p.codigo  order by  cantidad desc limit 10 ";
    
    
    private final String REPORTE_OCHO = "SELECT p.codigo, p.nombre as producto, sum( st.cantidad) as cantidad "
            + "from Producto p "
            + "inner join DetalleFactura st on p.codigo = st.Producto_codigo "
            + "inner join Factura f on f.idFactura = st.Factura_idFactura "
            + "where f.Tienda_codigo = ?  "
            + " and f.fecha between  ifnull(?,'2010-01-01') and  ifnull(?,sysdate()) group by p.codigo  order by  cantidad desc limit 10 ";
    
    
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
            stat.setInt(3, object.getCantidad());
            stat.setBigDecimal(4, object.getSubtotal());
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
            stat.setInt(3, object.getCantidad());
            stat.setBigDecimal(4, object.getSubtotal());
            stat.setInt(5, object.getIdDetalleFactura());
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
            DetalleFactura detalleFactura =
                    new DetalleFactura(rs.getInt("idDetalleFactura"), 
                                       rs.getInt("Factura_idFactura"),
                                       rs.getString("Producto_codigo"), 
                                       rs.getInt("cantidad"),
                                       rs.getBigDecimal("subtotal"));

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
    
    public List<DetallePedidoProducto> getCodigoProductoCantidad(String idFactura){
         PreparedStatement stat = null;
        ResultSet rs = null;
        System.out.println("String IdFactura"+idFactura);
        List<DetallePedidoProducto> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(GET_CODIGO_PRODUCTO_CANTIDAD);
            stat.setString(1, idFactura);
          
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
            System.out.println("Convertir detalle Producto "+ detallePedidoProducto.getCodigo());
            return detallePedidoProducto;
        } catch (SQLException ex) {
            Logger.getLogger(DetallePedidoD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<DetallePedidoProducto> reporteSiete(Date dateInit, Date dateFinal) {
            
         PreparedStatement stat = null;
        ResultSet rs = null;
        List<DetallePedidoProducto> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(REPORTE_SIETE);
            stat.setDate(1, dateInit);
            stat.setDate(2, dateFinal);
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
    
    
    @Override
    public List<DetallePedidoProducto> reporteOcho(String tienda, Date dateInit, Date dateFinal) {
            
         PreparedStatement stat = null;
        ResultSet rs = null;
        List<DetallePedidoProducto> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(REPORTE_OCHO);
            stat.setString(1, tienda);
            stat.setDate(2, dateInit);
            stat.setDate(3, dateFinal);
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
    

}
