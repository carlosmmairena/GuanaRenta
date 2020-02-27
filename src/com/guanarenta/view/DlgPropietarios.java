
/*
 * Clase que contiene la funcionalidad de obtener, modificar, eliminar y editar los propietarios
 */
package com.guanarenta.view;

import com.guanarenta.clases.Propietario;
import com.guanarenta.storage.StoragePropietarios;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ander Narvaez
 * @author Carlos Mairena
 */
public class DlgPropietarios extends javax.swing.JDialog {

    StoragePropietarios storagePropietario;
    Propietario propietario;

    String ENCABEZADO_TABLA[];
    DefaultTableModel propietariosTabla;
    private int inPro;

    /**
     * Creates new form DlgPropietarios
     *
     * @param parent
     * @param modal
     */
    public DlgPropietarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * Constructor que se utilizará para abrir este Dialog desde el menú principal
     *
     * @param parent
     * @param modal
     * @param storagePropietario
     */
    public DlgPropietarios(java.awt.Frame parent, boolean modal, StoragePropietarios storagePropietario) {
        super(parent, modal);
        initComponents();
        this.propietario = new Propietario();
        this.storagePropietario = storagePropietario;
    }

    /**
     * Constructor que se utilizará para abrir este dialog desde las viviendas al intentar seleccionar un propietario
     *
     * @param parent
     * @param modal
     * @param storagePropietario
     * @param inPro
     */
    public DlgPropietarios(java.awt.Frame parent, boolean modal, StoragePropietarios storagePropietario, int inPro) {
        super(parent, modal);
        initComponents();
        this.propietario = new Propietario();
        this.storagePropietario = storagePropietario;
        this.inPro = inPro;
        tbdPropietarios.setTitleAt(0, "Seleccionar");
        tblPropietarios.setToolTipText("Haga doble click en un propietaro para seleccionarlo");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngGeneros = new javax.swing.ButtonGroup();
        tbdPropietarios = new javax.swing.JTabbedPane();
        pnlBaseTablaPropietarios = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPropietarios = new javax.swing.JTable();
        lblTituloPropietarios = new javax.swing.JLabel();
        pnlOpcionesPropietarios = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnInicio = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        pnlBasePropietario = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        lblGenero = new javax.swing.JLabel();
        rdbF = new javax.swing.JRadioButton();
        rdbM = new javax.swing.JRadioButton();
        txtEmail = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        lblTelefono = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnLimpiarCampos = new javax.swing.JButton();
        txtTelefono = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GuanaRenta - Propietarios");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tbdPropietarios.setPreferredSize(new java.awt.Dimension(1122, 501));

        pnlBaseTablaPropietarios.setBackground(new java.awt.Color(254, 254, 254));

        tblPropietarios.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tblPropietarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblPropietarios.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblPropietarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblPropietarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPropietariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPropietarios);

        lblTituloPropietarios.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblTituloPropietarios.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTituloPropietarios.setText("Buscar nombre:");

