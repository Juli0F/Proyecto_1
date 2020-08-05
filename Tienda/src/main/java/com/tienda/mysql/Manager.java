package com.tienda.mysql;

import com.tienda.dao.*;
import java.sql.Connection;
import com.tienda.connection.Conexion;

public class Manager implements DAOManager {

    private DAO dao;
    private PersonaDAO personadao;
    private ProductoDAO productodao;
    private DetalleFacturaDAO detallefacturadao;
    private TiendaDAO tiendadao;
    private DAOManager daomanager;
    private FacturaDAO facturadao;
    private TiempoDeEnvioDAO tiempodeenviodao;
    private StockTiendaDAO stocktiendadao;
    private UsuarioDAO usuariodao;
    private ClienteDAO clientedao;
    private DetallePedidoDAO detallepedidodao;
    private PedidoDAO pedidodao;
    private Connection connection;

    public Manager() {
        //this.connection = connection.Conexion.getInstancia();
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

    

    @Override
    public FacturaDAO getFacturaDAO() {
        if (facturadao == null) {
            facturadao = new FacturaD(connection);
        }
        return facturadao;
    }

    @Override
    public TiempoDeEnvioDAO getTiempoDeEnvioDAO() {
        if (tiempodeenviodao == null) {
            tiempodeenviodao = new TiempoDeEnvioD(connection);
        }
        return tiempodeenviodao;
    }

    @Override
    public StockTiendaDAO getStockTiendaDAO() {
        if (stocktiendadao == null) {
            stocktiendadao = new StockTiendaD(connection);
        }
        return stocktiendadao;
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
