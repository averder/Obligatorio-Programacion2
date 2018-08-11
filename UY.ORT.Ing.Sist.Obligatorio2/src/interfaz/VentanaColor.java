package interfaz;

import java.awt.Color;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class VentanaColor extends javax.swing.JDialog {

    private java.awt.Color unColor;
    private java.awt.Color colorAnterior;
       

    public Color getColor() {
        return unColor;
    }

    public void setColor(Color color) {
        this.unColor = color;
    }

    public VentanaColor(JDialog ventanaPadre, Color unColorAnterior) {
        super(ventanaPadre, true);
        initComponents();
        colorAnterior = unColorAnterior;
        jColorChooser1.setColor(colorAnterior);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        jBtnAceptar = new javax.swing.JButton();
        jLblElegirColor = new javax.swing.JLabel();
        jBtnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Perfección");
        setMinimumSize(new java.awt.Dimension(446, 323));
        setResizable(false);

        jBtnAceptar.setText("Aceptar");
        jBtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAceptarActionPerformed(evt);
            }
        });

        jLblElegirColor.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        jLblElegirColor.setText("Elegir Color");

        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLblElegirColor, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnAceptar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnCancelar))
                    .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLblElegirColor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnAceptar)
                    .addComponent(jBtnCancelar))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAceptarActionPerformed
        unColor = jColorChooser1.getColor();
        if (colorAnterior == unColor) {
             JOptionPane.showMessageDialog(this, "Seleccione un color diferente.","ERROR", JOptionPane.OK_OPTION);
        }
        else{ 
        dispose();
        }
    }//GEN-LAST:event_jBtnAceptarActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAceptar;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLblElegirColor;
    // End of variables declaration//GEN-END:variables
}
