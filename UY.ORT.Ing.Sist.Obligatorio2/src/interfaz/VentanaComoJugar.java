package interfaz;

import javax.swing.JFrame;

public class VentanaComoJugar extends javax.swing.JDialog {

    public VentanaComoJugar(JFrame ventanaPadre) {
        super(ventanaPadre, true);
        initComponents();
        jCboBx.setSelectedItem("Poner Ficha");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLblComoJugar = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTxtArea = new javax.swing.JTextArea();
        jCboBx = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Perfección");
        setMinimumSize(new java.awt.Dimension(664, 510));
        setPreferredSize(new java.awt.Dimension(664, 510));
        setResizable(false);
        getContentPane().setLayout(null);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("La patrida se juega de a dos y es por turnos. \nEn cada turno el jugador podrá hacer una jugada.\nLas jugadas pueden ser:");
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 40, 510, 100);

        jLblComoJugar.setFont(new java.awt.Font("Traditional Arabic", 0, 24)); // NOI18N
        jLblComoJugar.setText("¿Cómo jugar?");
        getContentPane().add(jLblComoJugar);
        jLblComoJugar.setBounds(30, 10, 220, 30);

        jTxtArea.setColumns(20);
        jTxtArea.setRows(5);
        jTxtArea.setAlignmentX(1.0F);
        jTxtArea.setAlignmentY(1.0F);
        jTxtArea.setMargin(new java.awt.Insets(5, 8, 5, 5));
        jScrollPane2.setViewportView(jTxtArea);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 190, 260, 240);

        jCboBx.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Poner Ficha", "Poner Ficha Limpieza", "Poner Panel", "Mover Panel", "Rendirse" }));
        jCboBx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboBxActionPerformed(evt);
            }
        });
        getContentPane().add(jCboBx);
        jCboBx.setBounds(20, 150, 200, 30);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("El juego consiste en buscar\nsimetrías de 2x2, 3x3 y 4x4\nde eje vertical u horizontal.\nEn el cuadrado de 3x3, el eje\nde simetría es la fila o columna\ndel medio.Sólo se verifican \nsimetrías al poner una ficha.\nCuando un jugador forma \nuna simetría, las fichas \ninvolucradas cambian de color\nal del jugador de turno. El que \ntenga más fichas visibles al final\nde la partida es el ganador.");
        jTextArea2.setMargin(new java.awt.Insets(5, 8, 5, 5));
        jScrollPane3.setViewportView(jTextArea2);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(340, 160, 290, 270);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCboBxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboBxActionPerformed
        if (jCboBx.getSelectedItem().equals("Poner Ficha")) {
            jTxtArea.setText("El jugador podrá ingresar \n" + 
                "una ficha en un lugar \n"
                + "visible y vacío.");
        }
        else if (jCboBx.getSelectedItem().equals("Poner Ficha Limpieza")) {
            jTxtArea.setText("Esta ficha elimina todas\n"
                + "las fichas ingresadas en\n"
                + "su misma fila y columna\n"
                + "(inclusive la misma ficha \n"
                + "de limpieza).");
        }
        else if(jCboBx.getSelectedItem().equals("Poner Panel")) {
            jTxtArea.setText("El jugador podrá ingresar \n" + 
                    "un panel móvil desde su vértice\n" +
                    "superior izquiero. Sin importar\n" +
                    "si quedan fichas debajo de él.\n" +
                    "Antes de poner el panel se muestran\n" +
                    "las opciones válidas para colocarlo\n" +
                    "sombreadas en el tablero de juego.\n" +
                    "Es posible ingresar fichas sobre él\n" +
                    "y formar simetrías con ellas.\n" +
                    "Sólo se puede ingresar un panel\n" +
                    "por partida.");
        }
        else if (jCboBx.getSelectedItem().equals("Mover Panel")) {
            jTxtArea.setText("El jugador pordrá mover\n" +
                    "el panel hacia arriba, abajo, derecha\n" +
                    "o izquierda, independientemente de si\n" +
                    "hay fichas en su camino. Las fichas que\n" +
                    "sobre el panel se desplazarán con él.\n" + 
                    "Las opciones válidas de movimiento\n" +
                    "aparecerán sombreadas sobre el tablero\n" +
                    "de juego al mover el mouse.");
        }
        else {
            jTxtArea.setText("El juego termina y se muestra\n" +
                    "el jugador ganador de la partida.");
        }
    }//GEN-LAST:event_jCboBxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox jCboBx;
    private javax.swing.JLabel jLblComoJugar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTxtArea;
    // End of variables declaration//GEN-END:variables
}
