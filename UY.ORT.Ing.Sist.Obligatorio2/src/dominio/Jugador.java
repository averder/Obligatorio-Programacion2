package dominio;

import java.io.Serializable;

public class Jugador implements Comparable<Jugador> , Serializable {

    //Atributos
    private String nombre;
    private int edad;
    private String alias;
    private int cantPartidasGanadas;
    private int cantPartidasJugadas;

    // Métodos de acceso y modificación
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String unNombre) {
        this.nombre = unNombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int unaEdad) {
        this.edad = unaEdad;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String unAlias) {
        this.alias = unAlias;
    }

    public int getCantPartidasGanadas() {
        return cantPartidasGanadas;
    }

    public void setCantPartidasGanadas(int unaCantPartidasGanadas) {
        this.cantPartidasGanadas = unaCantPartidasGanadas;
    }

    public int getCantPartidasJugadas() {
        return cantPartidasJugadas;
    }

    public void setCantPartidasJugadas(int unaCantPartidasJugadas) {
        this.cantPartidasJugadas = unaCantPartidasJugadas;
    }

    //Constructor con parámetros
    public Jugador(String unNombre, int unaEdad, String unAlias, int unaCantPartidasGanadas, int unaCantPartidasJugadas) {
        this.nombre = unNombre;
        this.edad = unaEdad;
        this.alias = unAlias;
        this.cantPartidasGanadas = unaCantPartidasGanadas;
        this.cantPartidasJugadas = unaCantPartidasJugadas;
    }

    //Constructor sin parámetros
    public Jugador() {
        this.nombre = "Sin nombre";
        this.edad = 0;
        this.alias = "Sin alias";
        this.cantPartidasGanadas = 0;
        this.cantPartidasJugadas = 0;
    }

    @Override
    public String toString() {
        return  " Alias: " + this.getAlias() 
                + "  Partidas ganadas: " + this.getCantPartidasGanadas() 
                + "  Partidas jugadas: " + this.getCantPartidasJugadas();
    }

    @Override
    public int compareTo(Jugador j) {
        int resultado = this.getAlias().compareTo(j.getAlias());
        return resultado;
    }
    
    @Override 
    public boolean equals (Object o){
        return ((Jugador)o).getAlias().equals(this.getAlias());
    }
   
}