package com.tienda.dao;





public interface DAOManager{
   PersonaDAO getPersonaDAO();
   ProductoDAO getProductoDAO();
   DetalleFacturaDAO getDetalleFacturaDAO();
   TiendaDAO getTiendaDAO();
  // DAOManager getDAOManager();
   FacturaDAO getFacturaDAO();
   Stock_TiendaDAO getStock_TiendaDAO();
   TiempoEntreTiendasDAO getTiempoEntreTiendasDAO();
   TiempoDeEnvioDAO getTiempoDeEnvioDAO();
   UsuarioDAO getUsuarioDAO();
   ClienteDAO getClienteDAO();
   DetallePedidoDAO getDetallePedidoDAO();
   PedidoDAO getPedidoDAO();
}
