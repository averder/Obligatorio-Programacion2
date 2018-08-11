package interfaz;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class VentanaInicio extends javax.swing.JFrame {

    
    public class Imagen extends javax.swing.JPanel {

    public Imagen() {
    
        this.setSize(627, 95); //se selecciona el tamaño del panel
    }

    //Se crea un método cuyo parámetro debe ser un objeto Graphics
    public void paint(Graphics grafico) {

    //Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
    ImageIcon Img = new ImageIcon(getClass().getResource("/Imagen/TituloPerfeccion.jpg")); 

    //se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
    grafico.drawImage(Img.getImage(), 0, 0, getSize().width, getSize().height, null);

    setOpaque(false);
    super.paintComponent(grafico);
    }
    }
   
    public VentanaInicio() {
        initComponents();
        this.setLocationRelativeTo(null);
        Imagen Imagen = new Imagen();
        jImg.add(Imagen);
        jImg.repaint();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jImg = new javax.swing.JPanel();

        setAlwaysOnTop(true);
        setUndecorated(true);
        setResizable(false);

        jImg.setMinimumSize(new java.awt.Dimension(627, 95));
        jImg.setPreferredSize(new java.awt.Dimension(627, 95));

        javax.swing.GroupLayout jImgLayout = new javax.swing.GroupLayout(jImg);
        jImg.setLayout(jImgLayout);
        jImgLayout.setHorizontalGroup(
            jImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 627, Short.MAX_VALUE)
        );
        jImgLayout.setVerticalGroup(
            jImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 95, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void run() {       
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        try {                      //me obliga a poner try and catch
            Thread.sleep(1000);   //tiempo en milisegundos
            dispose();
        } catch (InterruptedException ex) {

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jImg;
    // End of variables declaration//GEN-END:variables
}
