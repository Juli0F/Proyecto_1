/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.reporte.ui;

import com.mysql.cj.result.LocalDateTimeValueFactory;
import com.tienda.dto.DetallePedidoProducto;
import com.tienda.dto.TiendaRepUno;
import com.tienda.mysql.Manager;
import com.tienda.ui.Log;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author julio
 */
public class PedidosQueLlegaran extends javax.swing.JPanel {

    /**
     * Creates new form PedidosQueLlegaran
     */
    public PedidosQueLlegaran() {
        initComponents();
        
        this.manager = new Manager();
        lblDatosTienda.setText("Codigo: " + Log.codigoTienda + ", Nombre: " + Log.nombreTienda);
        eventTablePrincipal();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePrincipal = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txtDateInit = new javax.swing.JFormattedTextField();
        txtDateFinal = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        lblDatosTienda = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDescripcion = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Reporte Pedidos Que llegaran"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablePrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Codigo Pedido", "Total", "Fecha De Pedido"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablePrincipal);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 734, 391));

        jButton1.setFont(new java.awt.Font("Dialog", 2, 18)); // NOI18N
        jButton1.setText("Exportar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 590, 233, 56));

        txtDateInit.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        jPanel1.add(txtDateInit, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 170, 48));

        txtDateFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM))));
        jPanel1.add(txtDateFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 207, 48));

        jLabel1.setText("De");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 30, 48));

        jLabel2.setText("Rango De Fecha con formato ddd/mm/aa");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 333, 39));

        jLabel3.setText("al");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 46, 48));

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, -1, 50));

        lblDatosTienda.setFont(new java.awt.Font("Dialog", 2, 18)); // NOI18N
        jPanel1.add(lblDatosTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 760, 60));

        tableDescripcion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Producto", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableDescripcion);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 180, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1262, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.reporte = null;
        
        
        this.reporte = new ArrayList<>();
        
        if (txtDateInit.getText().isEmpty()) {
            if (txtDateFinal.getText().isEmpty()) {

                reporte.addAll(manager.getTiendaDAO().pedidosSinFecha(Log.codigoTienda));
                verificar();

            } else {
                
                String[] fecha = txtDateFinal.getText().split("/");
               
               /// LocalDate date = LocalDate.parse(txtDateFinal.getText(),DateTimeFormatter.ofPattern("d/MMM/yyyy "));
                System.out.println("==> fecha: "+fecha.length );
                LocalDate lacalDate = LocalDate.of(Integer.valueOf(fecha[2]), Integer.valueOf(fecha[1]), Integer.valueOf(fecha[0]));
                reporte.addAll(manager.getTiendaDAO().pedidosFechaFinal(Log.codigoTienda, java.sql.Date.valueOf(lacalDate)));
                verificar();

            }
        } else {
            if (txtDateFinal.getText().isEmpty()) {

                String[] fecha = txtDateInit.getText().split("/");
                System.out.println("==> fecha: "+fecha.length );
                for (int i = 0; i < fecha.length; i++) {
                    System.out.println("indice [" +i+"]"+fecha[i] );
                    
                }
                LocalDate lacalDate = LocalDate.of(Integer.valueOf(fecha[2]), Integer.valueOf(fecha[1]), Integer.valueOf(fecha[0]));

                //LocalDate lacalDate =  LocalDate.parse(txtDateInit.getText());
                reporte.addAll(manager.getTiendaDAO().pedidosFechaInicial(Log.codigoTienda, java.sql.Date.valueOf(lacalDate)));
                verificar();

            } else {

                String[] fechaInit = txtDateInit.getText().split("/");
                System.out.println("==> fecha: "+fechaInit.length );
                LocalDate lacalDate = LocalDate.of(Integer.valueOf(fechaInit[2]), Integer.valueOf(fechaInit[1]), Integer.valueOf(fechaInit[0]));

                String[] fechaFinal = txtDateFinal.getText().split("/");
                System.out.println("==> fecha: "+fechaFinal.length );
                LocalDate localDateFinal = LocalDate.of(Integer.valueOf(fechaFinal[2]), Integer.valueOf(fechaFinal[1]), Integer.valueOf(fechaFinal[0]));

                
                reporte.addAll(manager.getTiendaDAO().pedidosEntreFechas(Log.codigoTienda, java.sql.Date.valueOf(lacalDate), java.sql.Date.valueOf(localDateFinal)));
                verificar();

            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

     public void verificar() {

        if (reporte != null) {
             
             fillTable(reporte);
        }else{
             JOptionPane.showMessageDialog(null, "No Hay Datos Para Mostrar", "informacion", JOptionPane.INFORMATION_MESSAGE);
         }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Guardar reporte = new Guardar();
        reporte.guardarEn();
    }//GEN-LAST:event_jButton1ActionPerformed

     public void eventTablePrincipal() {
        tablePrincipal.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
                    descripcionPedido = new ArrayList<>();
                    String codigoPedido = (String) tablePrincipal.getValueAt(tablePrincipal.getSelectedRow(), 2);
                    descripcionPedido.addAll(manager.getDetallePedidoDAO().getCodigoProductoCantidad(codigoPedido));
                }
            }

        });
    }

    public void fillTableDescripcion(List<DetallePedidoProducto> detalles) {
        ((DefaultTableModel) tableDescripcion.getModel()).setRowCount(0);
        detalles.forEach(x -> {
            ((DefaultTableModel) tableDescripcion.getModel()).addRow(new Object[]{
                x.getCodigo(),
                x.getProducto(),
                x.getCantidad()
                
            });
        }
        );

    }

    public void fillTable(List<TiendaRepUno> pedidos) {
        ((DefaultTableModel) tablePrincipal.getModel()).setRowCount(0);

        pedidos.forEach(pedido -> {
            ((DefaultTableModel) tablePrincipal.getModel()).addRow(new Object[]{
                pedido.getCodigoTienda(),
                pedido.getNombre(),
                pedido.getCodigoPedido(),
                pedido.getTotal(),
                pedido.getFecha()

            });
        });
    }
    private List<DetallePedidoProducto> descripcionPedido;
    private Manager manager;
    private List<TiendaRepUno> reporte;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDatosTienda;
    private javax.swing.JTable tableDescripcion;
    private javax.swing.JTable tablePrincipal;
    private javax.swing.JFormattedTextField txtDateFinal;
    private javax.swing.JFormattedTextField txtDateInit;
    // End of variables declaration//GEN-END:variables
}
