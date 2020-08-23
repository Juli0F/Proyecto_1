package com.tienda.mysql;

import com.tienda.dao.TiendaDAO;
import com.tienda.dto.TiendaTiempo;
import com.tienda.entities.Tienda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TiendaD implements TiendaDAO {

    private Connection connection;
    private final String INSERT = "INSERT INTO Tienda (nombre , direccion, telefono, telefono2, email, horario, estado, codigo) VALUES (?,?,?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE Tienda SET nombre = ?,  direccion = ?, telefono = ?, telefono2 = ?, email = ?, horario = ?, estado = ? WHERE codigo = ? ";
    private final String DELETE = "DELETE Tienda WHERE codigo = ? ";
    private final String GET_ALL = "SELECT * FROM  Tienda  ";
    private final String GET_ONE = GET_ALL + "WHERE codigo = ?";
    private final String GET_ALL_SEARCH_WITH = GET_ALL +" WHERE "
    
            + " nombre LIKE ? "
            + "OR direccion LIKE ?"
            + " OR telefono LIKE ? "
            + "OR telefono LIKE ?"
            + " OR telefono2 LIKE ?"
            + " OR email LIKE ? OR"
            + " codigo LIKE ?";
    private final String GET_TIEMPO_TIENDA_TET = "select tet.Tienda_codigo as codigo,ts.nombre, te.tiempo from TiempoEntreTiendas tet inner join Tienda ts on tet.Tienda_codigo = ts.codigo inner join TiempoDeEnvio te on te.idTiempoDeEnvio = tet.TiempoDeEnvio_idTiempoDeEnvio WHERE ts.estado = 1 and ts.codigo = ?";
    private final String GET_TIEMPO_TIENDA_TET_USE_LIKE = "select tet.Tienda_codigo as codigo,ts.nombre, te.tiempo from TiempoEntreTiendas tet inner join Tienda ts on tet.Tienda_codigo = ts.codigo inner join TiempoDeEnvio te on te.idTiempoDeEnvio = tet.TiempoDeEnvio_idTiempoDeEnvio WHERE ts.estado = 1 and ts.codigo LIKE ?";
    private final String GET_ALL_TIENDAS_USE_LIKE = GET_ALL + " WHERE estado = 1 AND ( codigo LIKE ? OR nombre LIKE ? )";
    
    private final String GET_CODIGO_NOMBRE_TIEMPO = "select auxTet.Tienda_codigo as codigo, t.nombre nombre, tiempo.tiempo from TiempoEntreTiendas tet inner join TiempoEntreTiendas auxTet on tet.TiempoDeEnvio_idTiempoDeEnvio = auxTet.TiempoDeEnvio_idTiempoDeEnvio  inner join Tienda t on auxTet.Tienda_codigo = t.codigo inner join TiempoDeEnvio tiempo on tiempo.idTiempoDeEnvio = auxTet.TiempoDeEnvio_idTiempoDeEnvio WHERE tet.Tienda_codigo = ? AND auxTet.Tienda_codigo <> ? ORDER BY tiempo.tiempo DESC";
   
    private final String GET_TIENDAS_SIN_TIEMPO_CON_RESPECTO_A_OTRA = "SELECT * FROM Tienda t WHERE"
                                                                   + " t.codigo <> ? and estado = 1 AND  t.codigo "
                                                                   + "NOT IN (SELECT auxTet.Tienda_codigo as codigo FROM TiempoEntreTiendas tet INNER JOIN TiempoEntreTiendas auxTet ON tet.TiempoDeEnvio_idTiempoDeEnvio = auxTet.TiempoDeEnvio_idTiempoDeEnvio  INNER JOIN Tienda t ON auxTet.Tienda_codigo = t.codigo INNER JOIN TiempoDeEnvio tiempo ON tiempo.idTiempoDeEnvio = auxTet.TiempoDeEnvio_idTiempoDeEnvio WHERE tet.Tienda_codigo = ? AND auxTet.Tienda_codigo <> ? ORDER BY tiempo.tiempo DESC)  ";
            
    public TiendaD(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Tienda object) {
        PreparedStatement stat = null;;
        try {
            stat = connection.prepareStatement(INSERT);
            stat.setString(1, object.getNombre());
            stat.setString(2, object.getDireccion());
            stat.setString(3, object.getTelefono());
            stat.setString(4, object.getTelefono2());
            stat.setString(5, object.getEmail());
            stat.setString(6, object.getHorario());
            stat.setBoolean(7, object.isEstado());
            stat.setString(8, object.getCodigo());
            if (stat.executeUpdate() == 0) {
                System.out.println("crear popover Tienda");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modify(Tienda object) {
        PreparedStatement stat = null;;
        try {
            stat = connection.prepareStatement(UPDATE);
            stat.setString(1, object.getNombre());
            stat.setString(2, object.getDireccion());
            stat.setString(3, object.getTelefono());
            stat.setString(4, object.getTelefono2());
            stat.setString(5, object.getEmail());
            stat.setString(6, object.getHorario());
            stat.setBoolean(7, object.isEstado());
            stat.setString(8, object.getCodigo());
            if (stat.executeUpdate() == 0) {
                System.out.println("crear popover Tienda");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Tienda> obtenerTodo() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Tienda> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(GET_ALL+" WHERE estado = 1");
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
    public Tienda obtener(String id) {
        PreparedStatement stat = null;
        ResultSet rs = null;

        try {
            stat = connection.prepareStatement(GET_ONE);
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
    public void delete(Tienda object) {
        PreparedStatement stat = null;
        try {
            stat = connection.prepareStatement(DELETE);
            stat.setString(1, object.getCodigo());
            if (stat.executeUpdate() == 0) {

            }
        } catch (SQLException ex) {
            Logger.getLogger(TiendaD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Tienda convertir(ResultSet rs) {

        try {
            Tienda tienda = new Tienda(rs.getString("codigo"), rs.getString("nombre"), rs.getString("direccion"), rs.getString("telefono"), rs.getString("telefono2"), rs.getString("email"), rs.getString("horario"), rs.getBoolean("estado"));

            return tienda;
        } catch (SQLException ex) {
            Logger.getLogger(TiendaD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TiendaD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    @Override
    public List<Tienda> getSearchWithLike(String parameterOfSearch) {
       PreparedStatement stat = null;
        ResultSet rs = null;

        List<Tienda> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(GET_ALL_SEARCH_WITH);
           stat.setString(1, "%"+parameterOfSearch+"%");
            stat.setString(2, "%"+parameterOfSearch+"%");
            stat.setString(3, "%"+parameterOfSearch+"%");
            stat.setString(4, "%"+parameterOfSearch+"%");
            stat.setString(5, "%"+parameterOfSearch+"%");
            stat.setString(6, "%"+parameterOfSearch+"%");
            stat.setString(7, "%"+parameterOfSearch+"%");
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
    public List<TiendaTiempo> getTiempoTiendaTET(String codigoTiendaOrigen) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<TiendaTiempo> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(GET_CODIGO_NOMBRE_TIEMPO);
            stat.setString(1, codigoTiendaOrigen);
            stat.setString(2, codigoTiendaOrigen);
            rs = stat.executeQuery();
            while (rs.next()) {
                lst.add(convertTiendaTiempo(rs));
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<TiendaTiempo> getTiempoTiendaTET() {
         PreparedStatement stat = null;
        ResultSet rs = null;
        List<TiendaTiempo> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(GET_ALL+" WHERE estado = 1");
            rs = stat.executeQuery();
            while (rs.next()) {
                lst.add(convertTiendaTiempoSin(rs));
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    private TiendaTiempo convertTiendaTiempoSin(ResultSet rs){
        
        try {
            TiendaTiempo tienda = new TiendaTiempo(rs.getString("codigo"), rs.getString("nombre"), 0);

            return tienda;
        } catch (SQLException ex) {
            Logger.getLogger(TiendaD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    private TiendaTiempo convertTiendaTiempo(ResultSet rs){
        
        try {
            TiendaTiempo tienda = new TiendaTiempo(rs.getString("codigo"), rs.getString("nombre"), rs.getInt("tiempo"));

            return tienda;
        } catch (SQLException ex) {
            Logger.getLogger(TiendaD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }

    @Override
    public List<TiendaTiempo> getTiempoTiendaTETUseLike(String codigoTiendaOrigen) {
       PreparedStatement stat = null;
        ResultSet rs = null;
        List<TiendaTiempo> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(GET_ALL +" WHERE codigo LIKE ? AND estado = 1");
            stat.setString(1, "%"+codigoTiendaOrigen+"%");
            rs = stat.executeQuery();
            while (rs.next()) {
                lst.add(convertTiendaTiempoSin(rs));
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Tienda> getAllTiendaLike(String parameter) {
          PreparedStatement stat = null;
        ResultSet rs = null;
        List<Tienda> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(GET_ALL_TIENDAS_USE_LIKE);
            stat.setString(1, "%"+parameter+"%");
            stat.setString(2, "%"+parameter+"%");
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
    public List<TiendaTiempo> getTiendasSinTiempoConRespectoAOtra(String codigoTienda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tienda> getTiendaSinRelacionDeTiempoConRespectoAOtra(String codigoTienda) {
      PreparedStatement stat = null;
        ResultSet rs = null;
        List<Tienda> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(GET_TIENDAS_SIN_TIEMPO_CON_RESPECTO_A_OTRA);
            stat.setString(1, codigoTienda);
            stat.setString(2, codigoTienda);
            stat.setString(3, codigoTienda);
            
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
