package com.tienda.mysql;

import com.tienda.dao.TiempoEntreTiendasDAO;
import com.tienda.entities.TiempoEntreTiendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TiempoEntreTiendasD implements TiempoEntreTiendasDAO {

    private Connection connection;
    private final String INSERT = "INSERT INTO TiempoEntreTiendas (TiempoDeEnvio_idTiempoDeEnvio,Tienda_codigo, descripcion) VALUES (?,?,?)";
    private final String UPDATE = "UPDATE TiempoEntreTiendas set TiempoDeEnvio_idTiempoDeEnvio = ?, set Tienda_codigo = ? WHERE idTiempoEntreTiendas = ? ";
    private final String DELETE = "DELETE TiempoEntreTiendas WHERE idTiempoEntreTiendas = ? ";
    private final String GETALL = "SELECT * FROM  TiempoEntreTiendas  ";
    private final String GETONE = GETALL + "WHERE idTiempoEntreTiendas = ?";
    private final String GET_BY_CODIGO_TIENDA_AND_DESCRIPCION = GETALL + " WHERE Tienda_codigo = ? AND descripcion = ? ";
    private final String GETTIMEBETWEENSTOREs = GETALL;

    public TiempoEntreTiendasD(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(TiempoEntreTiendas object) {
        PreparedStatement stat = null;;
        try {
            stat = connection.prepareStatement(INSERT);
            stat.setInt(1, object.getTiempoDeEnvio_idTiempoDeEnvio());
            stat.setString(2, object.getTienda_codigo());
            stat.setString(3, object.getDescripcion());
            if (stat.executeUpdate() == 0) {
                System.out.println("crear popover TiempoEntreTiendas");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modify(TiempoEntreTiendas object) {
        PreparedStatement stat = null;;
        try {
            stat = connection.prepareStatement(UPDATE);
            stat.setInt(1, object.getTiempoDeEnvio_idTiempoDeEnvio());
            stat.setString(2, object.getTienda_codigo());
            stat.setInt(3, object.getIdTiempoEntreTiendas());
            if (stat.executeUpdate() == 0) {
                System.out.println("crear popover TiempoEntreTiendas");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TiempoEntreTiendas> obtenerTodo() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<TiempoEntreTiendas> lst = new ArrayList<>();
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
    public TiempoEntreTiendas obtener(Integer id) {
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
    public void delete(TiempoEntreTiendas object) {
        PreparedStatement stat = null;
        try {
            stat = connection.prepareStatement(DELETE);
            stat.setInt(1, object.getIdTiempoEntreTiendas());
            if (stat.executeUpdate() == 0) {

            }
        } catch (SQLException ex) {
            Logger.getLogger(TiempoEntreTiendasD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public TiempoEntreTiendas convertir(ResultSet rs) {

        try {
            TiempoEntreTiendas tiempoEntreTiendas = new TiempoEntreTiendas(rs.getInt("idTiempoEntreTiendas"), rs.getInt("TiempoDeEnvio_idTiempoDeEnvio"), rs.getString("Tienda_codigo"),rs.getString("descripcion"));

            return tiempoEntreTiendas;
        } catch (SQLException ex) {
            Logger.getLogger(TiempoEntreTiendasD.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(TiempoEntreTiendasD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    @Override
    public TiempoEntreTiendas getByIdAndDescripcion(String codigoTienda, String descripcion){
        
        
        PreparedStatement stat = null;
        ResultSet rs = null;

        try {
            stat = connection.prepareStatement(GET_BY_CODIGO_TIENDA_AND_DESCRIPCION);
            stat.setString(1,codigoTienda);
            stat.setString(2,descripcion);
            rs = stat.executeQuery();
            while (rs.next()) {
                return (convertir(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
