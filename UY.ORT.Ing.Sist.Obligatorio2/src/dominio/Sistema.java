package dominio;

import java.io.Serializable;
import java.util.*;
import persistencia.ArchivoLectura;

public class Sistema implements Serializable {

    //Atributos
    private ArrayList<Jugador> listaJugadores;

    // Métodos acceso y modificacion
    public Sistema() {
        listaJugadores = new ArrayList<Jugador>();
    }

    public ArrayList<Jugador> getListaJugadores() {
        Collections.sort(listaJugadores);
        return listaJugadores;
    }

    public void setListaJugadores(ArrayList<Jugador> lista) {
        listaJugadores = lista;
    }

    public void registrarJugador(Jugador unJugador) {
        this.listaJugadores.add(unJugador);
    }

    public boolean importarJugadores(String pathArchivo) {
        boolean importoOk = true;
        ArchivoLectura arch = new ArchivoLectura(pathArchivo);
        while (arch.hayMasLineas()) {
            try {
                String linea = arch.linea();
                if (importeValido(linea)) {
                    String[] tokens = linea.split("#");
                    String nombre = tokens[0];
                    int edad = Integer.parseInt(tokens[1]);
                    String alias = tokens[2];
                    Jugador jugador = new Jugador(nombre,edad,alias,0,0);
                    if(listaJugadores.contains(jugador)){
                       int num = listaJugadores.indexOf(jugador);
                       listaJugadores.get(num).setNombre(nombre);
                       listaJugadores.get(num).setEdad(edad);
                    }
                    else {
                        listaJugadores.add(jugador);
                    } 
                }
                else {
                    importoOk = false;
                }
            } catch (Exception err) {
                importoOk = false;
            }
        }
        arch.cerrar();
        return importoOk;
    }

    public boolean importeValido(String linea) {
        char uno = ' ';
        char dos = ' ';
        boolean esValido = true;
        String[] tokens = linea.split("#");
        if (tokens.length != 3 || tokens[0].isEmpty()
                || tokens[1].length() != 2 || tokens[2].isEmpty()) {
            esValido = false;
        } else {
            uno = tokens[1].charAt(0);
            dos = tokens[1].charAt(1);
            if (!Character.isDigit(uno) || !Character.isDigit(dos)) {
                esValido = false;
            }
        }
        return esValido;
    }
}
