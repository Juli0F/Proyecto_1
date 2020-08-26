package com.tienda.mysql;

import com.tienda.dao.FacturaDAO;
import com.tienda.dto.FacturaDto;
import com.tienda.entities.Factura;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FacturaD implements FacturaDAO {

    private Connection connection;
    private final String INSERT = "INSERT INTO Factura (descripcion,estado,Usuario_idUsuario,Tienda_codigo,nit,total, fecha) VALUES (?,?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE Factura SET descripcion = ?, estado = ?, Usuario_idUsuario = ?, Tienda_codigo = ?, nit = ?, total = ? , fecha = ? WHERE idFactura = ? ";
    private final String DELETE = "DELETE Factura WHERE idFactura = ? ";
    private final String GETALL = "SELECT * FROM  Factura  ";
    private final String GETONE = GETALL + "WHERE idFactura = ?";
    private final String DATA_REPORTE_CINCO = "select t.codigo,t.nombre, f.idFactura , f.total , date_format(f.fecha, '%d/%m/%Y') as dias "
            + "from Factura f "
            + "inner join Tienda t on f.Tienda_codigo = t.codigo "
            + "inner join Cliente c on f.nit = c.nit "
            + "inner join Persona per on c.Persona_dpi = per.dpi "
            + "where f.fecha "
            + "between ifnull(? , '2000-01-01') and ifnull(?, '3000-01-01') "
            + " AND (f.nit = ? ) ";

    public FacturaD(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Factura object) {
        PreparedStatement stat = null;;
        try {
            stat = connection.prepareStatement(INSERT);
            stat.setString(1, object.getDescripcion());
            stat.setBoolean(2, object.isEstado());
            stat.setInt(3, object.getUsuario_idUsuario());
            stat.setString(4, object.getTienda_codigo());
            stat.setString(5, object.getNit());
            stat.setBigDecimal(6, object.getTotal());
            stat.setDate(7, object.getDate());
            if (stat.executeUpdate() == 0) {
                System.out.println("crear popover Factura");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modify(Factura object) {
        PreparedStatement stat = null;;
        try {
            stat = connection.prepareStatement(UPDATE);
            stat.setString(1, object.getDescripcion());
            stat.setBoolean(2, object.isEstado());
            stat.setInt(3, object.getUsuario_idUsuario());
            stat.setString(4, object.getTienda_codigo());
            stat.setString(5, object.getNit());
            stat.setBigDecimal(6, object.getTotal());
            stat.setDate(7, object.getDate());
            stat.setInt(8, object.getIdFactura());
            if (stat.executeUpdate() == 0) {
                System.out.println("crear popover Factura");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Factura> obtenerTodo() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Factura> lst = new ArrayList<>();
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
    public Factura obtener(Integer id) {
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
    public void delete(Factura object) {
        PreparedStatement stat = null;
        try {
            stat = connection.prepareStatement(DELETE);
            stat.setInt(1, object.getIdFactura());
            if (stat.executeUpdate() == 0) {

            }
        } catch (SQLException ex) {
            Logger.getLogger(FacturaD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Factura convertir(ResultSet rs) {

        try {
            Factura factura = new Factura(rs.getInt("idFactura"), rs.getString("descripcion"), rs.getBoolean("estado"), rs.getInt("Usuario_idUsuario"), rs.getString("Tienda_codigo"), rs.getString("nit"), rs.getBigDecimal("total"), rs.getDate("fecha"));

            return factura;
        } catch (SQLException ex) {
            Logger.getLogger(FacturaD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(FacturaD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public List<FacturaDto> reporteCinco(String nitCliente, String codigoTienda, Date dateInit, Date dateFinal) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<FacturaDto> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(DATA_REPORTE_CINCO);
            stat.setDate(1, dateInit);
            stat.setDate(2, dateFinal);
            
            stat.setString(3, nitCliente);
            rs = stat.executeQuery();
            while (rs.next()) {
                lst.add(convertirFDTO(rs));
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public FacturaDto convertirFDTO(ResultSet rs) {

        try {
            return new FacturaDto(rs.getString("idFactura"), rs.getString("nombre"), rs.getString("codigo"), rs.getString("dias"), rs.getString("total"));

        } catch (SQLException ex) {
            Logger.getLogger(FacturaD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
