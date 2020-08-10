/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.loaddata;

//import administradores.SeparadorDeParametros;
import com.google.protobuf.TextFormat.ParseException;
import com.tienda.entities.Cliente;
import com.tienda.entities.DetalleFactura;
import com.tienda.entities.DetallePedido;
import com.tienda.entities.Pedido;
import com.tienda.entities.Persona;
import com.tienda.entities.Producto;
import com.tienda.entities.StockTienda;
import com.tienda.entities.TiempoDeEnvio;
import com.tienda.entities.TiempoEntreTiendas;
import com.tienda.entities.Tienda;
import com.tienda.entities.Usuario;
import com.tienda.mysql.Manager;
import java.math.BigDecimal;
//import java.sql.Date;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author julio
 */
public class Interprete {

    // TIENDA, TIEMPO, PRODUCTO, CLIENTE, PEDIDO.
    private final String EMPLEADO = "EMPLEADO";
    private final String CLIENTE = "CLIENTE";
    private final String PRODUCTO = "PRODUCTO";
    private final String TIEMPO = "TIEMPO";
    private final String TIENDA = "TIENDA";
    private final String PEDIDO = "PEDIDO";
    private String instruccion;
    //------------------------------------------------------
    //constructor

    public Interprete(String tipoInstruccion) {

        this.instruccion = tipoInstruccion;
    }
    //fin Constructor
    //--------------------------------------------------------------------------------------------

    public void splitLinea(String linea, int cont) {
//--------------------------------------------------------------------------------------------        
        //----------verifica que la instruccion tenga parantesis
        //----------de tener los parentesis  divide el codigo en dos
        //----------la primera parte es el tipo de instruccion que se realizara
        //----------la segnda parte son parametros para realizar esa instruccion
//--------------------------------------------------------------------------------------------    

        String partirCodigo[] = linea.split(",");
        String datosLinea = "";
        for (int i = 1; i < partirCodigo.length; i++) {
            datosLinea += partirCodigo[i];
        }

        System.out.println(datosLinea);
        tipoObjeto(partirCodigo[0], partirCodigo[1], cont);

    }

    //--------------------------------------------------------------------------------------------
    //  El siguiente bloque de codigo clasifica las intrucciones 
    //  para convertirlas en objetos
    //--------------------------------------------------------------------------------------------
    public void tipoObjeto(String SplitTipo, String lineInstructions, int cont) {

        switch (SplitTipo) {
            case EMPLEADO: {
                System.out.println("Empleado");
                //envia el resto de la linea a el separador de parametrosos();
                enviarLineaDeParametros(lineInstructions, 1, cont);

                break;
            }
            case CLIENTE: {
                enviarLineaDeParametros(lineInstructions, 2, cont);
                break;

            }
            case PRODUCTO: {

                enviarLineaDeParametros(lineInstructions, 3, cont);
                break;
            }
            case TIEMPO: {
                enviarLineaDeParametros(lineInstructions, 4, cont);
                break;
            }
            case PEDIDO: {
                enviarLineaDeParametros(lineInstructions, 5, cont);
                break;
            }
            case TIENDA: {
                enviarLineaDeParametros(lineInstructions, 6, cont);
                break;
            }
            default:
                enviarLineaDeParametros("Error: " + lineInstructions, 7, cont);
        }

    }

