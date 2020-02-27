/*
 * Esta clase es el módulo de las ganancias
 */
package com.guanarenta.view;

import com.guanarenta.storage.StorageAlquileres;
import com.guanarenta.storage.StorageMensualidades;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Sharlene Guadamuz
 * @author Carlos Mairena
 */
public class DlgGanancias extends javax.swing.JDialog {

    StorageAlquileres storageAlquileres;
    StorageMensualidades storageMensualidades;

    /**
     * Creates new form DlgGanancias
     *
     * @param parent
     * @param modal
     */
    public DlgGanancias(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.storageAlquileres = new StorageAlquileres();
        this.storageMensualidades = new StorageMensualidades();
    }

    /**
     * Método constructor para pasar los alquileres y mensualidades
     *
     * @param parent
     * @param modal
     * @param storageAlquileres
     * @param storageMensualidades
     */
    public DlgGanancias(java.awt.Frame parent, boolean modal, StorageAlquileres storageAlquileres, StorageMensualidades storageMensualidades) {
        super(parent, modal);
        initComponents();
        this.storageAlquileres = storageAlquileres;
        this.storageMensualidades = storageMensualidades;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincGanancias = new javax.swing.JPanel();
        lblTtituloGanancias = new javax.swing.JLabel();
        pnlReporteMes = new javax.swing.JPanel();
        lblTotalMensua = new javax.swing.JLabel();
        txtTotalMensualidades = new javax.swing.JTextField();
        txtGanDepositosMens = new javax.swing.JTextField();
        lblGanDepositos = new javax.swing.JLabel();
        txtGanMensualidades = new javax.swing.JTextField();
        lblGanMens = new javax.swing.JLabel();
        lblTotalGananciasMes = new javax.swing.JLabel();
        txtTotalGananciasMens = new javax.swing.JTextField();
        cmbMeses = new javax.swing.JComboBox<>();
        lblMes = new javax.swing.JLabel();
        btnMes = new javax.swing.JButton();
        lblAnioMes = new javax.swing.JLabel();
        txtAnioMes = new javax.swing.JTextField();
        pnlReporteAnio = new javax.swing.JPanel();
        lblTotalMensAnio = new javax.swing.JLabel();
        txtTotalMensualidadesAnio = new javax.swing.JTextField();
        txtGanDepositosAnio = new javax.swing.JTextField();
        lblGanDepositosAnio = new javax.swing.JLabel();
        txtGanMensualidadesAnio = new javax.swing.JTextField();
        lblGanMensualidadesAnio = new javax.swing.JLabel();
        lblTotalGananciasAnio = new javax.swing.JLabel();
        txtTotalGananciasAnio = new javax.swing.JTextField();
        txtAnio = new javax.swing.JTextField();
        btnAnio = new javax.swing.JButton();
        lblAnio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GuanaRenta - Ganancias");
        setMinimumSize(new java.awt.Dimension(1040, 469));

        pnlPrincGanancias.setBackground(new java.awt.Color(254, 254, 254));

        lblTtituloGanancias.setFont(new java.awt.Font("Noto Sans", 2, 18)); // NOI18N
        lblTtituloGanancias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTtituloGanancias.setText("Módulo de Ganancias");

        pnlReporteMes.setBackground(new java.awt.Color(254, 254, 254));
        pnlReporteMes.setBorder(javax.swing.BorderFactory.createTitledBorder("Reporte ganancias por mes"));

        lblTotalMensua.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblTotalMensua.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalMensua.setText("Total de mensualidades");

        txtTotalMensualidades.setEditable(false);

        txtGanDepositosMens.setEditable(false);

        lblGanDepositos.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblGanDepositos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGanDepositos.setText("Ganancias en depósitos");

        txtGanMensualidades.setEditable(false);

        lblGanMens.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblGanMens.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGanMens.setText("Ganancias en 3% Mensualidades");

        lblTotalGananciasMes.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblTotalGananciasMes.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalGananciasMes.setText("Total de ganancias");

        txtTotalGananciasMens.setEditable(false);

        cmbMeses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguno", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        lblMes.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMes.setText("Mes:");

        btnMes.setText("Calcular");
        btnMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesActionPerformed(evt);
            }
        });

        lblAnioMes.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAnioMes.setText("Año:");

        txtAnioMes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnioMesKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout pnlReporteMesLayout = new javax.swing.GroupLayout(pnlReporteMes);
        pnlReporteMes.setLayout(pnlReporteMesLayout);
        pnlReporteMesLayout.setHorizontalGroup(
            pnlReporteMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReporteMesLayout.createSequentialGroup()
                .addGroup(pnlReporteMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlReporteMesLayout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(btnMes, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlReporteMesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblMes, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbMeses, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblAnioMes, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAnioMes, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlReporteMesLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(pnlReporteMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlReporteMesLayout.createSequentialGroup()
                                .addGroup(pnlReporteMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblTotalGananciasMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblGanMens, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlReporteMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGanMensualidades, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTotalGananciasMens, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlReporteMesLayout.createSequentialGroup()
                                .addGroup(pnlReporteMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblGanDepositos, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTotalMensua, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlReporteMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGanDepositosMens, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTotalMensualidades, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlReporteMesLayout.setVerticalGroup(
            pnlReporteMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlReporteMesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlReporteMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlReporteMesLayout.createSequentialGroup()
                        .addGroup(pnlReporteMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbMeses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAnioMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlReporteMesLayout.createSequentialGroup()
                        .addComponent(lblAnioMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(38, 38, 38)))
                .addGroup(pnlReporteMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTotalMensua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTotalMensualidades, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlReporteMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblGanDepositos, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(txtGanDepositosMens, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addGroup(pnlReporteMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtGanMensualidades, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lblGanMens, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlReporteMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTotalGananciasMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTotalGananciasMens, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(btnMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        pnlReporteAnio.setBackground(new java.awt.Color(254, 254, 254));
        pnlReporteAnio.setBorder(javax.swing.BorderFactory.createTitledBorder("Reporte ganancias por año"));

        lblTotalMensAnio.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblTotalMensAnio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalMensAnio.setText("Total de mensualidades");

        txtTotalMensualidadesAnio.setEditable(false);

        txtGanDepositosAnio.setEditable(false);

        lblGanDepositosAnio.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblGanDepositosAnio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGanDepositosAnio.setText("Ganancias en depósitos");

        txtGanMensualidadesAnio.setEditable(false);

        lblGanMensualidadesAnio.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblGanMensualidadesAnio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGanMensualidadesAnio.setText("Ganancias en 3% Mensualidades");

        lblTotalGananciasAnio.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblTotalGananciasAnio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalGananciasAnio.setText("Total de ganancias");

        txtTotalGananciasAnio.setEditable(false);

        txtAnio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnioKeyTyped(evt);
            }
        });

        btnAnio.setText("Calcular");
        btnAnio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnioActionPerformed(evt);
            }
        });

        lblAnio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAnio.setText("Año:");

        javax.swing.GroupLayout pnlReporteAnioLayout = new javax.swing.GroupLayout(pnlReporteAnio);
        pnlReporteAnio.setLayout(pnlReporteAnioLayout);
        pnlReporteAnioLayout.setHorizontalGroup(
            pnlReporteAnioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlReporteAnioLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
            .addGroup(pnlReporteAnioLayout.createSequentialGroup()
                .addGroup(pnlReporteAnioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlReporteAnioLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(lblAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlReporteAnioLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pnlReporteAnioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlReporteAnioLayout.createSequentialGroup()
                                .addComponent(lblGanDepositosAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGanDepositosAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlReporteAnioLayout.createSequentialGroup()
                                .addComponent(lblTotalMensAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalMensualidadesAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlReporteAnioLayout.createSequentialGroup()
                                .addComponent(lblGanMensualidadesAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGanMensualidadesAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlReporteAnioLayout.createSequentialGroup()
                                .addComponent(lblTotalGananciasAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalGananciasAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        pnlReporteAnioLayout.setVerticalGroup(
            pnlReporteAnioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlReporteAnioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlReporteAnioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(pnlReporteAnioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalMensualidadesAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalMensAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnlReporteAnioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblGanDepositosAnio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtGanDepositosAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlReporteAnioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblGanMensualidadesAnio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtGanMensualidadesAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlReporteAnioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTotalGananciasAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lblTotalGananciasAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btnAnio, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout pnlPrincGananciasLayout = new javax.swing.GroupLayout(pnlPrincGanancias);
        pnlPrincGanancias.setLayout(pnlPrincGananciasLayout);
        pnlPrincGananciasLayout.setHorizontalGroup(
            pnlPrincGananciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincGananciasLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(pnlReporteMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(pnlReporteAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincGananciasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTtituloGanancias, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPrincGananciasLayout.setVerticalGroup(
            pnlPrincGananciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincGananciasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTtituloGanancias, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addGroup(pnlPrincGananciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlReporteAnio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlReporteMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincGanancias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincGanancias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesActionPerformed
        // Botón que invoca al método para calcular las ganancias según el mes indicado
        if (cmbMeses.getSelectedIndex() != 0 && !txtAnioMes.getText().isEmpty()) {
            this.calcularGananciasMes(cmbMeses.getSelectedIndex(), Integer.parseInt(txtAnioMes.getText()));
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese un año y un mes");
        }
    }//GEN-LAST:event_btnMesActionPerformed

    private void btnAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnioActionPerformed
        // Botón que invoca al método para calcular las ganancias según el año indicado
        if (!txtAnio.getText().isEmpty()) {
            this.calcularGananciasAnio(Integer.parseInt(txtAnio.getText()));
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese un año");

        }
    }//GEN-LAST:event_btnAnioActionPerformed

    private void txtAnioMesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnioMesKeyTyped
        // Solo acepta numeros
        char tecla;
        tecla = evt.getKeyChar();
        if (!Character.isDigit(tecla) && tecla != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
        }

        if (txtAnio.getText().length() == 4) {
            evt.consume();
        }
    }//GEN-LAST:event_txtAnioMesKeyTyped

    private void txtAnioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnioKeyTyped
        // Solo acepta numeros
        char tecla;
        tecla = evt.getKeyChar();
        if (!Character.isDigit(tecla) && tecla != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
        }

        if (txtAnio.getText().length() == 4) {
            evt.consume();
        }
    }//GEN-LAST:event_txtAnioKeyTyped

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
            java.util.logging.Logger.getLogger(DlgGanancias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgGanancias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgGanancias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgGanancias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgGanancias dialog = new DlgGanancias(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAnio;
    private javax.swing.JButton btnMes;
    private javax.swing.JComboBox<String> cmbMeses;
    private javax.swing.JLabel lblAnio;
    private javax.swing.JLabel lblAnioMes;
    private javax.swing.JLabel lblGanDepositos;
    private javax.swing.JLabel lblGanDepositosAnio;
    private javax.swing.JLabel lblGanMens;
    private javax.swing.JLabel lblGanMensualidadesAnio;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblTotalGananciasAnio;
    private javax.swing.JLabel lblTotalGananciasMes;
    private javax.swing.JLabel lblTotalMensAnio;
    private javax.swing.JLabel lblTotalMensua;
    private javax.swing.JLabel lblTtituloGanancias;
    private javax.swing.JPanel pnlPrincGanancias;
    private javax.swing.JPanel pnlReporteAnio;
    private javax.swing.JPanel pnlReporteMes;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtAnioMes;
    private javax.swing.JTextField txtGanDepositosAnio;
    private javax.swing.JTextField txtGanDepositosMens;
    private javax.swing.JTextField txtGanMensualidades;
    private javax.swing.JTextField txtGanMensualidadesAnio;
    private javax.swing.JTextField txtTotalGananciasAnio;
    private javax.swing.JTextField txtTotalGananciasMens;
    private javax.swing.JTextField txtTotalMensualidades;
    private javax.swing.JTextField txtTotalMensualidadesAnio;
    // End of variables declaration//GEN-END:variables

    /*------------------------------------
        Las ganancias se obtiene de la siguiente forma:
    
    1. Se obtiene el 50% del depósito de garantía de cada alquiler. Donde ya al existir un alquiler se tiene el dinero del depósito,
    solamente que debemos fijarnos en la fecha si el año o mes es el mismo al que pedimos.
    
    2. De cada mensualidad cancelada, se obtiene el 3% del monto a pagar de cada mensualidad, este si debe tener su mensualidad cancelada...
     
    ------------------------------------*/
    /**
     * Método que calcula la ganancia según el mes indicado
     */
    private void calcularGananciasMes(int mes, int anio) {

        float depositos = 0;
        float montos = 0;
        byte cantMensu = 0;

        // Debemos sacar el 50% de cada alquiler e ir sumándolos
        for (int i = 0; i < storageAlquileres.getTotal(); i++) { // FALTA ARREGLAR, QUE NO OBTENGA TODAS LAS MENSUALIDADES
            depositos += (storageAlquileres.obtenerAlquiler(i).getDepositoGarantia() / 2);
        }

        txtGanDepositosMens.setText(Float.toString(depositos));

        // Debemos obtener el 3% de cada monto de mensualidad cancelada
        for (int i = 0; i < storageMensualidades.getTotal(); i++) {

            if (storageMensualidades.obtenerMensualidad(i).getEstado().equals("Cancelada")
                    && storageMensualidades.obtenerMensualidad(i).getMesCobro() == mes
                    && storageMensualidades.obtenerMensualidad(i).getAnioActual() == anio) {
                montos += (storageMensualidades.obtenerMensualidad(i).getMontoMes() * 0.03);
                cantMensu++;
            }
        }
        txtGanMensualidades.setText(Byte.toString(cantMensu));
        txtGanMensualidades.setText(Float.toString(montos));

        txtTotalGananciasMens.setText(Float.toString(depositos + montos));

    }

    /**
     * Método que calcula la ganancia según el mes indicado
     */
    private void calcularGananciasAnio(int anio) {

        float depositos = 0;
        float montos = 0;
        byte cantMensu = 0;

        // Debemos sacar el 50% de cada alquiler e ir sumándolos
        for (int i = 0; i < storageAlquileres.getTotal(); i++) { // FALTA ARREGLAR, QUE NO OBTENGA TODAS LAS MENSUALIDADES
            depositos += (storageAlquileres.obtenerAlquiler(i).getDepositoGarantia() / 2);
        }

        txtGanDepositosMens.setText(Float.toString(depositos));

        // Debemos obtener el 3% de cada monto de mensualidad cancelada
        for (int i = 0; i < storageMensualidades.getTotal(); i++) {

            if (storageMensualidades.obtenerMensualidad(i).getEstado().equals("Cancelada")
                    && storageMensualidades.obtenerMensualidad(i).getAnioActual() == anio) {
                montos += (storageMensualidades.obtenerMensualidad(i).getMontoMes() * 0.03);
                cantMensu++;
            }
        }
        txtGanMensualidades.setText(Byte.toString(cantMensu));
        txtGanMensualidades.setText(Float.toString(montos));
        txtTotalGananciasMens.setText(Float.toString(depositos + montos));

    }

}
