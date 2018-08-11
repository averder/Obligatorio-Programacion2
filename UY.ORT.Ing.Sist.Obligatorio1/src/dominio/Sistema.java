package dominio;

import java.util.*;

public class Sistema {

    //Atributos
    private ArrayList<Jugador> listaJugadores;

    // Métodos acceso y modificacion
    public Sistema() {
        listaJugadores = new ArrayList<Jugador>();
    } 

    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void registrarJugador(String nombre, int edad, String alias) {
        Jugador jugador = new Jugador(nombre, edad, alias, 0, 0);
        this.listaJugadores.add(jugador);
    }
    
}

