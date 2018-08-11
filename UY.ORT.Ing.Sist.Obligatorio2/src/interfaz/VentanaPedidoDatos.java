package interfaz;

import dominio.Jugador;
import dominio.Partida;
import dominio.Sistema;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VentanaPedidoDatos extends javax.swing.JDialog {

    private Sistema modelo;
    private Jugador jugadorUno;
    private Jugador jugadorDos;
    private java.awt.Color colorUno;
    private java.awt.Color colorDos;

    public Sistema getModelo() {
        return modelo;
    }

    public void setModelo(Sistema modelo) {
        this.modelo = modelo;
    }

    public VentanaPedidoDatos(Sistema sis, JFrame ventanaPadre) {
        super(ventanaPadre, true);
        initComponents();
        modelo = sis;
        jugadorUno = new Jugador();
        jugadorDos = new Jugador();
        jLstJugador1.setListData(modelo.getListaJugadores().toArray());
        jLstJugador2.setListData(modelo.getListaJugadores().toArray());
        colorUno = Color.WHITE;
        colorDos = Color.BLACK;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupTablero = new javax.swing.ButtonGroup();
        buttonGroupPanel = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLstJugador1 = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLstJugador2 = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLblTablero = new javax.swing.JLabel();
        jRbtnTablero4x4 = new javax.swing.JRadioButton();
        jRbtnTablero6x6 = new javax.swing.JRadioButton();
        jRbtnTablero8x8 = new javax.swing.JRadioButton();
        jLblPanel = new javax.swing.JLabel();
        jRbtnPanel2x2 = new javax.swing.JRadioButton();
        jRbtnPanel3x3 = new javax.swing.JRadioButton();
        jRbtnPanel4x4 = new javax.swing.JRadioButton();
        jLblCantidadFichas = new javax.swing.JLabel();
        jTxtCantidadFichas = new javax.swing.JTextField();
        jBtnAceptar = new javax.swing.JButton();
        jLblTitulo = new javax.swing.JLabel();
        jBtnColor1 = new javax.swing.JButton();
        jBtnColor2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Perfección");
        setMinimumSize(new java.awt.Dimension(517, 486));
        setResizable(false);

        jLstJugador1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLstJugador1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jLstJugador1);

        jLstJugador2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLstJugador2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jLstJugador2);

        jLabel1.setText("Jugador 1:");

        jLabel2.setText("Jugador 2:");

        jLblTablero.setText("Tablero");

        buttonGroupTablero.add(jRbtnTablero4x4);
        jRbtnTablero4x4.setText("4x4");
        jRbtnTablero4x4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRbtnTablero4x4ActionPerformed(evt);
            }
        });

        buttonGroupTablero.add(jRbtnTablero6x6);
        jRbtnTablero6x6.setText("6x6");
        jRbtnTablero6x6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRbtnTablero6x6ActionPerformed(evt);
            }
        });

        buttonGroupTablero.add(jRbtnTablero8x8);
        jRbtnTablero8x8.setText("8x8");
        jRbtnTablero8x8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRbtnTablero8x8ActionPerformed(evt);
            }
        });

        jLblPanel.setText("Panel");

        buttonGroupPanel.add(jRbtnPanel2x2);
        jRbtnPanel2x2.setText("2x2");

        buttonGroupPanel.add(jRbtnPanel3x3);
        jRbtnPanel3x3.setText("3x3");

        buttonGroupPanel.add(jRbtnPanel4x4);
        jRbtnPanel4x4.setText("4x4");

        jLblCantidadFichas.setText("Cantidad de Fichas");

        jTxtCantidadFichas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtCantidadFichasKeyTyped(evt);
            }
        });

        jBtnAceptar.setText("Aceptar");
        jBtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAceptarActionPerformed(evt);
            }
        });

        jLblTitulo.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        jLblTitulo.setText("Opciones de Juego:");

        jBtnColor1.setText("Elegir color ");
        jBtnColor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnColor1ActionPerformed(evt);
            }
        });

        jBtnColor2.setText("Elegir color");
        jBtnColor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnColor2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jRbtnTablero4x4)
                                    .addComponent(jRbtnTablero6x6)
                                    .addComponent(jRbtnTablero8x8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRbtnPanel3x3)
                                    .addComponent(jRbtnPanel2x2)
                                    .addComponent(jRbtnPanel4x4)
                                    .addComponent(jLblPanel))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnColor1)
                            .addComponent(jBtnColor2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLblTablero)
                            .addComponent(jLblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 344, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLblCantidadFichas)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtCantidadFichas, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jBtnColor1)))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jBtnColor2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblTablero)
                    .addComponent(jLblPanel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRbtnTablero4x4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRbtnTablero6x6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRbtnTablero8x8))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRbtnPanel2x2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRbtnPanel3x3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRbtnPanel4x4)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblCantidadFichas)
                    .addComponent(jTxtCantidadFichas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRbtnTablero8x8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRbtnTablero8x8ActionPerformed
        jRbtnPanel2x2.setEnabled(true);
        jRbtnPanel3x3.setEnabled(true);
        jRbtnPanel4x4.setEnabled(true);
        jRbtnPanel2x2.setSelected(true);

    }//GEN-LAST:event_jRbtnTablero8x8ActionPerformed

    private void jRbtnTablero4x4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRbtnTablero4x4ActionPerformed
        jRbtnPanel2x2.setEnabled(true);
        jRbtnPanel3x3.setEnabled(false);
        jRbtnPanel4x4.setEnabled(false);
        jRbtnPanel2x2.setSelected(true);
    }//GEN-LAST:event_jRbtnTablero4x4ActionPerformed

    private void jRbtnTablero6x6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRbtnTablero6x6ActionPerformed
        jRbtnPanel2x2.setEnabled(true);
        jRbtnPanel3x3.setEnabled(true);
        jRbtnPanel4x4.setEnabled(false);
        jRbtnPanel2x2.setSelected(true);
    }//GEN-LAST:event_jRbtnTablero6x6ActionPerformed

    private void jTxtCantidadFichasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtCantidadFichasKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_jTxtCantidadFichasKeyTyped

    private void jBtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAceptarActionPerformed
        String mensaje = "";
        boolean hayDatos = true;
        boolean datosValidos = true;
        int dimTablero = 0;
        int dimPanel = 0;
        int cantFichas = 0;
        if (jugadorUno.getAlias().equals("Sin alias")) {
            mensaje = "Seleccione un jugador de la lista de arriba";
            hayDatos = false;
        }
        if (jugadorDos.getAlias().equals("Sin alias")) {
            mensaje += "\nSeleccione un jugador de la lista de abajo";
            hayDatos = false;
        }
        if (!(jRbtnTablero4x4.isSelected() || jRbtnTablero6x6.isSelected()
                || jRbtnTablero8x8.isSelected())) {
            mensaje += "\nSeleccione un tamaño de tablero";
            hayDatos = false;
        }
        if (!(jRbtnPanel2x2.isSelected() || jRbtnPanel3x3.isSelected()
                || jRbtnPanel4x4.isSelected())) {
            mensaje += "\nSeleccione un tamaño de panel";
            hayDatos = false;
        }
        if (jTxtCantidadFichas.getText().isEmpty()) {
            mensaje += "\nIngrese una cantidad de fichas";
            hayDatos = false;
        } else if (jTxtCantidadFichas.getText().length() > 2) {
            mensaje += "\nIngrese una cantidad de fichas válido";
            hayDatos = false;
        }
        if (colorUno == null) {
            colorUno = Color.WHITE;
        }
        if (colorDos == null) {
            colorDos = Color.BLACK;
        }
        if (colorUno.equals(colorDos)) {
            mensaje += "\nIngrese dos colores diferentes";
            hayDatos = false;
        }
        if (hayDatos) {
            cantFichas = Integer.parseInt(jTxtCantidadFichas.getText());
            if (jRbtnTablero4x4.isSelected()) {
                dimTablero = 4;
                dimPanel = 2;
                if (cantFichas > 10 || cantFichas < 1) {
                    datosValidos = false;
                    mensaje += "\nIngrese una cantidad de fichas de 1 a 10";
                }
            } else if (jRbtnTablero6x6.isSelected()) {
                dimTablero = 6;
                if (jRbtnPanel2x2.isSelected()) {
                    dimPanel = 2;
                    if (cantFichas > 20 || cantFichas < 1) {
                        datosValidos = false;
                        mensaje += "\nIngrese una cantidad de fichas de 1 a 20";
                    }
                } else {
                    dimPanel = 3;
                    if (cantFichas > 22 || cantFichas < 1) {
                        datosValidos = false;
                        mensaje += "\nIngrese una cantidad de fichas de 1 a 22";
                    }
                }
            } else {
                dimTablero = 8;
                if (jRbtnPanel2x2.isSelected()) {
                    dimPanel = 2;
                    if (cantFichas > 34 || cantFichas < 1) {
                        datosValidos = false;
                        mensaje += "\nIngrese una cantidad de fichas de 1 a 34";
                    }
                } else if (jRbtnPanel3x3.isSelected()) {
                    dimPanel = 3;
                    if (cantFichas > 37 || cantFichas < 1) {
                        datosValidos = false;
                        mensaje += "\nIngrese una cantidad de fichas de 1 a 37";
                    }
                } else {
                    dimPanel = 4;
                    if (cantFichas > 40 || cantFichas < 1) {
                        datosValidos = false;
                        mensaje += "\nIngrese una cantidad de fichas de 1 a 40";
                    }
                }
            }
        }
        if (!hayDatos || !datosValidos) {
            JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.OK_OPTION);
        } else {
            Partida partida = new Partida(jugadorUno, jugadorDos, dimTablero,
                    dimPanel, cantFichas, cantFichas, colorUno, colorDos);
            dispose();
            VentanaJuego v = new VentanaJuego((JFrame) this.getParent(), partida, getModelo());
            v.setLocationRelativeTo(this);
            v.setVisible(true);
        }
    }//GEN-LAST:event_jBtnAceptarActionPerformed

    private void jLstJugador1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLstJugador1MouseClicked
        jugadorUno = (Jugador) jLstJugador1.getSelectedValue();
        actualizarListaDos();
    }//GEN-LAST:event_jLstJugador1MouseClicked

    private void jLstJugador2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLstJugador2MouseClicked
        jugadorDos = (Jugador) jLstJugador2.getSelectedValue();
        actualizarListaUno();
    }//GEN-LAST:event_jLstJugador2MouseClicked

    private void jBtnColor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnColor1ActionPerformed
        VentanaColor v = new VentanaColor(this, colorUno);
        v.setLocationRelativeTo(this);
        v.setVisible(true);
        colorUno = v.getColor();
    }//GEN-LAST:event_jBtnColor1ActionPerformed

    private void jBtnColor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnColor2ActionPerformed
        VentanaColor v = new VentanaColor(this, colorDos);
        v.setLocationRelativeTo(this);
        v.setVisible(true);
        colorDos = v.getColor();
    }//GEN-LAST:event_jBtnColor2ActionPerformed

    private void actualizarListaUno() {
        ArrayList<Jugador> listaSinJugadorDos = new ArrayList<Jugador>();
        for (int i = 0; i < modelo.getListaJugadores().size(); i++) {
            if (!modelo.getListaJugadores().get(i).equals(jugadorDos)) {
                listaSinJugadorDos.add(modelo.getListaJugadores().get(i));
            }
        }
        jLstJugador1.setListData(listaSinJugadorDos.toArray());
        for (int i = 0; i < listaSinJugadorDos.size(); i++) {
            if (listaSinJugadorDos.get(i).equals(jugadorUno)) {
                jLstJugador1.setSelectedIndex(i);
            }
        }

    }

    private void actualizarListaDos() {
        ArrayList<Jugador> listaSinJugadorUno = new ArrayList<Jugador>();
        for (int i = 0; i < modelo.getListaJugadores().size(); i++) {
            if (!modelo.getListaJugadores().get(i).equals(jugadorUno)) {
                listaSinJugadorUno.add(modelo.getListaJugadores().get(i));
            }
        }
        jLstJugador2.removeAll();
        jLstJugador2.setListData(listaSinJugadorUno.toArray());
        for (int i = 0; i < listaSinJugadorUno.size(); i++) {
            if (listaSinJugadorUno.get(i).equals(jugadorDos)) {
                jLstJugador2.setSelectedIndex(i);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupPanel;
    private javax.swing.ButtonGroup buttonGroupTablero;
    private javax.swing.JButton jBtnAceptar;
    private javax.swing.JButton jBtnColor1;
    private javax.swing.JButton jBtnColor2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLblCantidadFichas;
    private javax.swing.JLabel jLblPanel;
    private javax.swing.JLabel jLblTablero;
    private javax.swing.JLabel jLblTitulo;
    private javax.swing.JList jLstJugador1;
    private javax.swing.JList jLstJugador2;
    private javax.swing.JRadioButton jRbtnPanel2x2;
    private javax.swing.JRadioButton jRbtnPanel3x3;
    private javax.swing.JRadioButton jRbtnPanel4x4;
    private javax.swing.JRadioButton jRbtnTablero4x4;
    private javax.swing.JRadioButton jRbtnTablero6x6;
    private javax.swing.JRadioButton jRbtnTablero8x8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTxtCantidadFichas;
    // End of variables declaration//GEN-END:variables

}
