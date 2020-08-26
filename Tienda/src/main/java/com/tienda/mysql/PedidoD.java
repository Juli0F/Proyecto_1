package com.tienda.mysql;

import com.tienda.dao.PedidoDAO;
import com.tienda.dto.FacturaDto;
import com.tienda.entities.Pedido;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PedidoD implements PedidoDAO {

    private Connection connection;
    private final String INSERT = "INSERT INTO Pedido (fecha,entregado,retraso,destino,estado,TiempoDeEnvio_idTiempoDeEnvio,Cliente_nit,subtotal,anticipo,codigo,Tienda_codigo) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE Pedido SET fecha = ?, entregado = ?, retraso = ?, destino = ?, estado = ?, TiempoDeEnvio_idTiempoDeEnvio = ?, Cliente_nit = ? WHERE codigo = ? ";
    private final String DELETE = "DELETE Pedido WHERE codigo = ? ";
    private final String GETALL = "SELECT * FROM  Pedido  ";
    private final String GETONE = GETALL + "WHERE codigo = ?";
    private final String DATA_REPORTE_SEIS = "select t.codigo as codeTienda ,t.nombre tienda , p.codigo as pedido , p.subtotal as total, date_format(p.fecha, '%d/%m/%Y') as dias  " +
    "from Pedido p " +
    "inner join Tienda t on p.Tienda_codigo = t.codigo " +
    "inner join Cliente c on p.Cliente_nit = c.nit " +
    "inner join Persona per on c.Persona_dpi = per.dpi " +
    "where "
            + "p.fecha " +
    "between ifnull( ?  , '2000-01-01') and ifnull( ? , '3000-01-01') " +
    "AND (p.Cliente_nit = ? ) and t.codigo = ?";

    private final String CLIENTE = "select t.codigo as codeTienda ,t.nombre tienda , p.codigo as pedido , p.subtotal as total, date_format(p.fecha, '%d/%m/%Y') as dias  , if(p.destino = 1,if(p.entregado = 1 ,\"Entregado\", \"Recoger Producto\"),\"En camino\") \n" +
"    from Pedido p  \n" +
"    inner join Tienda t on p.Tienda_codigo = t.codigo  \n" +
"    inner join Cliente c on p.Cliente_nit = c.nit  \n" +
"    inner join Persona per on c.Persona_dpi = per.dpi  \n" +
"    where p.fecha  \n" +
"    between ifnull( ?  , '2000-01-01') and ifnull( ? , '3000-01-01')  \n" +
"    AND (p.Cliente_nit = ? )  and t.codigo in (select tie.codigo from Tienda tie) ";
    //private final String GET_QUE_LLEGARA_A_UNA_TIENDA ="SELECT * F"

    public PedidoD(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Pedido object) {
        PreparedStatement stat = null;;
        try {
            stat = connection.prepareStatement(INSERT);
            stat.setDate(1, object.getFecha());
            stat.setBoolean(2, object.isEntregado());
            stat.setInt(3, object.getRetraso());
            stat.setBoolean(4, object.isDestino());
            stat.setBoolean(5, object.isEstado());
            stat.setInt(6, object.getTiempoDeEnvio_idTiempoDeEnvio());
            stat.setString(7, object.getCliente_nit());
            stat.setBigDecimal(8, object.getSubtotal());
            stat.setBigDecimal(9, object.getAnticipo());
            stat.setString(10, object.getCodigo());
            stat.setString(11, object.getCodigoDestino());
            if (stat.executeUpdate() == 0) {
                System.out.println("crear popover Pedido");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modify(Pedido object) {
        PreparedStatement stat = null;;
        try {
            stat = connection.prepareStatement(UPDATE);
            stat.setDate(1, object.getFecha());
            stat.setBoolean(2, object.isEntregado());
            stat.setInt(3, object.getRetraso());
            stat.setBoolean(4, object.isDestino());
            stat.setBoolean(5, object.isEstado());
            stat.setInt(6, object.getTiempoDeEnvio_idTiempoDeEnvio());
            stat.setString(7, object.getCliente_nit());
            stat.setString(8, object.getCodigo());
            if (stat.executeUpdate() == 0) {
                System.out.println("crear popover Pedido");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pedido> obtenerTodo() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Pedido> lst = new ArrayList<>();
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
    public Pedido obtener(String id) {
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
    public void delete(Pedido object) {
        PreparedStatement stat = null;
        try {
            stat = connection.prepareStatement(DELETE);
            stat.setString(1, object.getCodigo());
            if (stat.executeUpdate() == 0) {

            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Pedido convertir(ResultSet rs) {

        try {
            Pedido pedido = new Pedido(rs.getString("codigo"), rs.getDate("fecha"), rs.getBoolean("entregado"), rs.getInt("retraso"), rs.getBoolean("destino"), rs.getBoolean("estado"), rs.getInt("TiempoDeEnvio_idTiempoDeEnvio"), rs.getString("Cliente_nit"), rs.getBigDecimal("anticipo"), rs.getBigDecimal("subtotal"), rs.getString("Tienda_codigo"));

            return pedido;
        } catch (SQLException ex) {
            Logger.getLogger(PedidoD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PedidoD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    @Override
    public List<Pedido> sinEntregarEnDestino(String destino) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Pedido> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(GETALL + " WHERE destino = 0 AND Tienda_codigo = ?");
            stat.setString(1, destino);
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
    public List<Pedido> buscarCoincidenciaSinEntregarEnDestino(String matchParameter) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Pedido> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(GETALL + " WHERE (Cliente_nit  LIKE ? OR  codigo LIKE ?) AND  destino = 0 ");
            stat.setString(1, "%" + matchParameter + "%");
            stat.setString(2, "%" + matchParameter + "%");
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
    public List<Pedido> buscarCoincidenciaPedidosEntregadosEnTiendaDestino(String matchParameter) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Pedido> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(GETALL + " WHERE (Cliente_nit  LIKE ? OR  codigo LIKE ?) AND  destino = 1 ");
            stat.setString(1, "%" + matchParameter + "%");
            stat.setString(2, "%" + matchParameter + "%");
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

    public List<Pedido> paraRecogerSeEncuentraEnDestino(String tiendaDestino) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Pedido> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(GETALL + " WHERE destino = 1 AND entregado = 0 AND Tienda_codigo = ?");
            stat.setString(1, tiendaDestino);
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
    public List<FacturaDto> reporteSeis(String nitCliente, String codigoTienda, Date dateInit, Date dateFinal) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<FacturaDto> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(DATA_REPORTE_SEIS);
            stat.setDate(1, dateInit);
            stat.setDate(2, dateFinal);
            
            stat.setString(3, nitCliente);
            stat.setString(4, codigoTienda);
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

     @Override
    public List<FacturaDto> paraMostrarAlCliente(String nitCliente, String codigoTienda, Date dateInit, Date dateFinal) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<FacturaDto> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(CLIENTE);
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
      @Override
    public List<FacturaDto> paraMostrarAlClienteConLike(String nitCliente, String codigoTienda, Date dateInit, Date dateFinal,String like, String conFecha) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<FacturaDto> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(CLIENTE+ conFecha+ "   p.codigo LIKE ? order by dias asc" );
            stat.setDate(1, dateInit);
            stat.setDate(2, dateFinal);
            stat.setString(3, nitCliente);
            stat.setString(4, "%"+like+"%");
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
      @Override
    public List<FacturaDto> paraMostrarAlClienteOrdenado(String nitCliente, String codigoTienda, Date dateInit, Date dateFinal , String orderBy) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<FacturaDto> lst = new ArrayList<>();
        try {
            stat = connection.prepareStatement(CLIENTE + orderBy);
            System.out.println("===> "+stat.toString());
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
            return new FacturaDto(rs.getString("pedido"), rs.getString("tienda"), rs.getString("codeTienda"), rs.getString("dias"), rs.getString("total"));

        } catch (SQLException ex) {
            Logger.getLogger(FacturaD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
