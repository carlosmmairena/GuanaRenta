/*
 * Clase principal del proyecto
 */

package com.guanarenta.view;

import com.guanarenta.storage.StorageInquilinos;
import com.guanarenta.storage.StoragePropietarios;
import com.guanarenta.storage.StorageViviendas;
import com.guanarenta.storage.StorageAlquileres;
import com.guanarenta.storage.StorageMensualidades;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author Ander Narvaez
 * @author Carlos Mairena
 */
public class FrmGuanaRenta extends javax.swing.JFrame {

    StoragePropietarios storagePropietarios;
    StorageViviendas storageViviendas;
    StorageInquilinos storageInquilinos;
    StorageAlquileres storageAlquileres;
    StorageMensualidades storageMensualidades;

    public FrmGuanaRenta() {
        initComponents();
        
        this.storagePropietarios = new StoragePropietarios();
        this.storageViviendas = new StorageViviendas();
        this.storageInquilinos = new StorageInquilinos();
        this.storageAlquileres = new StorageAlquileres();
        this.storageMensualidades = new StorageMensualidades();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBase = new javax.swing.JPanel();
        btnPropietarios = new javax.swing.JButton();
        btnViviendas = new javax.swing.JButton();
        btnInquilinos = new javax.swing.JButton();
        btnAlquileres = new javax.swing.JButton();
        btnMensualidades = new javax.swing.JButton();
        btnGanancias = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" GuanaRenta - Menú Principal");
        setIconImage(getIconImage());
        setIconImages(getIconImages());
        setMinimumSize(new java.awt.Dimension(890, 520));
        setName("frmMenuPrincipal"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        pnlBase.setBackground(new java.awt.Color(255, 255, 255));

        btnPropietarios.setBackground(new java.awt.Color(225, 241, 249));
        btnPropietarios.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btnPropietarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/guanarenta/img/propietario.png"))); // NOI18N
        btnPropietarios.setText("Propietarios");
        btnPropietarios.setPreferredSize(null);
        btnPropietarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPropietariosActionPerformed(evt);
            }
        });

        btnViviendas.setBackground(new java.awt.Color(225, 241, 249));
        btnViviendas.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btnViviendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/guanarenta/img/viviendas.png"))); // NOI18N
        btnViviendas.setText("Viviendas");
        btnViviendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViviendasActionPerformed(evt);
            }
        });

        btnInquilinos.setBackground(new java.awt.Color(225, 241, 249));
        btnInquilinos.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btnInquilinos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/guanarenta/img/inquilinos.png"))); // NOI18N
        btnInquilinos.setText("Inquilinos");
        btnInquilinos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInquilinosActionPerformed(evt);
            }
        });

        btnAlquileres.setBackground(new java.awt.Color(225, 241, 249));
        btnAlquileres.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btnAlquileres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/guanarenta/img/alquileres.png"))); // NOI18N
        btnAlquileres.setText("Alquileres");
        btnAlquileres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlquileresActionPerformed(evt);
            }
        });

        btnMensualidades.setBackground(new java.awt.Color(225, 241, 249));
        btnMensualidades.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btnMensualidades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/guanarenta/img/mensualidades.png"))); // NOI18N
        btnMensualidades.setText("Mensualidades");
        btnMensualidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMensualidadesActionPerformed(evt);
            }
        });

        btnGanancias.setBackground(new java.awt.Color(225, 241, 249));
        btnGanancias.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btnGanancias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/guanarenta/img/ganancias.png"))); // NOI18N
        btnGanancias.setText("Ganancias");
        btnGanancias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGananciasActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(200, 239, 232));
        jLabel1.setFont(new java.awt.Font("Likhan", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GUANA-RENTA");

        jLabel2.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel2.setText("Menú de opciones");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/guanarenta/img/inicio.png"))); // NOI18N

        javax.swing.GroupLayout pnlBaseLayout = new javax.swing.GroupLayout(pnlBase);
        pnlBase.setLayout(pnlBaseLayout);
        pnlBaseLayout.setHorizontalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBaseLayout.createSequentialGroup()
                .addContainerGap(188, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBaseLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMensualidades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAlquileres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInquilinos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnViviendas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPropietarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGanancias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(59, 59, 59))
        );
        pnlBaseLayout.setVerticalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBaseLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPropietarios, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnViviendas, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInquilinos, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAlquileres, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMensualidades, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGanancias, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPropietariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPropietariosActionPerformed
        // Botón que muestra la ventana para agregar un propietario

        DlgPropietarios prov = new DlgPropietarios(this, true, this.storagePropietarios);
        prov.setVisible(true);

    }//GEN-LAST:event_btnPropietariosActionPerformed

    private void btnViviendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViviendasActionPerformed
        // Botón que muestra la ventana con opciones para agregar una vivienda
        DlgViviendas vivienda = new DlgViviendas(this, true, this.storagePropietarios, this.storageViviendas);
        vivienda.setVisible(true);

    }//GEN-LAST:event_btnViviendasActionPerformed

    private void btnInquilinosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInquilinosActionPerformed
        // Botón que muestra la ventana con opciones para agregar un inquilino
        // Aquí debemos asegurarnos de que la ventana se muestre solamente cuando hayan viviendas
        DlgInquilinos inquilinos = new DlgInquilinos(this, true, this.storageInquilinos);
        inquilinos.setVisible(true);

    }//GEN-LAST:event_btnInquilinosActionPerformed

    private void btnAlquileresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlquileresActionPerformed
        // Al momento de que abren la ventana del alquiler
        DlgAlquileres alquiler = new DlgAlquileres(this, true, this.storageAlquileres, this.storageInquilinos, this.storageViviendas, this.storagePropietarios);
        alquiler.setVisible(true);

    }//GEN-LAST:event_btnAlquileresActionPerformed

    private void btnMensualidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMensualidadesActionPerformed
        // Mostramos la ventana de mensualidades
        DlgMensualidades mensualidades = new DlgMensualidades(this, true, this.storageMensualidades, this.storageAlquileres, this.storageInquilinos);
        mensualidades.setVisible(true);

    }//GEN-LAST:event_btnMensualidadesActionPerformed

    private void btnGananciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGananciasActionPerformed
        // Mostramos la ventana de ganancias
        DlgGanancias ganancias = new DlgGanancias(this, rootPaneCheckingEnabled, storageAlquileres, storageMensualidades);
        ganancias.setVisible(true);

    }//GEN-LAST:event_btnGananciasActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        if (storagePropietarios.getTotal() != 0) {
            btnViviendas.setEnabled(true);
        } else {
            btnViviendas.setEnabled(false);
        }
        if (storageViviendas.getTotal() != 0) {
            btnInquilinos.setEnabled(true);
        } else {
            btnInquilinos.setEnabled(false);
        }
        if (storageInquilinos.getTotal() != 0) {
            btnAlquileres.setEnabled(true);
        } else {
            btnAlquileres.setEnabled(false);

        }

    }//GEN-LAST:event_formWindowActivated

    /**
     * Sobre escrito para cambiar el valor de retorno de este método
     *
     * @return icono para la aplicación
     */
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("com/guanarenta/img/guanaRenta.png"));
        return retValue;
    }

    /**
     * @param args the command line argumentstorage
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
            java.util.logging.Logger.getLogger(FrmGuanaRenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGuanaRenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGuanaRenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGuanaRenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmGuanaRenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlquileres;
    private javax.swing.JButton btnGanancias;
    private javax.swing.JButton btnInquilinos;
    private javax.swing.JButton btnMensualidades;
    private javax.swing.JButton btnPropietarios;
    private javax.swing.JButton btnViviendas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel pnlBase;
    // End of variables declaration//GEN-END:variables
}
