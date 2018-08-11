package interfaz;

import dominio.Sistema;
import java.util.Collections;
import javax.swing.JFrame;

public class VentanaLista extends javax.swing.JDialog {

    private Sistema modelo;

    public Sistema getModelo() {
        return modelo;
    }

    public void setModelo(Sistema modelo) {
        this.modelo = modelo;
    }

    public VentanaLista(Sistema sis, JFrame ventanaPadre) {
        super(ventanaPadre, true);
        initComponents();
        modelo = sis;
        jLstJugadores.setListData(modelo.getListaJugadores().toArray());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLstJugadores = new javax.swing.JList();
        jLblListaJugadores = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Perfección");
        setMinimumSize(new java.awt.Dimension(450, 349));
        setPreferredSize(new java.awt.Dimension(450, 349));
        setResizable(false);
        getContentPane().setLayout(null);

        jLstJugadores.setBorder(new javax.swing.border.MatteBorder(null));
        jScrollPane1.setViewportView(jLstJugadores);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 50, 350, 230);

        jLblListaJugadores.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        jLblListaJugadores.setText("Lista Jugadores");
        getContentPane().add(jLblListaJugadores);
        jLblListaJugadores.setBounds(40, 20, 110, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLblListaJugadores;
    private javax.swing.JList jLstJugadores;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
