package prueba;

import dominio.Sistema;
import interfaz.VentanaInicio;
import interfaz.VentanaMenu;
import persistencia.Persistencia;

public class Prueba {

    public static void main(String[] args) {
        Persistencia per = new Persistencia();
        Sistema sis = per.cargarSistema();
        VentanaInicio vi = new VentanaInicio();
        vi.run();
        VentanaMenu v = new VentanaMenu(sis);
        v.setLocationRelativeTo(null);
        v.setVisible(true);
    }
}
