/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.ui;

import com.tienda.dto.EmpleadoDTO;
import com.tienda.entities.Persona;
import com.tienda.entities.Usuario;
import com.tienda.mysql.Manager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author julio
 */
public class EmpleadoUI extends javax.swing.JPanel {

    /**
     * Creates new form CrearTienda
     */
    public EmpleadoUI() {
        initComponents();
        manager = new Manager();
        lblFieldCode.setVisible(false);
        lblFieldDIreccion.setVisible(false);
        lblFieldNombre.setVisible(false);
        lblFieldTelefono.setVisible(false);
        modificar = false;
        accionTable();
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
        lblCodigo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNit = new javax.swing.JTextField();
        txtDpi = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableView = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnVerTodo = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        lblFieldDIreccion = new javax.swing.JLabel();
        lblFieldCode = new javax.swing.JLabel();
        lblFieldNombre = new javax.swing.JLabel();
        lblFieldTelefono = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        txtCodigoUsuario = new javax.swing.JTextField();

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tienda"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCodigo.setFont(new java.awt.Font("Fira Code Light", 2, 16)); // NOI18N
        lblCodigo.setText("Dpi*");
        jPanel1.add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 54, -1, -1));

        lblNombre.setFont(new java.awt.Font("Fira Code Light", 2, 16)); // NOI18N
        lblNombre.setText("Nit");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, -1, -1));

        txtNit.setFont(new java.awt.Font("Dialog", 2, 16)); // NOI18N
        txtNit.setForeground(new java.awt.Color(0, 0, 0));
        txtNit.setBorder(null);
        jPanel1.add(txtNit, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 42, 160, 39));

        txtDpi.setFont(new java.awt.Font("Dialog", 2, 16)); // NOI18N
        txtDpi.setForeground(new java.awt.Color(0, 0, 0));
        txtDpi.setBorder(null);
        jPanel1.add(txtDpi, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 42, 160, 39));

        lblDireccion.setFont(new java.awt.Font("Fira Code Light", 2, 16)); // NOI18N
        lblDireccion.setText("Nombre*");
        jPanel1.add(lblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, -1, -1));

        txtNombre.setFont(new java.awt.Font("Dialog", 2, 16)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));
        txtNombre.setBorder(null);
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 116, 166, 39));

        lblTelefono.setFont(new java.awt.Font("Fira Code Light", 2, 16)); // NOI18N
        lblTelefono.setText("Telefono*");
        jPanel1.add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, -1, -1));

        txtTelefono.setFont(new java.awt.Font("Dialog", 2, 16)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(0, 0, 0));
        txtTelefono.setBorder(null);
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 166, 39));

        jLabel10.setFont(new java.awt.Font("Fira Code Light", 2, 16)); // NOI18N
        jLabel10.setText("Direccion");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 203, -1, -1));

        txtDireccion.setFont(new java.awt.Font("Dialog", 2, 16)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(0, 0, 0));
        txtDireccion.setBorder(null);
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 191, 160, 39));

        jLabel11.setFont(new java.awt.Font("Fira Code Light", 2, 16)); // NOI18N
        jLabel11.setText("Email");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, -1, -1));

        txtEmail.setFont(new java.awt.Font("Dialog", 2, 16)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(0, 0, 0));
        txtEmail.setBorder(null);
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 191, 166, 39));

        jLabel12.setFont(new java.awt.Font("Fira Code Light", 2, 16)); // NOI18N
        jLabel12.setText("Codigo Usuario");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 150, -1));

        tableView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dpi", "Nit", "Nombre", "Telefono", "Direccion", "Correo Electronico", "Codigo Usuario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableView.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tableView.setRowHeight(30);
        tableView.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableView.getTableHeader().setReorderingAllowed(false);
        tableView.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(tableView);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 870, 361));

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 324, 50));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, 324, 50));

        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 150, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, 324, 50));

        btnVerTodo.setText("Ver Todo");
        btnVerTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTodoActionPerformed(evt);
            }
        });
        jPanel1.add(btnVerTodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 324, -1));

        txtSearch.setBackground(new java.awt.Color(255, 255, 255));
        txtSearch.setFont(new java.awt.Font("Dialog", 2, 16)); // NOI18N
        txtSearch.setToolTipText("Buscar");
        txtSearch.setBorder(null);
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        jPanel1.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 310, 30));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 160, 10));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 78, 180, 0));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 82, 180, 10));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 170, 10));

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 340, 10));

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 160, 10));

        jSeparator7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 160, 10));

        jSeparator8.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 170, 10));

        jSeparator9.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 180, 10));

        lblFieldDIreccion.setForeground(new java.awt.Color(255, 0, 51));
        lblFieldDIreccion.setText("Campo Obligatorio");
        jPanel1.add(lblFieldDIreccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 170, -1));

        lblFieldCode.setForeground(new java.awt.Color(255, 0, 51));
        lblFieldCode.setText("Campo Obligatorio");
        jPanel1.add(lblFieldCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 170, 20));

        lblFieldNombre.setForeground(new java.awt.Color(255, 0, 51));
        lblFieldNombre.setText("Campo Obligatorio");
        jPanel1.add(lblFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 170, -1));

        lblFieldTelefono.setForeground(new java.awt.Color(255, 0, 51));
        lblFieldTelefono.setText("Campo Obligatorio");
        jPanel1.add(lblFieldTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 170, -1));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 324, 50));

        txtCodigoUsuario.setBackground(new java.awt.Color(255, 255, 255));
        txtCodigoUsuario.setFont(new java.awt.Font("Dialog", 2, 16)); // NOI18N
        txtCodigoUsuario.setBorder(null);
        jPanel1.add(txtCodigoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 160, 30));

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

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        setTextField("", "", "", "", "", "", "");
        modificar = false;
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (modificar) {
            if (checkDpiNit()) {

                if (checkField()) {

                    manager.getPersonaDAO().modify(crearPersona());
                    manager.getUsuarioDAO().modify(crearUsuario());

//                
//                
//                manager.getClienteDAO().insert(crearCliente());
                    JOptionPane.showMessageDialog(null, "Se Modifico Correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
//
                    DefaultTableModel tableModel = (DefaultTableModel) tableView.getModel();
                    tableModel.addRow(new Object[]{txtDpi.getText(), txtNit.getText(), txtNombre.getText(), txtTelefono.getText(), txtDireccion.getText(), txtEmail.getText(), txtCodigoUsuario.getText()});
                    tableModel.removeRow(row);
                    setTextField("", "", "", "", "", "", "");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Dpi o Nit No se pueden modifcar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }

        } else {
            if (checkDpiNit()) {

                if (checkField()) {

                    manager.getPersonaDAO().insert(crearPersona());
                    manager.getUsuarioDAO().insert(crearUsuario());
                    
                    JOptionPane.showMessageDialog(null, "Se ha Creado Correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
//
                    DefaultTableModel tableModel = (DefaultTableModel) tableView.getModel();
                    tableModel.addRow(new Object[]{txtDpi.getText(), txtNit.getText(), txtNombre.getText(), txtTelefono.getText(), txtDireccion.getText(), txtEmail.getText(), txtCodigoUsuario.getText()});
                    tableModel.removeRow(row);
                    setTextField("", "", "", "", "", "", "");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Dpi o Nit No se pueden modifcar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }
        modificar = false;
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnVerTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTodoActionPerformed
        // TODO add your handling code here:
        

        fillTable(manager.getEmpleadoDAO().getByUsuarioDTO());


    }//GEN-LAST:event_btnVerTodoActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
        
       // fillTable(manager.getClienteDAO().getClienteForDtoWhitLike(txtSearch.getText()));

    }//GEN-LAST:event_txtSearchActionPerformed

    public void fillTable(List<EmpleadoDTO> listadoEmpleados) {
        DefaultTableModel tableModel = (DefaultTableModel) tableView.getModel();
        tableModel.setNumRows(0);

        listadoEmpleados.forEach(tiendax -> {
            tableModel.addRow(new Object[]{
                tiendax.getDpi(),
                tiendax.getNit(),
                tiendax.getNombre(),
                tiendax.getTelefono(),
                tiendax.getDireccion(),
                tiendax.getEmail(),
                tiendax.getCodigoUsuario()});
        });

        tableView.setModel(tableModel);

    }
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:

        if (JOptionPane.showConfirmDialog(null, "Seguro que desea elimiar al Cliente\n Nit " + txtNit.getText() + "con Nombre: " + txtNombre.getText(), "Advertencia", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE) == 0) {
            //idUsuario, String usuario, String password, int tipo, boolean estado, String Persona_dpi,String email) {
            Usuario cliente = new Usuario (0, txtCodigoUsuario.getText(), txtNit.getText(), 2, false,txtDpi.getText(),txtEmail.getText());
            manager.getUsuarioDAO().modify(cliente);
            DefaultTableModel model = (DefaultTableModel) tableView.getModel();
            model.removeRow(row);
            setTextField("", "", "", "", "", "", "");
            JOptionPane.showMessageDialog(null, "Eliminacion exitosa", "Eliminar", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        // TODO add your handling code here:

         fillTable(manager.getEmpleadoDAO().getByUsuarioDTO());
    }//GEN-LAST:event_btBuscarActionPerformed
    
     private void actionBuscarTxt() {
        txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                 fillTable(manager.getEmpleadoDAO().getByUsuarioDTO());
            }

        });
    }
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        txtDpi.setEditable(true);
        txtEmail.setEditable(true);
        txtNit.setEditable(true);
        txtNombre.setEditable(true);

        txtTelefono.setEditable(true);
        txtDireccion.setEditable(true);
        txtCodigoUsuario.setEditable(true);
        modificar = true;
    }//GEN-LAST:event_btnModificarActionPerformed

    private void accionTable() {
        tableView.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                row = tableView.rowAtPoint(evt.getPoint());
                int col = tableView.columnAtPoint(evt.getPoint());

                dpi = (String) tableView.getModel().getValueAt(row, 0);
                nit = (String) tableView.getModel().getValueAt(row, 1);
                nombre = (String) tableView.getModel().getValueAt(row, 2);
                telefono = (String) tableView.getModel().getValueAt(row, 3);
                direccion = (String) tableView.getModel().getValueAt(row, 4);
                email = (String) tableView.getModel().getValueAt(row, 5);
                codigoUsuario = (String) tableView.getModel().getValueAt(row, 6);
                System.out.println("Codigo" + dpi);

                setTextField(dpi, nit, nombre, telefono, direccion, email, codigoUsuario);
            }
        });

    }

    private boolean checkDpiNit() {
        return manager.getPersonaDAO().obtener(txtDpi.getText()) == null && manager.getEmpleadoDAO().getByCodeUsr(txtCodigoUsuario.getText()) == null ;
    }

    private boolean checkField() {
        lblFieldCode.setVisible(txtDpi.getText().isEmpty());
        lblFieldDIreccion.setVisible(txtNombre.getText().isEmpty());
        lblFieldNombre.setVisible(txtNit.getText().isEmpty());
        lblFieldTelefono.setVisible(txtTelefono.getText().isEmpty());

        return !txtDpi.getText().isEmpty()
                && !txtNombre.getText().isEmpty()
                && !txtNit.getText().isEmpty()
                && !txtTelefono.getText().isEmpty();

    }

    private Usuario crearUsuario() {
        //return new Cliente(txtNit.getText(), txtEmail.getText(), true, txtDpi.getText(), (BigDecimal) ((Object) txtCredito.getText()));
        return new Usuario(0, txtCodigoUsuario.getText(), txtNit.getText(), 2, true, txtDpi.getText(), txtEmail.getText());
    }

    private Persona crearPersona() {
        //                                 String telefono, String direccion, boolean estado ){
        return new Persona(txtDpi.getText(), txtNombre.getText(), txtTelefono.getText(), txtDireccion.getText(), true);
    }

    private void setTextField(String codigo, String nombre, String direccion, String telefono, String telefono2, String email, String codigoUsuario) {
        txtDpi.setText(codigo);
        txtNit.setText(nombre);
        txtNombre.setText(direccion);
        txtTelefono.setText(telefono);
        txtDireccion.setText(telefono2);
        txtEmail.setText(email);
        txtCodigoUsuario.setText( codigoUsuario);
    }
    private int row;

    private Manager manager;

    private String dpi;
    private String nit;
    private String nombre;
    private String telefono;
    private String direccion;

    private String email;
    private boolean modificar;
    private String  codigoUsuario;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnVerTodo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFieldCode;
    private javax.swing.JLabel lblFieldDIreccion;
    private javax.swing.JLabel lblFieldNombre;
    private javax.swing.JLabel lblFieldTelefono;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTable tableView;
    private javax.swing.JTextField txtCodigoUsuario;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDpi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNit;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
