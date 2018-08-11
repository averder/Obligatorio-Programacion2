package interfaz;

import dominio.Sistema;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VentanaCargarJugadores extends javax.swing.JDialog {

    private Sistema modelo;

    public Sistema getModelo() {
        return modelo;
    }

    public void setModelo(Sistema modelo) {
        this.modelo = modelo;
    }

    public VentanaCargarJugadores(Sistema sis, JFrame ventanaPadre) {
        super(ventanaPadre, true);
        initComponents();
        modelo = sis;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTxtUbicacion = new javax.swing.JTextField();
        jBtnExaminar = new javax.swing.JButton();
        jBtnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Perfección");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        jLabel1.setText("Cargar Jugadores: ");

        jTxtUbicacion.setEditable(false);

        jBtnExaminar.setText("Examinar");
        jBtnExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExaminarActionPerformed(evt);
            }
        });

        jBtnAceptar.setText("Aceptar");
        jBtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTxtUbicacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnExaminar)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jBtnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnExaminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jBtnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExaminarActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de Texto (.txt)", "txt"));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setSelectedFile(new File(jTxtUbicacion.getText()));
        int retorno = fileChooser.showOpenDialog(this);
        if (retorno == JFileChooser.APPROVE_OPTION) {
            String ubicacion = fileChooser.getSelectedFile().getPath();
            jTxtUbicacion.setText(ubicacion);
        }
    }//GEN-LAST:event_jBtnExaminarActionPerformed

    private void jBtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAceptarActionPerformed
        if (!jTxtUbicacion.getText().isEmpty()) {
            if (jTxtUbicacion.getText().endsWith(".txt")) {
                if (modelo.importarJugadores(jTxtUbicacion.getText())) {
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Se encontraron errores al cargar algunos archivos.",
                            "ERROR", JOptionPane.OK_OPTION);
                }
            } else {
                JOptionPane.showMessageDialog(this, "El archivo no es de tipo .txt",
                        "ERROR", JOptionPane.OK_OPTION);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un archivo a cargar",
                    "ERROR", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_jBtnAceptarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAceptar;
    private javax.swing.JButton jBtnExaminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTxtUbicacion;
    // End of variables declaration//GEN-END:variables
}
