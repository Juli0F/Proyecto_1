package com.tienda.dao;


public interface DAOManager{
    
   
   PersonaDAO getPersonaDAO();
   ProductoDAO getProductoDAO();
   DetalleFacturaDAO getDetalleFacturaDAO();
   TiendaDAO getTiendaDAO();
   FacturaDAO getFacturaDAO();
   TiempoDeEnvioDAO getTiempoDeEnvioDAO();
   StockTiendaDAO getStockTiendaDAO();
   UsuarioDAO getUsuarioDAO();
   ClienteDAO getClienteDAO();
   DetallePedidoDAO getDetallePedidoDAO();
   PedidoDAO getPedidoDAO();
   
   
}
