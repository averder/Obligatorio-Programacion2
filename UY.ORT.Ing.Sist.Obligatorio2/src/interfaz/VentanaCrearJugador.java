package interfaz;

import dominio.Jugador;
import dominio.Sistema;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VentanaCrearJugador extends javax.swing.JDialog {

    private Sistema modelo;

    public VentanaCrearJugador(Sistema sis, JFrame ventanaPadre) {
        super(ventanaPadre, true);
        initComponents();
        modelo = sis;
    }

    public Sistema getModelo() {
        return modelo;
    }

    public void setModelo(Sistema modelo) {
        this.modelo = modelo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLblNombre = new javax.swing.JLabel();
        jLblTitulo = new javax.swing.JLabel();
        jTxtNombre = new javax.swing.JTextField();
        jLblEdad = new javax.swing.JLabel();
        jLblAlias = new javax.swing.JLabel();
        jTxtAlias = new javax.swing.JTextField();
        jBtnGuardar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jTxtEdad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Perfección");
        setMinimumSize(new java.awt.Dimension(373, 281));
        setResizable(false);

        jLblNombre.setText("Nombre");

        jLblTitulo.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        jLblTitulo.setText("REGISTRAR JUGADOR");

        jLblEdad.setText("Edad");

        jLblAlias.setText("Alias");

        jBtnGuardar.setText("Guardar");
        jBtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGuardarActionPerformed(evt);
            }
        });

        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jTxtEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtEdadKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jBtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTxtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLblTitulo)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLblAlias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLblEdad, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTxtAlias)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblAlias)
                    .addComponent(jTxtAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardarActionPerformed
        boolean registroOk = true;
        Jugador jugadorAux = new Jugador();
        String mensaje = "";
        if (jTxtNombre.getText().isEmpty()) {
            registroOk = false;
            mensaje += "\nIngrese un nombre válido ";
        }
        if (jTxtAlias.getText().isEmpty()) {
            registroOk = false;
            mensaje += "\nIngrese un alias válido ";
        }
        else {
            jugadorAux.setAlias(jTxtAlias.getText());
        }
        if (modelo.getListaJugadores().contains(jugadorAux)) {
            registroOk = false;
            mensaje += "\nAlias ya existente. Ingrese un nuevo alias  ";
        }
        if (jTxtEdad.getText().isEmpty() || jTxtEdad.getText().equals("0")
                || jTxtEdad.getText().length() > 2) {
            registroOk = false;
            mensaje += "\nIngrese una edad válida ";
        }
        if (registroOk) {
            Jugador jugador = new Jugador();
            jugador.setNombre(jTxtNombre.getText());
            jugador.setAlias(jTxtAlias.getText());
            jugador.setEdad(Integer.parseInt(jTxtEdad.getText()));
            getModelo().registrarJugador(jugador);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.OK_OPTION);
        }

    }//GEN-LAST:event_jBtnGuardarActionPerformed

    private void jTxtEdadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtEdadKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_jTxtEdadKeyTyped

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnGuardar;
    private javax.swing.JLabel jLblAlias;
    private javax.swing.JLabel jLblEdad;
    private javax.swing.JLabel jLblNombre;
    private javax.swing.JLabel jLblTitulo;
    private javax.swing.JTextField jTxtAlias;
    private javax.swing.JTextField jTxtEdad;
    private javax.swing.JTextField jTxtNombre;
    // End of variables declaration//GEN-END:variables

}