    /**
     *
     * @param instruccion linea que lee del archivo
     * @param i tipo de instruccion
     * @param cont numero de linea que lee
     */
    public void enviarLineaDeParametros(String instruccion, int i, int cont) {

        try {
            //  SeparadorDeParametros administrarParametros = new SeparadorDeParametros(instruccion, i, cont);
            //administrarParametros.separarParametros();
            String datos[] = instruccion.split(",");
            Manager manager = new Manager();
            switch (i) {
                case 1:
                    System.out.println("Empleado");

                    Persona tipoEmpleado = new Persona(datos[1], datos[0], datos[2], "", true);
                    Usuario empleado = new Usuario(0, datos[0], datos[1], 2, true, datos[1]);

                    manager.getPersonaDAO().insert(tipoEmpleado);
                    manager.getUsuarioDAO().insert(empleado);

                    break;
                case 2:
                    System.out.println("Cliente");
                    if (verificarCantidad(datos, 4, cont)) {

                        Persona tipoCliente = new Persona(datos[1], datos[0], datos[2], "", true);
                        Cliente cliente = new Cliente(datos[1], "", true, datos[1], BigDecimal.valueOf(Double.valueOf(datos[3])));

                        manager.getPersonaDAO().insert(tipoCliente);
                        manager.getClienteDAO().insert(cliente);
                    }
                    break;
                case 3:
                    System.out.println("Producto");
                    if (verificarCantidad(datos, 6, cont)) {

                        Producto producto = new Producto(datos[2], datos[0], datos[1], "", 0, true);

                        StockTienda stock_Tienda = new StockTienda(0, datos[5], datos[2], true, Integer.valueOf(datos[3]), BigDecimal.valueOf(Double.valueOf(datos[4])));

                        manager.getProductoDAO().insert(producto);
                        manager.getStockTiendaDAO().insert(stock_Tienda);
                    }

                    break;
                case 4:
                    System.out.println("Tiempo");
                    if (verificarCantidad(datos, 3, cont)) {

                        Tienda tienda1 = manager.getTiendaDAO().obtener(datos[0]);
                        if (tienda1 != null) {
                            tienda1 = manager.getTiendaDAO().obtener(datos[1]);
                            if (tienda1 != null) {
                                //ublic TiempoDeEnvio(int idTiempoDeEnvio, String tiempo, boolean estado) {
                                TiempoDeEnvio tiempoDeEnvio = new TiempoDeEnvio(1, Integer.valueOf(datos[datos.length - 1]), true, datos[1]);
                                manager.getTiempoDeEnvioDAO().insert(tiempoDeEnvio);
                                // int idtiempo = manager.getTiempoDeEnvioDAO().lastInsertId();

                                //TiempoEntreTiendas entreTiendas = new TiempoEntreTiendas(0, idtiempo, datos[0], "Origen");
                                //manager.getTiempoEntreTiendasDAO().insert(entreTiendas);
                                //entreTiendas = new TiempoEntreTiendas(0, idtiempo, datos[1], "Destino");
                                //manager.getTiempoEntreTiendasDAO().insert(entreTiendas);
                            } else {
                                System.out.println("Error: Linea " + cont + " -> Debe Crear Primero la Tienda");
                            }
                        } else {
                            System.out.println("Error: Linea " + cont + " -> Debe Crear Primero la Tienda");
                        }
                    }

                    break;
                case 5:
                    System.out.println("Pedido");

                    if (verificarCantidad(datos, 9, cont)) {
                        //Pedido pedido = new Pedido(data[0], fecha, true, cont, true, true, cont, CLIENTE);
                        Tienda tiendaPrueba = manager.getTiendaDAO().obtener(datos[1]);
                        if (tiendaPrueba != null) {
                            tiendaPrueba = manager.getTiendaDAO().obtener(datos[2]);
                            if (tiendaPrueba != null) {

                                if (existenciaSuficiente(datos[1], datos[5], Integer.valueOf(datos[6]))) {

                                    if (manager.getClienteDAO().obtener(datos[5]) != null) {

                                        if (manager.getPedidoDAO().obtener(datos[0]) != null) {
                                            //el pedido ya existe
                                            DetallePedido articulos = new DetallePedido(0, Integer.valueOf(datos[6]), true, datos[5], datos[0]);
                                            manager.getDetallePedidoDAO().insert(articulos);
                                            
                                            descontarPedido(datos[1], datos[5], Integer.valueOf(datos[6]));

                                        } else {
                                            //  crea el pedido
                                            Integer envio = manager.getTiempoEntreTiendasDAO().getTiempoByTwoStore(datos[1], datos[2]);
                                            if (envio != null) {

                                                Pedido pedido = new Pedido(datos[0], java.sql.Date.valueOf(datos[3]), false, 0, false, true, envio, datos[5], BigDecimal.valueOf(Double.valueOf(datos[datos.length - 1])), BigDecimal.valueOf(Double.valueOf(datos[datos.length - 2])));
                                                DetallePedido articulos = new DetallePedido(0, Integer.valueOf(datos[6]), true, datos[5], datos[0]);

                                                manager.getPedidoDAO().insert(pedido);
                                                manager.getDetallePedidoDAO().insert(articulos);
                                                
                                                descontarPedido(datos[1], datos[5], Integer.valueOf(datos[6]));
                                            } else {
                                                System.out.println("Error: Linea " + cont + " -> Debe Crear Primero un Tiempo De Envio");
                                            }
                                        }
                                    } else {
                                        System.out.println("Error: Linea " + cont + " -> Debe Crear Primero Al Cliente");
                                    }
                                } else {
                                    System.out.println("Error: Linea " + cont + " -> Verificar Existencia");
                                }

                            } else {
                                System.out.println("Error: Linea " + cont + " -> Debe Crear Primero la Tienda");
                            }
                        } else {
                            System.out.println("Error: Linea " + cont + " -> Debe Crear Primero la Tienda");
                        }
                    }

                    break;
                case 6:
                    System.out.println("Tiendda: " + instruccion);

                    if (verificarCantidad(datos, 4, cont)) {

                        Tienda tienda = new Tienda(datos[2], datos[0], datos[1], datos[3], "", "", "", true);
                        manager.getTiendaDAO().insert(tienda);

                    }

                    break;
                case 7:

                    break;

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            //Logger.getLogger(Interprete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean verificarCantidad(String datos[], int cantidad, int cont) throws Exception {

        if (datos.length == cantidad) {
            return true;
        } else {
            throw new Exception("Error: Linea " + cont + " -> error en la cantidad de datos");
            //System.out.println("Error: Linea " + cont + " -> error en la cantidad de datos");

            //return false;
        }
        //return datos.length==cantidad;

    }

    public boolean existenciaSuficiente(String codigoTienda, String codigoProducto, int cantidadDeProducto) {

        Manager manager = new Manager();

        StockTienda stock = manager.getStockTiendaDAO().existencia(codigoTienda, codigoProducto);
        if (stock != null && stock.getCantidad() >= cantidadDeProducto) {
            return true;
        }

        return false;
    }
    
    public void descontarPedido(String codigoTienda, String codigoProducto, int cantidadDeProducto) {

        Manager manager = new Manager();

        StockTienda stock = manager.getStockTiendaDAO().existencia(codigoTienda, codigoProducto);
        stock.setCantidad(stock.getCantidad()-cantidadDeProducto);
        
        manager.getStockTiendaDAO().modify(stock);

        
    }

}