        pnlOpcionesPropietarios.setBackground(new java.awt.Color(254, 254, 254));
        pnlOpcionesPropietarios.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        btnNuevo.setBackground(new java.awt.Color(225, 241, 249));
        btnNuevo.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/guanarenta/img/add.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(225, 241, 249));
        btnEliminar.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/guanarenta/img/delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(225, 241, 249));
        btnEditar.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/guanarenta/img/edit.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnInicio.setBackground(new java.awt.Color(225, 241, 249));
        btnInicio.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/guanarenta/img/back.png"))); // NOI18N
        btnInicio.setText("Regresar");
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlOpcionesPropietariosLayout = new javax.swing.GroupLayout(pnlOpcionesPropietarios);
        pnlOpcionesPropietarios.setLayout(pnlOpcionesPropietariosLayout);
        pnlOpcionesPropietariosLayout.setHorizontalGroup(
            pnlOpcionesPropietariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOpcionesPropietariosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        pnlOpcionesPropietariosLayout.setVerticalGroup(
            pnlOpcionesPropietariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOpcionesPropietariosLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(pnlOpcionesPropietariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout pnlBaseTablaPropietariosLayout = new javax.swing.GroupLayout(pnlBaseTablaPropietarios);
        pnlBaseTablaPropietarios.setLayout(pnlBaseTablaPropietariosLayout);
        pnlBaseTablaPropietariosLayout.setHorizontalGroup(
            pnlBaseTablaPropietariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBaseTablaPropietariosLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlBaseTablaPropietariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBaseTablaPropietariosLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 935, Short.MAX_VALUE)
                        .addGap(29, 29, 29))
                    .addGroup(pnlBaseTablaPropietariosLayout.createSequentialGroup()
                        .addComponent(lblTituloPropietarios, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlOpcionesPropietarios, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))))
            .addGroup(pnlBaseTablaPropietariosLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlBaseTablaPropietariosLayout.setVerticalGroup(
            pnlBaseTablaPropietariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBaseTablaPropietariosLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(pnlBaseTablaPropietariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBaseTablaPropietariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTituloPropietarios, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlOpcionesPropietarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tbdPropietarios.addTab("Propietarios", pnlBaseTablaPropietarios);

        pnlBasePropietario.setBackground(new java.awt.Color(254, 254, 254));

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombre.setText("Nombre");

        lblCedula.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCedula.setText("Num.Cedula");

        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });

        lblGenero.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGenero.setText("Genero");

        btngGeneros.add(rdbF);
        rdbF.setText("Femenino");

        btngGeneros.add(rdbM);
        rdbM.setText("Masculino");

        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEmail.setText("E-mail");

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/guanarenta/img/save.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lblTelefono.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTelefono.setText("Teléfono");

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/guanarenta/img/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnLimpiarCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/guanarenta/img/clean.png"))); // NOI18N
        btnLimpiarCampos.setText("Limpiar Campos");
        btnLimpiarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCamposActionPerformed(evt);
            }
        });

        try {
            txtTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("+506-####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout pnlBasePropietarioLayout = new javax.swing.GroupLayout(pnlBasePropietario);
        pnlBasePropietario.setLayout(pnlBasePropietarioLayout);
        pnlBasePropietarioLayout.setHorizontalGroup(
            pnlBasePropietarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBasePropietarioLayout.createSequentialGroup()
                .addContainerGap(226, Short.MAX_VALUE)
                .addGroup(pnlBasePropietarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBasePropietarioLayout.createSequentialGroup()
                        .addGroup(pnlBasePropietarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblGenero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCedula, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBasePropietarioLayout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)))
                .addGroup(pnlBasePropietarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBasePropietarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtCedula)
                        .addComponent(txtEmail)
                        .addComponent(txtNombre)
                        .addGroup(pnlBasePropietarioLayout.createSequentialGroup()
                            .addComponent(rdbF)
                            .addGap(18, 18, 18)
                            .addComponent(rdbM))
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBasePropietarioLayout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnLimpiarCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(157, 157, 157))
        );
        pnlBasePropietarioLayout.setVerticalGroup(
            pnlBasePropietarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBasePropietarioLayout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(pnlBasePropietarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlBasePropietarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCedula)
                    .addComponent(lblCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlBasePropietarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlBasePropietarioLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBasePropietarioLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlBasePropietarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdbM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdbF, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14)
                .addGroup(pnlBasePropietarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnlBasePropietarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEmail))
                .addGap(59, 59, 59)
                .addGroup(pnlBasePropietarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiarCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73))
        );

        tbdPropietarios.addTab("Añadir", pnlBasePropietario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tbdPropietarios, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbdPropietarios, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        // Solo acepta numeros
        char tecla;
        tecla = evt.getKeyChar();
        if (!Character.isDigit(tecla) && tecla != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
        }

    }//GEN-LAST:event_txtCedulaKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // Magia del botón cuando se empieza agregar el botón

        if (this.verificarDatos()) { // Verificamos de que no hayan espacios en blanco

            try {

                this.propietario = new Propietario(); // Inicializamos el objeto propietario
                this.propietario.setNombre(this.txtNombre.getText());
                this.propietario.setGenero(this.obtenerGenero());
                this.propietario.setCorrero(this.txtEmail.getText());
                this.propietario.setTelefono(this.txtTelefono.getText());

                if (tbdPropietarios.getTitleAt(1).equalsIgnoreCase("Añadir")) { // Si el título dice añadir, entonces guardamos al propietario

                    // Antes de todo, comprobamos de que la cédula que ingresaron sea diferente con las que ya están registradas
                    if (storagePropietario.comprobarCédula(Long.parseLong(this.txtCedula.getText()))) {  /**/

                        this.propietario.setCedula(Long.parseLong(this.txtCedula.getText()));
                        
                        this.storagePropietario.guardaPropietario(propietario); /**/
                        this.rellenarTabla(); // Rellenamos/Actualizamos la tabla
                        this.limpiarCampos(); // Limpiamos los campos
                        this.cambiarPestañaT(); // Cambiamos la pestaña

                    } else { // En caso de que la cédula ya haya sido registrada

                        JOptionPane.showMessageDialog(this, "Esta cédula ya fue registrada");
                        txtCedula.setText("");

                    }

                } else { // Si el título no dice Añadir, entonces es editar

                    this.propietario.setCedula(Long.parseLong(this.txtCedula.getText()));
                    int index = tblPropietarios.getSelectedRow(); // Obtenemos el índice la tabla seleccionada
                    
                     /**/
                    this.storagePropietario.editarPropietario(index, propietario); // Enviamos el objeto propietario con su índice obtenido
                    this.rellenarTabla(); // Rellenamos/Actualizamos la tabla
                    this.limpiarCampos(); // Limpiamos los campos
                    this.cambiarPestañaT(); // Cambiamos la pestaña

                }

            } catch (NumberFormatException es) { // En caso de que hayan ingresado mal los datos

                JOptionPane.showMessageDialog(this, "Por favor ingrese correctamente los datos");
                System.out.println(es.getCause());

            }
        } else { // En caso de que hayan campos en blanco
            JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos");
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // Al momento de que den al botón de nuevo
        tbdPropietarios.setTitleAt(1, "Añadir");
        this.cambiarPestañaEN();

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // Solo acepta letras
        char tecla;
        tecla = evt.getKeyChar();
        if (Character.isDigit(tecla) && tecla != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
        }

    }//GEN-LAST:event_txtNombreKeyTyped

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // Cuando la ventana se abre
        tbdPropietarios.setEnabledAt(1, false);
        this.rellenarTabla();

    }//GEN-LAST:event_formWindowOpened

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // Botón que llama al método que elimina un propietario enviándole un índice
        try {
            int index = tblPropietarios.getSelectedRow();
            this.storagePropietario.borrarPropietario(index);
            this.rellenarTabla();
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "Por favor asegúrese de seleccionar un propietario");
            System.out.println(ex.getCause());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // Botón que obtiene los datos de la ventana
        try {
            this.limpiarCampos();
            int index = tblPropietarios.getSelectedRow();
            this.propietario = new Propietario();

            this.propietario = this.storagePropietario.obtenerPropietario(index);
            txtNombre.setText(this.propietario.getNombre());
            txtCedula.setText(Long.toString(this.propietario.getCedula()));
            txtEmail.setText(propietario.getCorrero());
            txtTelefono.setText(propietario.getTelefono());

            if (propietario.getGenero() == 'F') {
                rdbF.setSelected(true);
            } else {
                rdbM.setSelected(true);
            }

            tbdPropietarios.setTitleAt(1, "Editar");
            this.cambiarPestañaEN();

        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "Por favor asegúrese de seleccionar un propietario");
            System.out.println(ex.getCause());
        }

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // Regresa a la pestaña anterior
        this.limpiarCampos();
        this.cambiarPestañaT();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnLimpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCamposActionPerformed
        // Botón que permite limpiar los campos
        this.limpiarCampos();
    }//GEN-LAST:event_btnLimpiarCamposActionPerformed

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // Solo acepta numeros
        char tecla;
        tecla = evt.getKeyChar();
        if (!Character.isDigit(tecla) && tecla != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
        }

    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        // Cerramos la ventana
        this.dispose();

    }//GEN-LAST:event_btnInicioActionPerformed

    private void tblPropietariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPropietariosMouseClicked
        // Si el título de la pestaña dice "Selecciona" y la cantidad de clicks es de 2, entonces obtiene el índice y cierra la ventana
        if (evt.getClickCount() == 2 && tbdPropietarios.getTitleAt(0).equals("Seleccionar")) {
            inPro = tblPropietarios.getSelectedRow();
            System.out.println("Se ha seleccionado el propietario: " + storagePropietario.obtenerPropietario(inPro).getNombre());
            this.dispose();
        }

    }//GEN-LAST:event_tblPropietariosMouseClicked

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        // TODO add your handling code here:
        this.ENCABEZADO_TABLA = new String[]{"Nombre", "Cédula", "Género", "E-mail", "Teléfono"};
        this.propietario = new Propietario();
        // Creamos el modelo restringiendo que se editen sus celdas.
        this.propietariosTabla = new DefaultTableModel(null, this.ENCABEZADO_TABLA) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };

        if (txtBuscar.getText().length() == 0) {

            this.rellenarTabla();

        } else {
            for (byte i = 0; i < storagePropietario.getTotal(); i++) {

                this.propietario = storagePropietario.obtenerPropietario(i);
                if (propietario.getNombre().regionMatches(true, 0, txtBuscar.getText(), 0, txtBuscar.getText().length())) {

                    Object registro[] = {this.propietario.getNombre(), this.propietario.getCedula(), this.propietario.getGenero(),
                        this.propietario.getCorrero(), this.propietario.getTelefono()};

                    this.propietariosTabla.addRow(registro);

                }
            }
            tblPropietarios.setModel(propietariosTabla);
        }
    }//GEN-LAST:event_txtBuscarKeyTyped
    

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
            java.util.logging.Logger.getLogger(DlgPropietarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgPropietarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgPropietarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgPropietarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgPropietarios dialog = new DlgPropietarios(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnLimpiarCampos;
    private javax.swing.JButton btnNuevo;
    private javax.swing.ButtonGroup btngGeneros;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTituloPropietarios;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pnlBasePropietario;
    private javax.swing.JPanel pnlBaseTablaPropietarios;
    private javax.swing.JPanel pnlOpcionesPropietarios;
    private javax.swing.JRadioButton rdbF;
    private javax.swing.JRadioButton rdbM;
    private javax.swing.JTabbedPane tbdPropietarios;
    private javax.swing.JTable tblPropietarios;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JFormattedTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    
    /**
     * Método que cambia de pestaña de la tabla
     */
    private void cambiarPestañaT() {
        tbdPropietarios.setEnabledAt(0, true);
        tbdPropietarios.setSelectedIndex(0);
        tbdPropietarios.setEnabledAt(1, false);
    }

    /**
     * Método que cambia de pestaña a editar/nuevo
     */
    private void cambiarPestañaEN() {
        tbdPropietarios.setEnabledAt(1, true);
        tbdPropietarios.setSelectedIndex(1);
        tbdPropietarios.setEnabledAt(0, false);
    }

    /**
     * Método que limpia los campos
     */
    private void limpiarCampos() {

        btngGeneros.clearSelection();

        txtCedula.setText("");
        txtEmail.setText("");
        txtNombre.setText("");
        txtTelefono.setText(null);
        //txtTelefono.repaint();

    }

    /**
     * Método para rellenar la tabla
     */
    private void rellenarTabla() {

        this.ENCABEZADO_TABLA = new String[]{"Nombre", "Cédula", "Género", "E-mail", "Teléfono"};
        this.propietario = new Propietario();
        // Creamos el modelo restringiendo que se editen sus celdas.
        this.propietariosTabla = new DefaultTableModel(null, this.ENCABEZADO_TABLA) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };

        for (byte i = 0; i < storagePropietario.getTotal(); i++) {

            this.propietario = storagePropietario.obtenerPropietario(i);

            Object registro[] = {this.propietario.getNombre(), this.propietario.getCedula(), this.propietario.getGenero(),
                this.propietario.getCorrero(), this.propietario.getTelefono()};

            this.propietariosTabla.addRow(registro);

        }

        this.tblPropietarios.setModel(this.propietariosTabla);
        lblTotal.setText("Total de propietarios: " + storagePropietario.getTotal());

    }

    /**
     *
     * Método que devuelve el tipo de género del/la propietaria
     *
     * @return F Equivale a Femenino |
     * @return M Equivale a Masculino
     */
    private char obtenerGenero() {
        if (rdbF.isSelected()) {
            return rdbF.getText().charAt(0);
        } else if (rdbM.isSelected()) {
            return rdbM.getText().charAt(0);
        } else {
            return 'N';
        }
    }

    /**
     * Método para comprobar si se ha ingresado todos los datos
     */
    private boolean verificarDatos() {
        return obtenerGenero() != 'N' && !txtCedula.getText().isEmpty() && !txtNombre.getText().isEmpty()
                && !txtEmail.getText().isEmpty() && !txtTelefono.getText().isEmpty();

    }
    
    public int getInPro() {
        return inPro;
    }

    public void setInPro(int inPro) {
        this.inPro = inPro;
    }
    
    
    //*****************************************************************************************//
    
    private void guardarPropietario(Propietario propiet){
        
        
        
        
    }
    
}
