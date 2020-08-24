package com.tienda.mysql;

import com.tienda.dao.TiendaDAO;
import com.tienda.dto.TiendaRepDos;
import com.tienda.dto.TiendaRepUno;
import com.tienda.dto.TiendaTiempo;
import com.tienda.entities.Tienda;
import java.sql.Connection;
import java.sql.Date;
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
            
   
   private final String GET_DATOS_REPORTE_UNO_SIN_FECHA = "select t.codigo, t.nombre, p.codigo as codigoPedido, date_format(p.fecha,'%d/%m/%Y')  AS fecha  ,p.subtotal as total  from Pedido p, Tienda t where t.codigo in (select tet.Tienda_codigo from   TiempoEntreTiendas tet where (tet.TiempoDeEnvio_idTiempoDeEnvio in (SELECT p.TiempoDeEnvio_idTiempoDeEnvio FROM Pedido p2 where p2.Tienda_codigo = ? ) and tet.Tienda_codigo <> ?) and (p.entregado = 0 and p.destino = 0 ))";
   private final String GET_DATOS_REPORTE1_UNA_FECHA = "select t.codigo, t.nombre, p.codigo as codigoPedido, date_format(p.fecha,'%d/%m/%Y')  AS fecha, p.subtotal as total  from Pedido p, Tienda t where p.fecha >= ?  and t.codigo in (select tet.Tienda_codigo from   TiempoEntreTiendas tet where (tet.TiempoDeEnvio_idTiempoDeEnvio in (SELECT p.TiempoDeEnvio_idTiempoDeEnvio FROM Pedido p2 where p2.Tienda_codigo = ?) and tet.Tienda_codigo <> ?) and (p.entregado = 0 and p.destino = 0 )) order by fecha asc";
   private final String GET_DATOS_REPORTE1_FECHA_FINAL = "select t.codigo, t.nombre, p.codigo as codigoPedido, date_format(p.fecha,'%d/%m/%Y') as fecha, p.subtotal as total from Pedido p, Tienda t where p.fecha <= ?  and t.codigo in (select tet.Tienda_codigo from   TiempoEntreTiendas tet where (tet.TiempoDeEnvio_idTiempoDeEnvio in (SELECT p.TiempoDeEnvio_idTiempoDeEnvio FROM Pedido p2 where p2.Tienda_codigo = ?) and tet.Tienda_codigo <> ?) and (p.entregado = 0 and p.destino = 0 )) order by fecha asc";
   private final String GET_DATOS_REPORTE1_ENTRE_FECHAS = "select t.codigo, t.nombre, p.codigo as codigoPedido, date_format(p.fecha,'%d/%m/%Y')  AS fecha, p.subtotal as total   FROM Pedido p, Tienda t where p.fecha between ? AND ?  and t.codigo in (select tet.Tienda_codigo from   TiempoEntreTiendas tet where (tet.TiempoDeEnvio_idTiempoDeEnvio in (SELECT p.TiempoDeEnvio_idTiempoDeEnvio FROM Pedido p2 where p2.Tienda_codigo = ?) and tet.Tienda_codigo <> ?) and (p.entregado = 0 and p.destino = 0 ))  order by fecha asc";
   
   
   //create temporary CREATE TEMPORARY TABLE IF NOT EXISTS tempTable1 select t.codigo, t.nombre, p.fecha , datediff('2020-06-06', p.fecha) as dias, tde.tiempo from Pedido p inner join TiempoDeEnvio tde on p.TiempoDeEnvio_idTiempoDeEnvio = tde.idTiempoDeEnvio inner join TiempoEntreTiendas tet on tde.idTiempoDeEnvio = tet.TiempoDeEnvio_idTiempoDeEnvio inner join Tienda t on tet.Tienda_codigo = t.codigo where tet.Tienda_codigo <> "ABC-2" AND p.Tienda_codigo = "ABC-2";
