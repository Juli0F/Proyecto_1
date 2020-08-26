/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.ui;

import com.tienda.dto.TiendaTiempo;
import com.tienda.entities.Persona;
import com.tienda.entities.Tienda;
import com.tienda.entities.Usuario;
import com.tienda.mysql.Manager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author julio
 */
public final class Log extends javax.swing.JFrame {

    /**
     * Creates new form Log
     */
    public Log() {
        
      String [][] tabla =new String[10][5];
      
        System.out.println("10 = "+tabla.length+ "5 "+tabla[0].length);
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla.length; j++) {
                System.out.print("["+i+"],"+"["+j+"] ");
                
            }
            System.out.println("");
        }
        initComponents();
        manager = new Manager();
        empleadoC = false;
        eventTableTienda();
        setLocationRelativeTo(null);
        setSize(385, 178);

        eventLblCliente();
        txtBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
        
                accionBuscar();
            }

        });
        
        txtUsuario.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("Enter: "+KeyEvent.VK_ENTER+" KeyCode"+e.getKeyCode() );
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    logging();
                }
            }
            
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogo = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTiendas = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        btnViewAll = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblCrearCliente = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        dialogo.setModal(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Elegir tienda"));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Tienda"));

        btnSearch.setText("Buscar");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(txtBuscar)
                .addContainerGap())
        );

        tableTiendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Tienda"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTiendas.setRowHeight(45);
        tableTiendas.setRowMargin(2);
        jScrollPane1.setViewportView(tableTiendas);

        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnViewAll.setText("Ver Todo");
        btnViewAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnViewAll, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnViewAll))
                .addContainerGap())
        );

        javax.swing.GroupLayout dialogoLayout = new javax.swing.GroupLayout(dialogo.getContentPane());
        dialogo.getContentPane().setLayout(dialogoLayout);
        dialogoLayout.setHorizontalGroup(
            dialogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        dialogoLayout.setVerticalGroup(
            dialogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblCrearCliente.setText("Crear Cuenta Cliente");

        jLabel3.setText("Usuario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblCrearCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(lblCrearCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        logging();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnViewAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAllActionPerformed

        fillTable(manager.getTiendaDAO().obtenerTodo());
    }//GEN-LAST:event_btnViewAllActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        accionBuscar();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void accionBuscar() {
        if (txtBuscar.getText().isEmpty()) {
            fillTable(manager.getTiendaDAO().obtenerTodo());
        } else {
            fillTable(manager.getTiendaDAO().getAllTiendaLike(txtBuscar.getText()));
        }
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        actionBtnAceptar();
        System.out.println("Codigo: " + codigoTienda);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void logging() {

        if (manager.getEmpleadoDAO().verificarDatosInDB() != 0) {

            if (manager.getClienteDAO().obtener(txtUsuario.getText()) != null) {
                //es un cliente solo mostrar catalogo y tracking de producto

                empleadoC = false;
                nitLog = txtUsuario.getText();
                new MainFrame(empleadoC).setVisible(true);
                idUsuario = 1;
                
                this.dispose();
            } else if (manager.getEmpleadoDAO().getByCodeUsr(txtUsuario.getText()) != null) {
                
                empleadoC = true;
                this.setVisible(false);
                dialogo.setSize(750, 650);
                dialogo.setVisible(true);

                idUsuario = 1;
                this.dispose();
                //es Empleado mostrar todas las funciones    
            } else {

                JOptionPane.showMessageDialog(null, "Datos No Coinciden o No existe", "Advertencia", JOptionPane.WARNING_MESSAGE);

            }
        } else {
            if (txtUsuario.getText().equals("Admin")) {
                Persona persona = new Persona("dpi_test", "Persona", "", "", true);
                Usuario usuario = new Usuario(1, "usuario", "sinPassword", 3, true, "dpi_test", "");
                
                manager.getPersonaDAO().insert(persona);
                manager.getUsuarioDAO().insert(usuario);
                new MainFrame(true).setVisible(true);
            }
        }
    }

    private void actionBtnAceptar() {
        if (tableTiendas.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Debe Elegir una tienda", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int rowSelected = tableTiendas.getSelectedRow();
            codigoTienda = (String) tableTiendas.getValueAt(rowSelected, 0);
            nombreTienda = (String) tableTiendas.getValueAt(rowSelected, 1);
            System.out.println("Codigo Tienda: "+codigoTienda);
            dialogo.dispose();
            new MainFrame(empleadoC).
                    setVisible(true);
        }
    }

    private void eventTableTienda() {
        tableTiendas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                actionBtnAceptar();
            }

        });

    }

    private void fillTable(List<Tienda> tiendas) {

        ((DefaultTableModel) tableTiendas.getModel()).setRowCount(0);

        for (Tienda tienda : tiendas) {
            ((DefaultTableModel) tableTiendas.getModel()).addRow(new Object[]{
                tienda.getCodigo(),
                tienda.getNombre()
            });
        }

    }

    public void eventLblCliente(){
        lblCrearCliente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    if (manager.getEmpleadoDAO().verificarDatosInDB() != 0 ) {
                        JOptionPane.showMessageDialog(null, "Para Crear Cuenta debe acercarse a su Tienda Mas Cercana", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "Esta Opcion no esta habilitada en Este momento", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Log.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Log.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Log.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Log.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Log().setVisible(true);
            }
        });
    }

    public static String nitLog;
    public static int idUsuario;
    public static String codigoTienda;
    public static String nombreTienda;
    private boolean empleadoC;
    private Manager manager;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnViewAll;
    private javax.swing.JDialog dialogo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCrearCliente;
    private javax.swing.JTable tableTiendas;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
