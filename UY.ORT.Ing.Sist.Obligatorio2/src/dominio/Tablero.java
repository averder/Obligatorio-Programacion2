package dominio;

import dominio.Ficha.Color;

public class Tablero {

    //Atributos    
    private Ficha[][] tableroBase;

    public int largoTablero() {
        return tableroBase.length;
    }

    //Constructor con parámetros
    public Tablero(int dimTableroBase) {
        tableroBase = new Ficha[dimTableroBase][dimTableroBase];
        for (int i = 0; i < tableroBase.length; i++) {
            for (int j = 0; j < tableroBase.length; j++) {
                this.tableroBase[i][j] = new Ficha(Color.noHay);
            }
        }
    }

    public void ponerFichaTablero(int unaFila, int unaCol, Ficha ficha) {   
        tableroBase[unaFila][unaCol] = ficha;
    }
    
    public Ficha obtenerFichaTablero(int posFila, int posCol){
        return tableroBase[posFila][posCol];
    }
}