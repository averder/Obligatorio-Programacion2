
package prueba;

import dominio.Sistema;
import interfaz.Interfaz;

public class Prueba {
    
     public static void main(String[] args) {
         Sistema sist = new Sistema();
         Interfaz interfaz = new Interfaz(sist);
         interfaz.menu();
     }
}
