package interfaz;

import dominio.Ficha;
import dominio.Partida;
import dominio.Sistema;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class VentanaJuego extends javax.swing.JDialog {

    private Sistema modelo;
    private JButton[][] botones;
    private Partida partida;

    public VentanaJuego(JFrame ventanaPadre, Partida unaPartida, Sistema sis) {
        super(ventanaPadre, true);
        initComponents();
        partida = unaPartida;
        modelo = sis;
        // crear botones y agregarlos al panel 
        jGrilla.setLayout(new GridLayout(partida.getDimension() + 1, partida.getDimension() + 1));
        botones = new JButton[partida.getDimension() + 1][partida.getDimension() + 1];
        String[] filaLetras = {"A", "B", "C", "D", "E", "F", "G", "H"};
        for (int i = 0; i < partida.getDimension() + 1; i++) {
            for (int j = 0; j < partida.getDimension() + 1; j++) {
                JButton jButton = new JButton();
                if (i > 0 && j > 0) {
                    jButton.addActionListener(new ListenerBoton(i, j));
                    jButton.addMouseListener(new ListenerMouse(i, j));
                } else {
                    jButton.setEnabled(false);
                    if (j == 0 && i != 0) {
                        jButton.setText(filaLetras[i - 1]);
                    } else if (j != 0) {
                        jButton.setText(String.valueOf(j));
                    } else {
                        jButton.setBorderPainted(false);
                    }
                }
                jGrilla.add(jButton);
                botones[i][j] = jButton;
            }
        }
        if (partida.getDimension() == 4) {
            jGrilla.setSize(250, 250);
            jGrilla.setLocation(70, 70);
        } else if (partida.getDimension() == 6) {
            jGrilla.setSize(350, 350);
        } else {
            jGrilla.setSize(380, 380);
        }
        jTxtTurno.setText(partida.jugadorDeTurnoToString());
        jTxtCantFichas.setText(partida.cantFichas());
        jBtnColorActual.setBackground(partida.getColorJugadorActual());
        jChBxMoverPanel.setEnabled(false);
    }

    public Sistema getModelo() {
        return modelo;
    }

    public void setModelo(Sistema modelo) {
        this.modelo = modelo;
    }

    private class ListenerTimer implements ActionListener {

        private Ficha[][] matAux;
        private java.awt.Color colorJugadorActual;

        public ListenerTimer(Ficha[][] unaMatAux, java.awt.Color unColor) {
            // en el constructor que almacena la matriz
            matAux = unaMatAux;
            colorJugadorActual = unColor;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            ((Timer) (e.getSource())).stop();
            for (int i = 0; i < matAux.length; i++) {
                for (int j = 0; j < matAux.length; j++) {
                    if (matAux[i][j].getColor().equals(Ficha.Color.asterisco)) {
                        botones[i + 1][j + 1].setBackground(colorJugadorActual);
                    }
                }
            }
            partida.reiniciarMatAux();
        }
    }

    private class ListenerBoton implements ActionListener {

        private int x;
        private int y;

        public ListenerBoton(int i, int j) {
            // en el constructor se almacena la fila y columna que se presionó 
            x = i;
            y = j;
        }

        public void actionPerformed(ActionEvent e) {
            // cuando se presiona un botón, se ejecutará este método 
            clickBoton(x, y);
        }

    }

    private class ListenerMouse implements MouseListener {

        private int x;
        private int y;

        public ListenerMouse(int i, int j) {
            // en el constructor se almacena la fila y columna que se presionó 
            x = i;
            y = j;
        }

        public void actionPerformed(ActionEvent e) {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            pasaElMouse(x, y);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            saleElMouse(x, y);
        }
    }

    private void saleElMouse(int fila, int columna) {
        Border bordeNormal = jBtnRetirarse.getBorder();
        Border borde = new LineBorder(mezclaColor(), 3);
        if (jChBxMoverPanel.isSelected() || jChBxPonerPanel.isSelected()) {
            if (partida.obtenerPanel().dimPanel() == 2) {
                for (int i = 0; i < 2 && fila < partida.getDimension(); i++) {
                    for (int j = 0; j < 2 && columna < partida.getDimension(); j++) {
                        botones[fila + i][columna + j].setBorder(bordeNormal);
                    }
                }
            } else if (partida.obtenerPanel().dimPanel() == 3) {
                for (int i = 0; i < 3 && fila < partida.getDimension() - 1; i++) {
                    for (int j = 0; j < 3 && columna < partida.getDimension() - 1; j++) {
                        botones[fila + i][columna + j].setBorder(bordeNormal);
                    }
                }
            } else if (partida.obtenerPanel().dimPanel() == 4) {
                for (int i = 0; i < 4 && fila < partida.getDimension() - 2; i++) {
                    for (int j = 0; j < 4 && columna < partida.getDimension() - 2; j++) {
                        botones[fila + i][columna + j].setBorder(bordeNormal);
                    }
                }
            }
            if (partida.getPosColPanel() >= 0 && partida.getPosFilaPanel() >= 0) {
                for (int i = 0; i < partida.getDimension(); i++) {
                    for (int j = 0; j < partida.getDimension(); j++) {
                        if (partida.fichaDentroPanel(i, j)) {
                            botones[i + 1][j + 1].setBorder(borde);
                        }
                    }
                }
            }
        }
    }

    private void dibujarBorde(int fila, int columna) {
        Border bordeMovimiento = new LineBorder(mezclaColor().darker(), 3);
        if (partida.obtenerPanel().dimPanel() == 2) {
            for (int i = 0; i < 2 && fila < partida.getDimension(); i++) {
                for (int j = 0; j < 2 && columna < partida.getDimension(); j++) {
                    botones[fila + i][columna + j].setBorder(bordeMovimiento);
                }
            }
        } else if (partida.obtenerPanel().dimPanel() == 3) {
            for (int i = 0; i < 3 && fila < partida.getDimension() - 1; i++) {
                for (int j = 0; j < 3 && columna < partida.getDimension() - 1; j++) {
                    botones[fila + i][columna + j].setBorder(bordeMovimiento);
                }
            }
        } else if (partida.obtenerPanel().dimPanel() == 4) {
            for (int i = 0; i < 4 && fila < partida.getDimension() - 2; i++) {
                for (int j = 0; j < 4 && columna < partida.getDimension() - 2; j++) {
                    botones[fila + i][columna + j].setBorder(bordeMovimiento);
                }
            }
        }
    }

    private void pasaElMouse(int fila, int columna) {
        String[] filaLetras = {"A", "B", "C", "D", "E", "F", "G", "H"};
        jTxtCoordenadas.setText(filaLetras[fila - 1] + " " + columna);
        if (jChBxPonerPanel.isSelected()) {
            dibujarBorde(fila, columna);
        }
        if (jChBxMoverPanel.isSelected() && (fila == partida.getPosFilaPanel() + 1
                || columna == partida.getPosColPanel() + 1)) {
            dibujarBorde(fila, columna);
        }
    }

    public Color mezclaColor() {
        int colorAzul = (partida.obtenerColorUno().getBlue()
                + partida.obtenerColorDos().getBlue()) / 2;
        int colorRojo = (partida.obtenerColorUno().getRed()
                + partida.obtenerColorDos().getRed()) / 2;
        int colorVerde = (partida.obtenerColorUno().getGreen()
                + partida.obtenerColorDos().getGreen()) / 2;
        return new Color(colorRojo, colorVerde, colorAzul);
    }

    private void clickBoton(int fila, int columna) {
        // En fila y columna se reciben las coordenas donde presionó el usuario, relativas al comienzo de la grilla 
        // fila 1 y columna 1 corresponden a la posición de arriba a la izquierda. 
        Timer t;
        String[] filaLetras = {"A", "B", "C", "D", "E", "F", "G", "H"};
        java.awt.Color colorJugadorActual = partida.getColorJugadorActual();
        Border bordePanel = new LineBorder(mezclaColor(), 3);
        Border bordeNormal = jBtnRetirarse.getBorder();
        jTxtCoordenadas.setText(filaLetras[fila - 1] + " " + columna);

        if (jChBxPonerFicha.isSelected()) {
            String comando = "J" + filaLetras[fila - 1] + String.valueOf(columna);
            Color colorJugadorAct = partida.getColorJugadorActual();
            String retorno = partida.entenderJugada(comando);
            if (retorno.equals("ok")) {
                botones[fila][columna].setBackground(colorJugadorActual);
                if (partida.haySimetria()) {
                    t = new Timer(270, new ListenerTimer(partida.obtenerMatAux(), colorJugadorAct));
                    t.start();
                    for (int i = 0; i < partida.obtenerMatAux().length; i++) {
                        for (int j = 0; j < partida.obtenerMatAux().length; j++) {
                            if (partida.obtenerMatAux()[i][j].getColor().equals(Ficha.Color.asterisco)) {
                                botones[i + 1][j + 1].setBackground(mezclaColor());
                            }
                        }
                    }
                }
                jTxtTurno.setText(partida.jugadorDeTurnoToString());
                jTxtCantFichas.setText(partida.cantFichas());
                jBtnColorActual.setBackground(partida.getColorJugadorActual());
            } else if (retorno.equals("No hay más fichas")) {
                JOptionPane.showMessageDialog(this, "No hay más fichas.",
                        "ERROR", JOptionPane.OK_OPTION);
            } else {
                JOptionPane.showMessageDialog(this, "Esa coordenada no es válida",
                        "ERROR", JOptionPane.OK_OPTION);
            }
        }
        if (jChBxPonerPanel.isSelected()) {
            String comando = "P" + filaLetras[fila - 1] + String.valueOf(columna);
            String retorno = partida.entenderJugada(comando);
            if (retorno.equals("ok")) {
                for (int i = 0; i < partida.getDimension(); i++) {
                    for (int j = 0; j < partida.getDimension(); j++) {
                        if (partida.fichaDentroPanel(i, j)) {
                            botones[i + 1][j + 1].setBorder(bordePanel);
                        }
                    }
                }
                recorridaInterfaz();
                jBtnColorActual.setBackground(partida.getColorJugadorActual());
                jChBxPonerFicha.setSelected(true);
                jChBxPonerPanel.setEnabled(false);
                jChBxMoverPanel.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "Panel no válido",
                        "ERROR", JOptionPane.OK_OPTION);
            }
        }

        if (jChBxMoverPanel.isSelected()) {
            String comando = "M";
            if (fila - 1 == partida.getPosFilaPanel()) {
                if (columna - 1 > partida.getPosColPanel()) {
                    comando += "D" + String.valueOf(columna - 1 - partida.getPosColPanel());
                }
                if (columna - 1 < partida.getPosColPanel()) {
                    comando += "I" + String.valueOf(partida.getPosColPanel() - (columna - 1));
                }
            }
            if (columna - 1 == partida.getPosColPanel()) {
                if (fila - 1 > partida.getPosFilaPanel()) {
                    comando += "B" + String.valueOf(fila - 1 - partida.getPosFilaPanel());;
                }
                if (fila - 1 < partida.getPosFilaPanel()) {
                    comando += "A" + String.valueOf(partida.getPosFilaPanel() - (fila - 1));;
                }
            }
            String retorno = partida.entenderJugada(comando);
            if (retorno.equals("ok")) {
                for (int i = 0; i < partida.getDimension(); i++) {
                    for (int j = 0; j < partida.getDimension(); j++) {
                        if (partida.fichaDentroPanel(i, j)) {
                            botones[i + 1][j + 1].setBorder(bordePanel);
                        } else {
                            botones[i + 1][j + 1].setBorder(bordeNormal);
                        }
                    }
                }
                recorridaInterfaz();
                jBtnColorActual.setBackground(partida.getColorJugadorActual());
            } else {
                JOptionPane.showMessageDialog(this, "Movimiento de panel no válido",
                        "ERROR", JOptionPane.OK_OPTION);
            }
        }

        if (jChBxLimpieza.isSelected()) {
            String comando = "L" + filaLetras[fila - 1] + String.valueOf(columna);
            String retorno = partida.entenderJugada(comando);
            if (retorno.equals("ok")) {
                recorridaInterfaz();
                jBtnColorActual.setBackground(partida.getColorJugadorActual());
            } else {
                JOptionPane.showMessageDialog(this, "La ficha de limpieza ya ha sido utilizada.",
                        "ERROR", JOptionPane.OK_OPTION);
            }

        }
        if (!partida.seguirJugando()) {
            JOptionPane.showMessageDialog(this, partida.resultadoJuego(),
                    "Juego Terminado", JOptionPane.OK_OPTION);
            dispose();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupJugada = new javax.swing.ButtonGroup();
        jGrilla = new javax.swing.JPanel();
        jLblJugada = new javax.swing.JLabel();
        jChBxPonerFicha = new javax.swing.JCheckBox();
        jChBxPonerPanel = new javax.swing.JCheckBox();
        jChBxMoverPanel = new javax.swing.JCheckBox();
        jBtnRetirarse = new javax.swing.JButton();
        jChBxLimpieza = new javax.swing.JCheckBox();
        jLblCoordenadas = new javax.swing.JLabel();
        jTxtCoordenadas = new javax.swing.JTextField();
        jTxtTurno = new javax.swing.JTextField();
        jLblTurno = new javax.swing.JLabel();
        jBtnColorActual = new javax.swing.JButton();
        jLblColor = new javax.swing.JLabel();
        jLblCantFichas = new javax.swing.JLabel();
        jTxtCantFichas = new javax.swing.JTextField();
        jBtnCambiarColor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Perfección");
        setMinimumSize(new java.awt.Dimension(632, 467));
        setPreferredSize(new java.awt.Dimension(632, 467));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(jGrilla);
        jGrilla.setBounds(10, 40, 390, 390);

        jLblJugada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLblJugada.setForeground(new java.awt.Color(0, 0, 153));
        jLblJugada.setText("Seleccione su jugada:");
        getContentPane().add(jLblJugada);
        jLblJugada.setBounds(410, 50, 150, 30);

        buttonGroupJugada.add(jChBxPonerFicha);
        jChBxPonerFicha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jChBxPonerFicha.setSelected(true);
        jChBxPonerFicha.setText("Poner ficha");
        getContentPane().add(jChBxPonerFicha);
        jChBxPonerFicha.setBounds(410, 90, 110, 23);

        buttonGroupJugada.add(jChBxPonerPanel);
        jChBxPonerPanel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jChBxPonerPanel.setText("Poner panel");
        getContentPane().add(jChBxPonerPanel);
        jChBxPonerPanel.setBounds(410, 170, 110, 23);

        buttonGroupJugada.add(jChBxMoverPanel);
        jChBxMoverPanel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jChBxMoverPanel.setText("Mover panel");
        getContentPane().add(jChBxMoverPanel);
        jChBxMoverPanel.setBounds(410, 210, 110, 23);

        jBtnRetirarse.setText("Retirarse");
        jBtnRetirarse.setAutoscrolls(true);
        jBtnRetirarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRetirarseActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnRetirarse);
        jBtnRetirarse.setBounds(470, 400, 90, 30);

        buttonGroupJugada.add(jChBxLimpieza);
        jChBxLimpieza.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jChBxLimpieza.setText("Poner ficha limpieza");
        getContentPane().add(jChBxLimpieza);
        jChBxLimpieza.setBounds(410, 130, 131, 23);

        jLblCoordenadas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLblCoordenadas.setText("Coordenadas");
        getContentPane().add(jLblCoordenadas);
        jLblCoordenadas.setBounds(410, 260, 110, 20);

        jTxtCoordenadas.setEditable(false);
        jTxtCoordenadas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(jTxtCoordenadas);
        jTxtCoordenadas.setBounds(410, 290, 150, 20);

        jTxtTurno.setEditable(false);
        jTxtTurno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(jTxtTurno);
        jTxtTurno.setBounds(80, 10, 100, 20);

        jLblTurno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLblTurno.setText("Turno de:");
        getContentPane().add(jLblTurno);
        jLblTurno.setBounds(10, 10, 60, 20);

        jBtnColorActual.setBorder(null);
        getContentPane().add(jBtnColorActual);
        jBtnColorActual.setBounds(240, 10, 30, 23);

        jLblColor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLblColor.setText("Color:");
        getContentPane().add(jLblColor);
        jLblColor.setBounds(200, 10, 50, 20);

        jLblCantFichas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLblCantFichas.setText("Cantidad fichas:");
        getContentPane().add(jLblCantFichas);
        jLblCantFichas.setBounds(300, 10, 100, 20);

        jTxtCantFichas.setBackground(new java.awt.Color(240, 240, 240));
        getContentPane().add(jTxtCantFichas);
        jTxtCantFichas.setBounds(400, 10, 40, 20);

        jBtnCambiarColor.setText("Cambiar color");
        jBtnCambiarColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCambiarColorActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnCambiarColor);
        jBtnCambiarColor.setBounds(410, 330, 150, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnRetirarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRetirarseActionPerformed
        partida.entenderJugada("X");
        JOptionPane.showMessageDialog(this, partida.resultadoJuego(),
                "", JOptionPane.OK_OPTION);
        dispose();
    }//GEN-LAST:event_jBtnRetirarseActionPerformed

    private void jBtnCambiarColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCambiarColorActionPerformed
        VentanaColor v = new VentanaColor(this, partida.getColorJugadorActual());
        v.setLocationRelativeTo(this);
        v.setVisible(true);
        if (v.getColor() != null) {
            if (!partida.getColorElOtroJugador().equals(v.getColor())) {
                partida.setColorJugadorActual(v.getColor());
                recorridaInterfaz();
                jBtnColorActual.setBackground(partida.getColorJugadorActual());
                if (partida.getPosColPanel() >= 0 && partida.getPosFilaPanel() >= 0) {
                    Border bordePanel = new LineBorder(mezclaColor(), 3);
                    for (int i = 0; i < partida.getDimension(); i++) {
                        for (int j = 0; j < partida.getDimension(); j++) {
                            if (partida.fichaDentroPanel(i, j)) {
                                botones[i + 1][j + 1].setBorder(bordePanel);
                            }
                        }
                    }
                }
            }
            else {
                JOptionPane.showMessageDialog(this, "Ambos jugadores no pueden tener el mismo color",
                        "ERROR", JOptionPane.OK_OPTION);
            }
        }
    }//GEN-LAST:event_jBtnCambiarColorActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que desea salir?",
                null, JOptionPane.OK_CANCEL_OPTION);
        if (respuesta == JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(this, partida.resultadoJuegoNoTerminado(),
                    "Juego Terminado", JOptionPane.OK_OPTION);
            dispose();
        }

    }//GEN-LAST:event_formWindowClosing

    private void recorridaInterfaz() {
        for (int i = 0; i < partida.getDimension(); i++) {
            for (int j = 0; j < partida.getDimension(); j++) {
                if (partida.obtenerFicha(i, j).getColor().equals(Ficha.Color.B)) {
                    botones[i + 1][j + 1].setBackground(partida.obtenerColorUno());
                } else if (partida.obtenerFicha(i, j).getColor().equals(Ficha.Color.N)) {
                    botones[i + 1][j + 1].setBackground(partida.obtenerColorDos());
                } else {
                    botones[i + 1][j + 1].setBackground(jBtnRetirarse.getBackground());
                }
            }
        }
        jTxtTurno.setText(partida.jugadorDeTurnoToString());
        jTxtCantFichas.setText(partida.cantFichas());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupJugada;
    private javax.swing.JButton jBtnCambiarColor;
    private javax.swing.JButton jBtnColorActual;
    private javax.swing.JButton jBtnRetirarse;
    private javax.swing.JCheckBox jChBxLimpieza;
    private javax.swing.JCheckBox jChBxMoverPanel;
    private javax.swing.JCheckBox jChBxPonerFicha;
    private javax.swing.JCheckBox jChBxPonerPanel;
    private javax.swing.JPanel jGrilla;
    private javax.swing.JLabel jLblCantFichas;
    private javax.swing.JLabel jLblColor;
    private javax.swing.JLabel jLblCoordenadas;
    private javax.swing.JLabel jLblJugada;
    private javax.swing.JLabel jLblTurno;
    private javax.swing.JTextField jTxtCantFichas;
    private javax.swing.JTextField jTxtCoordenadas;
    private javax.swing.JTextField jTxtTurno;
    // End of variables declaration//GEN-END:variables
}

//Constanza Curzio : 178606 
//Agustin Verdera : 182584