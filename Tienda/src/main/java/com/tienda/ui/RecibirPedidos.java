/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.ui;

import com.tienda.actiontable.DateLabelFormatter;
import com.tienda.entities.Pedido;
import com.tienda.mysql.Manager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author julio
 */
public final class RecibirPedidos extends javax.swing.JPanel {

    /**
     * Creates new form RecibirPedidos
     */
    public RecibirPedidos() {
        initComponents();
        txtBuscarEvent();
        eventTablePedidosAEntregar();
        initDatePicker();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablePedidosRecibidos = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnRecibir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePedidosAEntregar = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        btnVerTodo = new javax.swing.JButton();
        btnTerminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablePedidosRecibidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Anticipo", "Total", "Fecha Del Pedido", "Nit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablePedidosRecibidos);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(494, 94, -1, -1));
        add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 26, 356, 35));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 28, -1, 39));

        btnRecibir.setText("Recibir Producto");
        btnRecibir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecibirActionPerformed(evt);
            }
        });
        add(btnRecibir, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 520, 161, 41));

        tablePedidosAEntregar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Anticipo", "Total", "Fecha Del Pedido", "Nit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablePedidosAEntregar);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 94, -1, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(644, 525, 152, -1));

        btnVerTodo.setText("Ver Todo");
        btnVerTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTodoActionPerformed(evt);
            }
        });
        add(btnVerTodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 525, 126, -1));

        btnTerminar.setText("Terminar de Recibir");
        btnTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarActionPerformed(evt);
            }
        });
        add(btnTerminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(421, 567, 168, 43));

        jLabel1.setText("Fecha en la Que se recibe");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 180, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnVerTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTodoActionPerformed

        fillTablePedidosAEntregar(manager.getPedidoDAO().sinEntregarEnDestino());
    }//GEN-LAST:event_btnVerTodoActionPerformed

    private void btnRecibirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecibirActionPerformed
        
        pedidoAEntregar();

    }//GEN-LAST:event_btnRecibirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here
        deletePedidoRecibido();


    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarActionPerformed
        

        System.out.println("Local");
        if (txtDatePicker.getModel().getValue() != null) {
            if (tablePedidosRecibidos.getRowCount() != 0) {
                recibirPedido();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fecha de entrada de los pedidos", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnTerminarActionPerformed

    public void recibirPedido() {

        for (int i = 0; i < tablePedidosRecibidos.getRowCount(); i++) {

            Pedido aRecibir = manager.getPedidoDAO().obtener((String) tablePedidosRecibidos.getValueAt(i, 0));
            int diasPrometidosDeEntrega = manager.getTiempoDeEnvioDAO().obtener(aRecibir.getTiempoDeEnvio_idTiempoDeEnvio()).getTiempo();
            int diasQueSeTardo = calcularDias(aRecibir.getFecha(), (Date) txtDatePicker.getModel().getValue());
            if (diasPrometidosDeEntrega < diasQueSeTardo) {

                aRecibir.setRetraso(0);

            } else {

                aRecibir.setRetraso(diasQueSeTardo - diasPrometidosDeEntrega);

            }
            aRecibir.setDestino(true);
            manager.getPedidoDAO().modify(aRecibir);

        }
        JOptionPane.showMessageDialog(null, "Se ha Registrado la llegada de Pedidos", "Informacion", JOptionPane.INFORMATION_MESSAGE);
    }

    public int calcularDias(Date pedido, Date entrega) {

        long pedidoLong = pedido.getTime();
        long entregaLong = entrega.getTime();

        int dias = (int) ((Math.abs(pedidoLong - entregaLong) / (1000 * 3600 * 24)));

        return dias;

    }

    public void eventTablePedidoRecibido() {
        tablePedidosRecibidos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {

                    deletePedidoRecibido();
                }
            }

        });
    }

    public void deletePedidoRecibido() {
        if (tablePedidosRecibidos.getSelectedRow() != -1) {
            ((DefaultTableModel) tablePedidosRecibidos.getModel()).removeRow(tablePedidosRecibidos.getSelectedRow());

        }
    }

    public void eventTablePedidosAEntregar() {
        tablePedidosAEntregar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    pedidoAEntregar();

                }
            }

        });
    }

    public void pedidoAEntregar() {
        if (tablePedidosAEntregar.getSelectedRow() != -1) {

            for (int i = 0; i < 5; i++) {

                ((DefaultTableModel) tablePedidosRecibidos.getModel()).addRow(new Object[]{
                    tablePedidosAEntregar.getValueAt(i, 0),
                    tablePedidosAEntregar.getValueAt(i, 1),
                    tablePedidosAEntregar.getValueAt(i, 2),
                    tablePedidosAEntregar.getValueAt(i, 3),
                    tablePedidosAEntregar.getValueAt(i, 4),});

            }
        }
    }

    public void fillTablePedidosAEntregar(List<Pedido> pedidos) {

        ((DefaultTableModel) tablePedidosAEntregar.getModel()).setRowCount(0);

        pedidos.forEach(pedido -> {
            ((DefaultTableModel) tablePedidosAEntregar.getModel()).addRow(new Object[]{
                pedido.getCodigo(),
                pedido.getAnticipo(),
                pedido.getSubtotal(),
                pedido.getFecha(),
                pedido.getCliente_nit()
            });
        });
    }

    private void txtBuscarEvent() {
        txtBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                fillTablePedidosAEntregar(manager.getPedidoDAO().buscarCoincidenciaSinEntregarEnDestino(txtBuscar.getText()));
            }

        });
    }

    public void initDatePicker() {
        UtilDateModel model = new UtilDateModel();

        model.setDate(2020, 8, 1);

        Properties p = new Properties();
        p.put("text.today", "Hoy");
        p.put("text.month", "Mes");
        p.put("text.year", "Anio");

        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        txtDatePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        txtDatePicker.setVisible(true);
        //this.add(txtDatePicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 80, 210, 40));
        add(txtDatePicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 230, 50));
        //this.add(txtDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE);
    }
    private JDatePickerImpl txtDatePicker;
    private Manager manager;
//.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRecibir;
    private javax.swing.JButton btnTerminar;
    private javax.swing.JButton btnVerTodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablePedidosAEntregar;
    private javax.swing.JTable tablePedidosRecibidos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