//select codigo, nombre, fecha ,dias from Tempo temp where dias >= 0
   
   private final String FALTA_VERIFICACION = "select t.codigo, t.nombre, date_format(p.fecha, '%d/%m/%Y') as fecha ,p.codigo as codigoPedido, datediff(?, p.fecha) as dias, tde.tiempo  ,p.subtotal as total from Pedido p inner join TiempoDeEnvio tde on p.TiempoDeEnvio_idTiempoDeEnvio = tde.idTiempoDeEnvio inner join TiempoEntreTiendas tet on tde.idTiempoDeEnvio = tet.TiempoDeEnvio_idTiempoDeEnvio inner join Tienda t on tet.Tienda_codigo = t.codigo where tet.Tienda_codigo <> ? AND p.Tienda_codigo = ? AND p.destino = 0 AND datediff(?, p.fecha) <= 0";
   private final String PEDIDOS_CON_ATRASO = "select t.codigo, t.nombre,p.codigo as codigoPedido, date_format(p.fecha, '%d/%m/%Y') as fecha , datediff(?, p.fecha) as dias, tde.tiempo , p.subtotal as total from Pedido p inner join TiempoDeEnvio tde on p.TiempoDeEnvio_idTiempoDeEnvio = tde.idTiempoDeEnvio inner join TiempoEntreTiendas tet on tde.idTiempoDeEnvio = tet.TiempoDeEnvio_idTiempoDeEnvio inner join Tienda t on tet.Tienda_codigo = t.codigo where tet.Tienda_codigo <> ? AND p.Tienda_codigo = ? AND p.destino = 0 AND (datediff(?, p.fecha) - tde.tiempo) > 0";
           
   
   //between "2020-06-02" AND "3918-09-05"
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

    @Override
    public List<TiendaRepUno> pedidosSinFecha(String codigoTiendaDestino) {
       PreparedStatement stat = null;
        ResultSet rs = null;
        List<TiendaRepUno> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(GET_DATOS_REPORTE_UNO_SIN_FECHA);
            stat.setString(1, codigoTiendaDestino);
            stat.setString(2, codigoTiendaDestino);
            rs = stat.executeQuery();
            while (rs.next()) {
                lst.add(convertirTiendaRepUno(rs));
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    public TiendaRepUno convertirTiendaRepUno(ResultSet rs){
        
        try {
            return new TiendaRepUno(rs.getString("codigo"), rs.getString("nombre"), rs.getString("codigoPedido"), rs.getString("fecha"), rs.getString("total"));

            
        } catch (SQLException ex) {
            Logger.getLogger(TiendaD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<TiendaRepUno> pedidosFechaInicial(String codigoTiendaDestino, Date dateInit) {
         PreparedStatement stat = null;
        ResultSet rs = null;
        List<TiendaRepUno> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(GET_DATOS_REPORTE1_UNA_FECHA);
            stat.setDate(1, dateInit);
            stat.setString(2, codigoTiendaDestino);
            stat.setString(3, codigoTiendaDestino);
            rs = stat.executeQuery();
            while (rs.next()) {
                lst.add(convertirTiendaRepUno(rs));
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<TiendaRepUno> pedidosFechaFinal(String codigoTiendaDestino, Date dateFinal) {
         PreparedStatement stat = null;
        ResultSet rs = null;
        List<TiendaRepUno> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(GET_DATOS_REPORTE1_FECHA_FINAL);
            stat.setDate(1, dateFinal);
            stat.setString(2, codigoTiendaDestino);
            stat.setString(3, codigoTiendaDestino);
            rs = stat.executeQuery();
            while (rs.next()) {
                lst.add(convertirTiendaRepUno(rs));
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<TiendaRepUno> pedidosEntreFechas(String codigoTiendaDestino, Date dateInit, Date dateFinal) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<TiendaRepUno> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(GET_DATOS_REPORTE1_ENTRE_FECHAS);
            stat.setDate(1, dateInit);
            stat.setDate(2, dateFinal);
            stat.setString(3, codigoTiendaDestino);
            stat.setString(4, codigoTiendaDestino);
            rs = stat.executeQuery();
            while (rs.next()) {
                lst.add(convertirTiendaRepUno(rs));
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<TiendaRepDos> pedidosFaltaVerificacion(String codigoTienda, Date date) {
        //FALTA_VERIFICACION
        
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<TiendaRepDos> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(FALTA_VERIFICACION);
            stat.setDate(1, date);
            stat.setString(2, codigoTienda);
            stat.setString(3, codigoTienda);
            stat.setDate(4, date);
            rs = stat.executeQuery();
            while (rs.next()) {
                lst.add(convertirTiendaRepDos(rs));
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<TiendaRepDos> pedidosConAtraso(String codigoTienda, Date date) {
            
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<TiendaRepDos> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(PEDIDOS_CON_ATRASO);
            stat.setDate(1, date);
            stat.setString(2, codigoTienda);
            stat.setString(3, codigoTienda);
            stat.setDate(4, date);
            rs = stat.executeQuery();
            while (rs.next()) {
                lst.add(convertirTiendaRepDos(rs));
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    
    
    
    public TiendaRepDos convertirTiendaRepDos(ResultSet rs){
        
        try {
            return new TiendaRepDos(rs.getString("codigo"), rs.getString("nombre"), rs.getString("codigoPedido"), rs.getString("fecha"),rs.getInt("dias"),rs.getInt("tiempo"),rs.getString("total"));

            
        } catch (SQLException ex) {
            Logger.getLogger(TiendaD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
}
