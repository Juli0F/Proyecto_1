package com.tienda.mysql;

import com.tienda.dao.TiempoDeEnvioDAO;
import com.tienda.entities.TiempoDeEnvio;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TiempoDeEnvioD implements TiempoDeEnvioDAO {

    private Connection connection;
    private final String INSERT = "INSERT INTO TiempoDeEnvio (tiempo,estado,descripcion) VALUES (?,?,?)";
    private final String UPDATE = "UPDATE TiempoDeEnvio SET tiempo = ?, estado = ?, SET descripcion = ? WHERE idTiempoDeEnvio = ? ";
    private final String DELETE = "DELETE TiempoDeEnvio WHERE idTiempoDeEnvio = ? ";
    private final String GETALL = "SELECT * FROM  TiempoDeEnvio  ";
    private final String GET_ONE = GETALL + "WHERE idTiempoDeEnvio = ?";
    private final String GETBYIDTIENDAANDDESCRIPCION = GETALL + " WHERE origen = ? AND  descripcion = ?";
    private final String GET_TIEMPO_ENTRE_TIENDAA_AND_TIENDAB = "SELECT * FROM TiempoDeEnvio T WHERE T.idTiempoDeEnvio IN (SELECT tet.TiempoDeEnvio_idTiempoDeEnvio FROM TiempoEntreTiendas tet inner join TiempoEntreTiendas auxTet on tet.TiempoDeEnvio_idTiempoDeEnvio = auxTet.TiempoDeEnvio_idTiempoDeEnvio where tet.Tienda_codigo = ? AND auxTet.Tienda_codigo= ?)";

    public TiempoDeEnvioD(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(TiempoDeEnvio object) {
        PreparedStatement stat = null;;
        try {
            stat = connection.prepareStatement(INSERT);
            stat.setInt(1, object.getTiempo());
            stat.setBoolean(2, object.isEstado());
            stat.setString(3, object.getDescripcion());

            if (stat.executeUpdate() == 0) {
                System.out.println("crear popover TiempoDeEnvio");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modify(TiempoDeEnvio object) {
        PreparedStatement stat = null;;
        try {
            stat = connection.prepareStatement(UPDATE);

            stat.setInt(1, object.getTiempo());
            stat.setBoolean(2, object.isEstado());
            stat.setString(3, object.getDescripcion());

            stat.setInt(5, object.getIdTiempoDeEnvio());
            if (stat.executeUpdate() == 0) {
                System.out.println("crear popover TiempoDeEnvio");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TiempoDeEnvio> obtenerTodo() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<TiempoDeEnvio> lst = new ArrayList<>();
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
    public TiempoDeEnvio obtener(Integer id) {
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
    public void delete(TiempoDeEnvio object) {
        PreparedStatement stat = null;
        try {
            stat = connection.prepareStatement(DELETE);
            stat.setInt(1, object.getIdTiempoDeEnvio());
            if (stat.executeUpdate() == 0) {

            }
        } catch (SQLException ex) {
            Logger.getLogger(TiempoDeEnvioD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public TiempoDeEnvio convertir(ResultSet rs) {

        try {
            TiempoDeEnvio tiempoDeEnvio = new TiempoDeEnvio(rs.getInt("idTiempoDeEnvio"), rs.getInt("tiempo"), rs.getBoolean("estado"), rs.getString("descripcion"));

            return tiempoDeEnvio;
        } catch (SQLException ex) {
            Logger.getLogger(TiempoDeEnvioD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TiempoDeEnvioD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public TiempoDeEnvio getTiempoUsandoTiendaAAndTiendaB(String codeTiendaA, String codeTiendaB) {
    
         PreparedStatement stat = null;
        ResultSet rs = null;

        try {
            stat = connection.prepareStatement(GET_TIEMPO_ENTRE_TIENDAA_AND_TIENDAB);
            stat.setString(1, codeTiendaA);
            stat.setString(2, codeTiendaB);
            
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
    public int datediff(Date diaPedido, Date diaEntrega) {
     String dia = "SELECT datediff(?,?)";
        PreparedStatement stat = null;
        ResultSet rs = null;

        try {
            stat = connection.prepareStatement(dia);
            stat.setDate(1, diaEntrega);
            stat.setDate(2, diaPedido);
            rs = stat.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TiempoDeEnvioD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;   
    }

    
}
