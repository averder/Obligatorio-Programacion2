package dominio;

public class Panel {

    //Atributos
    private Ficha[][] panel;

    //Constructor con parámetros
    public Panel(int dimension) {
        this.panel = new Ficha[dimension][dimension];
        for (int f = 0; f < this.panel.length; f++) {
            for (int c = 0; c < this.panel.length; c++) {
                this.panel[f][c] = new Ficha(Ficha.Color.noHay);
            }
        }
    }

    public Ficha obtenerFichaPanel(int posFila, int posCol) {
        return panel[posFila][posCol];
    }

    public int dimPanel() {
        return panel.length;
    }

    public void ponerFichaPanel(int unaFila, int unaCol, Ficha ficha) {
        panel[unaFila][unaCol] = ficha;
    }
}
