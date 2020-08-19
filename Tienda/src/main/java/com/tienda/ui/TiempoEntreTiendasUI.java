/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.ui;

import com.tienda.dto.TiendaTiempo;
import com.tienda.mysql.Manager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author julio
 */
public class TiempoEntreTiendasUI extends javax.swing.JPanel {

    /**
     * Creates new form TiempoEntreTiendasUI
     */
    public TiempoEntreTiendasUI() {
        initComponents();
        manager = new Manager();
        codigoOrigen = "";
        destino = "";
        sinTiempo = "";
        fillTable(manager.getTiendaDAO().getTiempoTiendaTET() , tableTienda, false);
        eventTableTienda();
        actionBuscarTxt();
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
        txtBuscarOrigen = new javax.swing.JTextField();
        btnBuscarOrigen = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableTiempoTienda = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableTienda = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSinTiempo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtBuscarDestino = new javax.swing.JTextField();
        btnBuscarDestino = new javax.swing.JButton();
        txtDestinoSinTiempo = new javax.swing.JTextField();
        btnBuscarDestSinTiempo = new javax.swing.JButton();

        btnBuscarOrigen.setText("Buscar");
        btnBuscarOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarOrigenActionPerformed(evt);
            }
        });

        tableTiempoTienda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo de Tienda", "Tienda", "Tiempo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableTiempoTienda);

        tableTienda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Tienda"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tableTienda);

        tableSinTiempo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Tienda"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableSinTiempo);

        jLabel1.setText("Tiempro Entre Tienda");

        jLabel2.setText("Tiendas sin Tiempo");

        jButton2.setText("Ver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Modificar");

        jButton4.setText("Crear Tiempo");

        btnBuscarDestino.setText("Buscar");
        btnBuscarDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarDestinoActionPerformed(evt);
            }
        });

        btnBuscarDestSinTiempo.setText("Buscar");
        btnBuscarDestSinTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarDestSinTiempoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtBuscarOrigen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarOrigen)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtBuscarDestino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarDestino)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDestinoSinTiempo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarDestSinTiempo)))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDestinoSinTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarDestSinTiempo))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscarDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarDestino))
                    .addComponent(txtBuscarOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarOrigen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarOrigenActionPerformed
        // TODO add your handling code here:
        fillTable(manager.getTiendaDAO().getTiempoTiendaTETUseLike(txtBuscarOrigen.getText()), tableTienda, false);
    }//GEN-LAST:event_btnBuscarOrigenActionPerformed

     private void actionBuscarTxt() {
        txtBuscarOrigen.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
               fillTable(manager.getTiendaDAO().getTiempoTiendaTETUseLike(txtBuscarOrigen.getText()), tableTienda, false);
            }

        });
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnBuscarDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarDestinoActionPerformed

    private void btnBuscarDestSinTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarDestSinTiempoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarDestSinTiempoActionPerformed

    public void eventTableTienda(){
        tableTienda.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evnt){
                if (evnt.getClickCount() == 2) {
                     int row = tableTienda.rowAtPoint(evnt.getPoint());
                     System.out.println("Row"+ row);
                   codigoOrigen = (String) tableTienda.getValueAt(row, 0);
                    fillTable(manager.getTiendaDAO().getTiempoTiendaTET(codigoOrigen), tableTiempoTienda, true);
                    
                }
            }
        });
    }
    public void fillTable(List<TiendaTiempo> tiendatiempo, JTable tableView, boolean withTiempo) {

        DefaultTableModel tableModel = (DefaultTableModel) tableView.getModel();
        tableModel.setNumRows(0);

        if (withTiempo) {
            tiendatiempo.forEach(tiendax -> {
                tableModel.addRow(new Object[]{
                    tiendax.getCodigo(),
                    tiendax.getTienda(),
                    tiendax.getTiempo()
                });
            });
        } else {

            tiendatiempo.forEach(tiendax -> {
                tableModel.addRow(new Object[]{
                    tiendax.getCodigo(),
                    tiendax.getTienda()});
            });
        }

        tableView.setModel(tableModel);

    }
    

    private String codigoOrigen;
    private String destino;
    private  String sinTiempo;
    private Manager manager;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarDestSinTiempo;
    private javax.swing.JButton btnBuscarDestino;
    private javax.swing.JButton btnBuscarOrigen;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tableSinTiempo;
    private javax.swing.JTable tableTiempoTienda;
    private javax.swing.JTable tableTienda;
    private javax.swing.JTextField txtBuscarDestino;
    private javax.swing.JTextField txtBuscarOrigen;
    private javax.swing.JTextField txtDestinoSinTiempo;
    // End of variables declaration//GEN-END:variables
}