package interfaz;

import dominio.Sistema;
import javax.swing.JOptionPane;
import persistencia.Persistencia;

public class VentanaMenu extends javax.swing.JFrame {

    private Sistema modelo;

    public Sistema getModelo() {
        return modelo;
    }

    public void setModelo(Sistema modelo) {
        this.modelo = modelo;
    }

    public VentanaMenu(Sistema sis) {
        initComponents();
        modelo = sis;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLblTitulo = new javax.swing.JLabel();
        jBtnCargarJugadores = new javax.swing.JButton();
        jBtnJugar = new javax.swing.JButton();
        jBtnConsultaJugadores = new javax.swing.JButton();
        jBtnSalir = new javax.swing.JButton();
        jBtnComoJugar = new javax.swing.JButton();
        jBtnRegistrarJugador1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Perfección");
        setMinimumSize(new java.awt.Dimension(689, 483));
        setPreferredSize(new java.awt.Dimension(689, 483));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jLblTitulo.setFont(new java.awt.Font("Times New Roman", 2, 36)); // NOI18N
        jLblTitulo.setText("PERFECCIÓN");
        getContentPane().add(jLblTitulo);
        jLblTitulo.setBounds(230, 0, 230, 70);

        jBtnCargarJugadores.setText("Cargar Jugadores");
        jBtnCargarJugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCargarJugadoresActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnCargarJugadores);
        jBtnCargarJugadores.setBounds(390, 100, 200, 50);

        jBtnJugar.setText("Jugar a Perfeccion");
        jBtnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnJugarActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnJugar);
        jBtnJugar.setBounds(70, 200, 200, 50);

        jBtnConsultaJugadores.setText("Consulta Jugadores");
        jBtnConsultaJugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConsultaJugadoresActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnConsultaJugadores);
        jBtnConsultaJugadores.setBounds(70, 300, 200, 50);

        jBtnSalir.setText("Salir");
        jBtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnSalir);
        jBtnSalir.setBounds(390, 300, 200, 50);

        jBtnComoJugar.setText("¿Cómo jugar?");
        jBtnComoJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnComoJugarActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnComoJugar);
        jBtnComoJugar.setBounds(390, 200, 200, 50);

        jBtnRegistrarJugador1.setText("Registrar Jugador");
        jBtnRegistrarJugador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRegistrarJugador1ActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnRegistrarJugador1);
        jBtnRegistrarJugador1.setBounds(70, 100, 200, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnJugarActionPerformed
        if (modelo.getListaJugadores().size() >= 2) {
            VentanaPedidoDatos v = new VentanaPedidoDatos(getModelo(), this);
            v.setLocationRelativeTo(this);
            v.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Deben existir al menos dos jugadores", "ERROR", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_jBtnJugarActionPerformed

    private void jBtnConsultaJugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConsultaJugadoresActionPerformed
        VentanaLista v = new VentanaLista(getModelo(), this);
        v.setLocationRelativeTo(this);
        v.setVisible(true);
    }//GEN-LAST:event_jBtnConsultaJugadoresActionPerformed

    private void jBtnCargarJugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCargarJugadoresActionPerformed
        VentanaCargarJugadores v = new VentanaCargarJugadores(getModelo(), this);
        v.setLocationRelativeTo(this);
        v.setVisible(true);
    }//GEN-LAST:event_jBtnCargarJugadoresActionPerformed

    private void jBtnComoJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnComoJugarActionPerformed
        VentanaComoJugar v = new VentanaComoJugar(this);
        v.setLocationRelativeTo(this);
        v.setVisible(true);
    }//GEN-LAST:event_jBtnComoJugarActionPerformed

    private void jBtnRegistrarJugador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRegistrarJugador1ActionPerformed
        VentanaCrearJugador v = new VentanaCrearJugador(getModelo(), this);
        v.setLocationRelativeTo(this);
        v.setVisible(true);
    }//GEN-LAST:event_jBtnRegistrarJugador1ActionPerformed

    private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
        guardar();
        System.exit(0);
    }//GEN-LAST:event_jBtnSalirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        guardar();
    }//GEN-LAST:event_formWindowClosing

    public void guardar() {
        Persistencia per = new Persistencia();
        per.guardarSistema(modelo);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCargarJugadores;
    private javax.swing.JButton jBtnComoJugar;
    private javax.swing.JButton jBtnConsultaJugadores;
    private javax.swing.JButton jBtnJugar;
    private javax.swing.JButton jBtnRegistrarJugador1;
    private javax.swing.JButton jBtnSalir;
    private javax.swing.JLabel jLblTitulo;
    // End of variables declaration//GEN-END:variables
}
