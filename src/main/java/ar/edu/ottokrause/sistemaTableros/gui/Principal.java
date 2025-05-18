package ar.edu.ottokrause.sistemaTableros.gui;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMTGitHubIJTheme;
import java.awt.Image;
import java.awt.Toolkit;

public class Principal extends javax.swing.JFrame {

    public Principal() {
        FlatMTGitHubIJTheme.setup();
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(getIconImage());
    }

    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("ar.edu.ottokrause.sistemaTableros.image/Logo.png"));
        return retValue;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Botones = new javax.swing.JPanel();
        jBtnRegistro = new javax.swing.JButton();
        jBtnPedidos = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jBtnRegistro.setBackground(new java.awt.Color(144, 196, 140));
        jBtnRegistro.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jBtnRegistro.setForeground(new java.awt.Color(255, 255, 255));
        jBtnRegistro.setText("REGISTRO");
        jBtnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRegistroActionPerformed(evt);
            }
        });

        jBtnPedidos.setBackground(new java.awt.Color(144, 196, 140));
        jBtnPedidos.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jBtnPedidos.setForeground(new java.awt.Color(255, 255, 255));
        jBtnPedidos.setText("PEDIDOS");
        jBtnPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPedidosActionPerformed(evt);
            }
        });

        titulo.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("PRESTACIÓN DE TABLEROS");

        javax.swing.GroupLayout BotonesLayout = new javax.swing.GroupLayout(Botones);
        Botones.setLayout(BotonesLayout);
        BotonesLayout.setHorizontalGroup(
            BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BotonesLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jBtnRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addComponent(jBtnPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
            .addGroup(BotonesLayout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(titulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BotonesLayout.setVerticalGroup(
            BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BotonesLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 303, Short.MAX_VALUE)
                .addGroup(BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Botones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Botones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRegistroActionPerformed
        Registro regi = new Registro();
        regi.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jBtnRegistroActionPerformed

    private void jBtnPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPedidosActionPerformed
        Pedidos ped = new Pedidos();
        ped.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jBtnPedidosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Botones;
    private javax.swing.JButton jBtnPedidos;
    private javax.swing.JButton jBtnRegistro;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
