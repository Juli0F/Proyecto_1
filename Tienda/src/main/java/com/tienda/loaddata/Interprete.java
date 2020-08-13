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
import java.awt.Color;
import java.math.BigDecimal;
//import java.sql.Date;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JTextArea;

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

    public void splitLinea(String linea, int cont, JTextArea correcto, JTextArea error) {
//--------------------------------------------------------------------------------------------        
        //----------verifica que la instruccion tenga parantesis
        //----------de tener los parentesis  divide el codigo en dos
        //----------la primera parte es el tipo de instruccion que se realizara
        //----------la segnda parte son parametros para realizar esa instruccion
//--------------------------------------------------------------------------------------------    

        if (linea.contains(",")) {

            String partirCodigo[] = linea.split(",");
            String datosLinea = "";
            for (int i = 1; i < partirCodigo.length; i++) {
                datosLinea = datosLinea + "," + partirCodigo[i];
                
            }

            System.out.println(datosLinea);
            tipoObjeto(partirCodigo[0], linea, cont, correcto, error);
        } else {
            error.setText(error.getText() + "\n" + "Linea " + cont + " No se logra interpretar");
            //error.setForeground(Color.red);
        }

    }

    //--------------------------------------------------------------------------------------------
    //  El siguiente bloque de codigo clasifica las intrucciones 
    //  para convertirlas en objetos
    //--------------------------------------------------------------------------------------------
    public void tipoObjeto(String SplitTipo, String lineInstructions, int cont, JTextArea correcto, JTextArea error) {

        switch (SplitTipo) {
            case EMPLEADO: {
                System.out.println("Empleado");
                //envia el resto de la linea a el separador de parametrosos();
                enviarLineaDeParametros(lineInstructions, 1, cont, correcto, error);

                break;
            }
            case CLIENTE: {
                enviarLineaDeParametros(lineInstructions, 2, cont, correcto, error);
                break;

            }
            case PRODUCTO: {

                enviarLineaDeParametros(lineInstructions, 3, cont, correcto, error);
                break;
            }
            case TIEMPO: {
                enviarLineaDeParametros(lineInstructions, 4, cont, correcto, error);
                break;
            }
            case PEDIDO: {
                enviarLineaDeParametros(lineInstructions, 5, cont, correcto, error);
                break;
            }
            case TIENDA: {
                enviarLineaDeParametros(lineInstructions, 6, cont, correcto, error);
                break;
            }
            default:
                error.setText(error.getText() + "\n" + "Error: " + SplitTipo + " " + lineInstructions + "  --> Instruccion No Valida");
            //enviarLineaDeParametros("Error: " + lineInstructions, 7, cont);
        }

    }

    /**
     *
     * @param instruccion linea que lee del archivo
     * @param i tipo de instruccion
     * @param cont numero de linea que lee
     */
    public void enviarLineaDeParametros(String instruccion, int i, int cont, JTextArea correcto, JTextArea error) {

        try {
            //  SeparadorDeParametros administrarParametros = new SeparadorDeParametros(instruccion, i, cont);
            //administrarParametros.separarParametros();
            String datos[] = instruccion.split(",");

            
            Manager manager = new Manager();
            switch (i) {
                case 1:
                    ;
                    if (verificarCantidad(datos, 5, cont, error)) {

                        System.out.println("Empleado");
                        if (manager.getPersonaDAO().obtener(datos[4]) == null && manager.getUsuarioDAO().getByCodeUsr(datos[2]) == null) {

                            //public Persona (String dpi, String nombre, String telefono, String direccion, boolean estado ){
                            Persona tipoEmpleado = new Persona(datos[4], datos[1], datos[3], "", true);
                            manager.getPersonaDAO().insert(tipoEmpleado);
                            //public Usuario(int idUsuario, String usuario, String password, int tipo, boolean estado, String Persona_dpi) {
                            Usuario empleado = new Usuario(0, datos[2], datos[4], 2, true, datos[4],"");
                            manager.getUsuarioDAO().insert(empleado);
                            imprimirJTextArea(correcto, cont,  instruccion, "Correcto");

                        } else {

                            imprimirJTextArea(error, cont,  instruccion, "error existe un registro similar");

                        }

                    }
                    break;
                case 2:
                    System.out.println("Cliente");
                    if (verificarCantidad(datos, 5, cont, error)) {
                        if (( manager.getPersonaDAO().obtener(datos[2]) == null) && manager.getClienteDAO().obtener(datos[2]) == null) {

                            Persona tipoCliente = new Persona(datos[2], datos[1], datos[3], "", true);
                            manager.getPersonaDAO().insert(tipoCliente);
                            
                            Cliente cliente = new Cliente(datos[2], "", true, datos[2], BigDecimal.valueOf(Double.valueOf(datos[4])));
                            manager.getClienteDAO().insert(cliente);
                            imprimirJTextArea(correcto, cont,  instruccion, "Correcto");

                        } else {
                            imprimirJTextArea(error, cont,  instruccion, " Error -> Existe un Registro Similar");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Producto");
                    if (verificarCantidad(datos, 7, cont, error)) {

                        if (manager.getProductoDAO().obtener(datos[3]) == null) {

                            Producto producto = new Producto(datos[3], datos[1], datos[2], "", 0, true);

                            StockTienda stock_Tienda = new StockTienda(0, datos[6], datos[3], true, Integer.valueOf(datos[4]), BigDecimal.valueOf(Double.valueOf(datos[5])));

                            manager.getProductoDAO().insert(producto);
                            manager.getStockTiendaDAO().insert(stock_Tienda);
                            imprimirJTextArea(correcto, cont,  instruccion, "Correcto");
                        } else {
                            imprimirJTextArea(error, cont,  instruccion, " Error -> Existe un Registro Similar");
                        }
                    }

                    break;
                case 4:
                    System.out.println("Tiempo");
                    if (verificarCantidad(datos, 4, cont, error)) {

                        Tienda tienda1 = manager.getTiendaDAO().obtener(datos[1]);
                        if (tienda1 != null) {
                            tienda1 = manager.getTiendaDAO().obtener(datos[2]);
                            if (tienda1 != null) {
                                //ublic TiempoDeEnvio(int idTiempoDeEnvio, String tiempo, boolean estado) {
                                TiempoDeEnvio tiempoDeEnvio = new TiempoDeEnvio(1, Integer.valueOf(datos[datos.length - 1]), true, datos[2]);
                                manager.getTiempoDeEnvioDAO().insert(tiempoDeEnvio);
                                int idtiempo = manager.getTiempoDeEnvioDAO().lastInsertId();

                                TiempoEntreTiendas entreTiendas = new TiempoEntreTiendas(0, idtiempo, datos[1], "Origen");
                                manager.getTiempoEntreTiendasDAO().insert(entreTiendas);
                                entreTiendas = new TiempoEntreTiendas(0, idtiempo, datos[2], "Destino");
                                manager.getTiempoEntreTiendasDAO().insert(entreTiendas);

                                imprimirJTextArea(correcto, cont, instruccion, "Correcto");
                            } else {
                                imprimirJTextArea(error, cont, "Tiempo", "Error: Linea " + cont + " -> Debe Crear Primero la Tienda");
                                System.out.println("Error: Linea " + cont + " -> Debe Crear Primero la Tienda");
                            }
                        } else {
                            imprimirJTextArea(error, cont, "Tiempo", "Error: Linea " + cont + " -> Debe Crear Primero la Tienda");
                            System.out.println("Error: Linea " + cont + " -> Debe Crear Primero la Tienda");
                        }
                    }

                    break;
                case 5:
                    System.out.println("Pedido");

                    if (verificarCantidad(datos, 10, cont, error)) {
                        //Pedido perificarCantidad(datos, 9, coedido = new Pedido(data[0], fecha, true, cont, true, true, cont, CLIENTE);
                        Tienda tiendaPrueba = manager.getTiendaDAO().obtener(datos[2]);

                        if (tiendaPrueba != null) {
                            tiendaPrueba = manager.getTiendaDAO().obtener(datos[3]);
                            if (tiendaPrueba != null) {

                                if (existenciaSuficiente(datos[2], datos[6], Integer.valueOf(datos[7]))) {

                                    if (manager.getClienteDAO().obtener(datos[6]) != null) {

                                        if (manager.getPedidoDAO().obtener(datos[1]) != null) {
                                            //el pedido ya existe
                                            DetallePedido articulos = new DetallePedido(0, Integer.valueOf(datos[7]), true, datos[6], datos[1]);
                                            manager.getDetallePedidoDAO().insert(articulos);

                                            descontarPedido(datos[1], datos[5], Integer.valueOf(datos[7]));
                                            imprimirJTextArea(correcto, cont,  instruccion, "Correcto");

                                        } else {
                                            //  crea el pedido
                                            Integer envio = manager.getTiempoEntreTiendasDAO().getTiempoByTwoStore(datos[2], datos[3]);
                                            if (envio != null) {

                                                Pedido pedido = new Pedido(datos[1], java.sql.Date.valueOf(datos[4]), false, 0, false, true, envio, datos[6], BigDecimal.valueOf(Double.valueOf(datos[datos.length - 1])), BigDecimal.valueOf(Double.valueOf(datos[datos.length - 2])));
                                                DetallePedido articulos = new DetallePedido(0, Integer.valueOf(datos[7]), true, datos[6], datos[1]);

                                                manager.getPedidoDAO().insert(pedido);
                                                manager.getDetallePedidoDAO().insert(articulos);

                                                descontarPedido(datos[2], datos[6], Integer.valueOf(datos[7]));
                                                imprimirJTextArea(correcto, cont, instruccion, "Correcto");

                                            } else {
                                                imprimirJTextArea(error, cont,  instruccion, "Error: Linea " + cont + " -> Debe Crear Primero un Tiempo De Envio");
                                                System.out.println("Error: Linea " + cont + " -> Debe Crear Primero un Tiempo De Envio");
                                            }
                                        }
                                    } else {
                                        imprimirJTextArea(error, cont,  instruccion, "Error: Linea " + cont + " -> Debe Crear Primero Al Cliente");
                                        System.out.println("Error: Linea " + cont + " -> Debe Crear Primero Al Cliente");
                                    }
                                } else {
                                    imprimirJTextArea(error, cont,  instruccion, "Error: Linea " + cont + " -> Debe Verificar Existencias (Stock)");
                                    System.out.println("Error: Linea " + cont + " -> Verificar Existencia");
                                }

                            } else {
                                imprimirJTextArea(error, cont,  instruccion, "Error: Linea " + cont + " -> Debe Crear Primero La Tienda");
                                System.out.println("Error: Linea " + cont + " -> Debe Crear Primero la Tienda");
                            }
                        } else {
                            imprimirJTextArea(error, cont,  instruccion, "Error: Linea " + cont + " -> Debe Crear Primero La Tienda");
                            System.out.println("Error: Linea " + cont + " -> Debe Crear Primero la Tienda");
                        }
                    }

                    break;
                case 6:
                    System.out.println("Tienda: " + instruccion);

                    if (verificarCantidad(datos, 5, cont, error)) {

                        if (manager.getTiendaDAO().obtener(datos[3]) == null) {

                            Tienda tienda = new Tienda(datos[3], datos[1], datos[2], datos[4], "", "", "", true);
                            manager.getTiendaDAO().insert(tienda);
                            imprimirJTextArea(correcto, cont,  instruccion, "Correcto");
                           // imprimirJTextArea(correcto, cont, "TIENDA" + instruccion, "Correcto  Codigo"+datos[3]+" Nombre:"+datos[1]+"    >Direccion: "+datos[2]+"Telefono "+datos[4]);

                        } else {
                            imprimirJTextArea(error, cont, instruccion, "Error: Linea " + cont + " -> Existe Un Producto Similar");
                        }

                    }

                    break;
                case 7:

                    break;

            }
        } catch (Exception ex) {
            imprimirJTextArea(error, cont, ex.getMessage(), "Error Desconocido");
            System.out.println(ex.getMessage());
            //Logger.getLogger(Interprete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean verificarCantidad(String datos[], int cantidad, int cont, JTextArea error) {

        System.out.println("===================>" + datos.length);
        if (datos.length  == cantidad) {
            return true;
        }
        imprimirJTextArea(error, cont, "Cantidad De Parametros  ", "Finalizo lectura de Linea con Error");
        return false;

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
        stock.setCantidad(stock.getCantidad() - cantidadDeProducto);

        manager.getStockTiendaDAO().modify(stock);

    }

    public void imprimirJTextArea(JTextArea area, int cont, String instruccion, String tipoDeLectura) {
        area.setText(area.getText() + "\n" + "Linea " + cont + ": " + instruccion + " ..... " + tipoDeLectura);
    }

    public void imprimirError(JTextArea error) {

    }
}
