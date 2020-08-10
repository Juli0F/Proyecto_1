package com.tienda.mysql;

import com.tienda.dao.ClienteDAO;
import com.tienda.dao.DAOManager;
import com.tienda.dao.DetalleFacturaDAO;
import com.tienda.dao.DetallePedidoDAO;
import com.tienda.dao.FacturaDAO;
import com.tienda.dao.PedidoDAO;
import com.tienda.dao.PersonaDAO;
import com.tienda.dao.ProductoDAO;
import com.tienda.dao.Stock_TiendaDAO;
import com.tienda.dao.TiempoDeEnvioDAO;
import com.tienda.dao.TiempoEntreTiendasDAO;
import com.tienda.dao.TiendaDAO;
import com.tienda.dao.UsuarioDAO;
import java.sql.Connection;

public class Manager implements DAOManager {

    private PersonaDAO personadao;
    private ProductoDAO productodao;
    private DetalleFacturaDAO detallefacturadao;
    private TiendaDAO tiendadao;
    private DAOManager daomanager;
    private FacturaDAO facturadao;
    private Stock_TiendaDAO stock_tiendadao;
    private TiempoEntreTiendasDAO tiempoentretiendasdao;
    private TiempoDeEnvioDAO tiempodeenviodao;
    private UsuarioDAO usuariodao;
    private ClienteDAO clientedao;
    private DetallePedidoDAO detallepedidodao;
    private PedidoDAO pedidodao;
    private Connection connection;

    public Manager() {
        this.connection = com.tienda.connection.Conexion.getInstancia();
    }

    @Override
    public PersonaDAO getPersonaDAO() {
        if (personadao == null) {
            personadao = new PersonaD(connection);
        }
        return personadao;
    }

    @Override
    public ProductoDAO getProductoDAO() {
        if (productodao == null) {
            productodao = new ProductoD(connection);
        }
        return productodao;
    }

    @Override
    public DetalleFacturaDAO getDetalleFacturaDAO() {
        if (detallefacturadao == null) {
            detallefacturadao = new DetalleFacturaD(connection);
        }
        return detallefacturadao;
    }

    @Override
    public TiendaDAO getTiendaDAO() {
        if (tiendadao == null) {
            tiendadao = new TiendaD(connection);
        }
        return tiendadao;
    }

//    @Override
//    public DAOManager getDAOManager() {
//        if (daomanager == null) {
//            daomanager = new DManager(connection);
//        }
//        return daomanager;
//    }

    @Override
    public FacturaDAO getFacturaDAO() {
        if (facturadao == null) {
            facturadao = new FacturaD(connection);
        }
        return facturadao;
    }

    @Override
    public Stock_TiendaDAO getStock_TiendaDAO() {
        if (stock_tiendadao == null) {
            stock_tiendadao = new Stock_TiendaD(connection);
        }
        return stock_tiendadao;
    }

    @Override
    public TiempoEntreTiendasDAO getTiempoEntreTiendasDAO() {
        if (tiempoentretiendasdao == null) {
            tiempoentretiendasdao = new TiempoEntreTiendasD(connection);
        }
        return tiempoentretiendasdao;
    }

    @Override
    public TiempoDeEnvioDAO getTiempoDeEnvioDAO() {
        if (tiempodeenviodao == null) {
            tiempodeenviodao = new TiempoDeEnvioD(connection);
        }
        return tiempodeenviodao;
    }

    @Override
    public UsuarioDAO getUsuarioDAO() {
        if (usuariodao == null) {
            usuariodao = new UsuarioD(connection);
        }
        return usuariodao;
    }

    @Override
    public ClienteDAO getClienteDAO() {
        if (clientedao == null) {
            clientedao = new ClienteD(connection);
        }
        return clientedao;
    }

    @Override
    public DetallePedidoDAO getDetallePedidoDAO() {
        if (detallepedidodao == null) {
            detallepedidodao = new DetallePedidoD(connection);
        }
        return detallepedidodao;
    }

    @Override
    public PedidoDAO getPedidoDAO() {
        if (pedidodao == null) {
            pedidodao = new PedidoD(connection);
        }
        return pedidodao;
    }
}
