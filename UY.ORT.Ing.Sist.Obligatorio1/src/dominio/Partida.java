package dominio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Partida {

    //Atributos 
    private Jugador jugadorUno;
    private Jugador jugadorDos;
    private Jugador jugadorDeTurno;
    private Jugador jugadorPerdedor;
    private Tablero tablero;
    private int posFilaPanel;
    private int posColPanel;
    private Panel panel;
    private Ficha[][] matAux;
    private int cantidadFichasUno;
    private int cantidadFichasDos;
    private boolean haySimetria;

    //Constructor con parámetros 
    public Partida(Jugador unJugadorUno, Jugador unJugadorDos,
            int unaDimTablero, int unaDimPanel, int cantFichasUno, int cantFichasDos) {
        this.jugadorUno = unJugadorUno;
        this.jugadorDos = unJugadorDos;
        this.tablero = new Tablero(unaDimTablero);
        this.panel = new Panel(unaDimPanel);
        this.posFilaPanel = -20;
        this.posColPanel = -20;
        this.matAux = new Ficha[unaDimTablero][unaDimTablero];
        this.cantidadFichasUno = cantFichasUno;
        this.cantidadFichasDos = cantFichasDos;
        this.jugadorDeTurno = jugadorUno;
        this.haySimetria = false;
        for (int i = 0; i < matAux.length; i++) {
            for (int j = 0; j < matAux.length; j++) {
                matAux[i][j] = new Ficha(Ficha.Color.noHay);
            }
        }
    }

    private boolean jugadaDentroRango(String jugada) {
        boolean correcto = false;
        Pattern pat;
        jugada = jugada.substring(1).toUpperCase();
        if (tablero.largoTablero() == 4) {
            pat = Pattern.compile("[A-D][1-4]");

        } else if (tablero.largoTablero() == 6) {
            pat = Pattern.compile("[A-F][1-6]");
        } else {
            pat = Pattern.compile("[A-H][1-8]");
        }
        Matcher mat = pat.matcher(jugada);
        if (mat.matches()) {
            correcto = true;
        }
        return correcto;
    }

    private boolean validarJugada(String jugada) {
        jugada = jugada.toUpperCase();
        char primerComando = jugada.charAt(0);
        boolean esValido = false;
        if (jugada.equals("X")) {
            esValido = true;
        } else if (jugada.length() == 3 && Character.isLetter(jugada.charAt(0))
                && Character.isLetter(jugada.charAt(1)) && Character.isDigit(jugada.charAt(2))) {
            char segundoComando = jugada.charAt(1);
            if (primerComando == 'J' && jugadaDentroRango(jugada)) {
                esValido = true;
            } else if (primerComando == 'P' && jugadaDentroRango(jugada)) {
                esValido = true;
            } else if ((primerComando == 'M') && (segundoComando == 'I'
                    || segundoComando == 'D' || segundoComando == 'A'
                    || segundoComando == 'B')) {
                esValido = true;
            }
        }
        return esValido;
    }

    private String validarFicha(int posFila, int posCol) {
        //!(si está vacía y la posFila y posCol están dentro del rango)
        String retorno = "ok";
        if (!((posFila < tablero.largoTablero()) && (posCol < tablero.largoTablero())
                && posFila >= 0 && posCol >= 0
                && obtenerFicha(posFila, posCol).getColor() == Ficha.Color.noHay)) {
            retorno = "Posición inválida ";
        }
        return retorno;
    }

    //<editor-fold defaultstate="collapsed" desc="Simetrias">
    private boolean hacerSimetrias(int posFila, int posCol, Jugador jugadorActual, Jugador jugadorUno) {
        //simetrías 4x4
        for (int i = posFila - 3; i <= posFila; i++) {
            for (int j = posCol - 3; j <= posCol; j++) {
                if (buscarSimetriasCuatroH(i, j)) {
                    cambiarFichasDeColorAux(i, j, i + 3, j + 3);
                    haySimetria = true;
                }
                if (buscarSimetriasCuatroV(i, j)) {
                    cambiarFichasDeColorAux(i, j, i + 3, j + 3);
                    haySimetria = true;
                }
            }
        }
        //simetrías 3x3
        for (int i = posFila - 2; i <= posFila; i++) {
            for (int j = posCol - 2; j <= posCol; j++) {
                if (buscarSimetriasTresH(i, j)) {
                    cambiarFichasDeColorAux(i, j, i + 2, j + 2);
                    haySimetria = true;
                }
                if (buscarSimetriasTresV(i, j)) {
                    cambiarFichasDeColorAux(i, j, i + 2, j + 2);
                    haySimetria = true;
                }
            }
        }
        //simetrías 2x2
        for (int i = posFila - 1; i <= posFila; i++) {
            for (int j = posCol - 1; j <= posCol; j++) {
                if (buscarSimetriasDosH(i, j)) {
                    cambiarFichasDeColorAux(i, j, i + 1, j + 1);
                    haySimetria = true;
                }
                if (buscarSimetriasDosV(i, j)) {
                    cambiarFichasDeColorAux(i, j, i + 1, j + 1);
                    haySimetria = true;
                }
            }
        }
        return haySimetria;
    }

    private boolean buscarSimetriasTresV(int fi, int ci) {
        boolean ok = hayFichasEnMat(fi, ci);
        for (int i = fi; i <= fi + 2 && ok; i++) {
            if (comparaFicha(i, ci, i, ci + 2)) {
                ok = false;
            }
        }
        return ok;
    }

    private boolean buscarSimetriasTresH(int fi, int ci) {
        boolean ok = hayFichasEnMat(fi, ci);
        for (int i = ci; i <= ci + 2 && ok; i++) {
            if (comparaFicha(fi, i, fi + 2, i)) {
                ok = false;
            }
        }
        return ok;
    }

    private boolean hayFichasEnMat(int fi, int ci) {
        boolean retorno = true;
        for (int i = fi; i <= fi + 2; i++) {
            for (int j = ci; j <= ci + 2; j++) {
                if (obtenerFicha(i, j).getColor().equals(Ficha.Color.noHay)) {
                    retorno = false;
                }
            }
        }

        return retorno;
    }

    private boolean buscarSimetriasDosH(int fi, int ci) {
        boolean ok = true;
        for (int i = ci; i <= ci + 1 && ok; i++) {
            if (comparaFicha(fi, i, fi + 1, i)) {
                ok = false;
            }
        }
        return ok;
    }

    private boolean buscarSimetriasDosV(int fi, int ci) {
        boolean ok = true;
        for (int i = fi; i <= fi + 1 && ok; i++) {
            if (comparaFicha(i, ci, i, ci + 1)) {
                ok = false;
            }
        }
        return ok;
    }

    private boolean buscarSimetriasCuatroV(int fi, int ci) {
        boolean ok = true;
        for (int i = fi; i <= fi + 3 && ok; i++) {
            if (comparaFicha(i, ci, i, ci + 3) && comparaFicha(i, ci + 1, i, ci + 2)) {
                ok = false;
            }
        }
        return ok;
    }

    private boolean buscarSimetriasCuatroH(int fi, int ci) {
        boolean ok = true;
        for (int i = ci; i <= ci + 3 && ok; i++) {
            if (comparaFicha(fi, i, fi + 3, i) && comparaFicha(fi + 1, i, fi + 2, i)) {
                ok = false;
            }
        }
        return ok;
    }
    //</editor-fold>

    private boolean comparaFicha(int filaUno, int colUno, int filaDos, int colDos) {
        return ((!(obtenerFicha(filaUno, colUno).getColor().equals(obtenerFicha(filaDos, colDos).getColor())))
                || obtenerFicha(filaUno, colUno).getColor().equals(Ficha.Color.noHay));
    }

    private void cambiarFichasDeColor() {
        for (int i = 0; i < matAux.length; i++) {
            for (int j = 0; j < matAux.length; j++) {
                if (matAux[i][j].getColor().equals(Ficha.Color.asterisco)) {
                    if (jugadorDeTurno.equals(jugadorUno)) {
                        obtenerFicha(i, j).setColor(Ficha.Color.B);
                    } else {
                        obtenerFicha(i, j).setColor(Ficha.Color.N);
                    }
                }
            }
        }
    }

    private void cambiarFichasDeColorAux(int fi, int ci, int ff, int cf) {
        for (int f = fi; f <= ff; f++) {
            for (int c = ci; c <= cf; c++) {
                if (Ficha.Color.N.equals(obtenerFicha(f, c).getColor())
                        || Ficha.Color.B.equals(obtenerFicha(f, c).getColor())) {
                    matAux[f][c].setColor(Ficha.Color.asterisco);
                }
            }
        }
    }

    private String moverPanel(char direccion, int cantMovimiento) {
        String retorno = "El movimiento del panel no es válido ";
        int posFPanel = posFilaPanel;
        int posCPanel = posColPanel;
        if (direccion == 'A') {
            posFPanel -= cantMovimiento + 1;
        }
        if (direccion == 'B') {
            posFPanel += cantMovimiento + 1;
        }
        if (direccion == 'I') {
            posCPanel -= cantMovimiento + 1;
        }
        if (direccion == 'D') {
            posCPanel += cantMovimiento + 1;
        }
        if (cantMovimiento != -1 && ponerPanelValido(posFPanel, posCPanel)) {
            posFilaPanel = posFPanel;
            posColPanel = posCPanel;
            retorno = "ok";
        }
        return retorno;
    }

    private String ponerPanel(int unaFila, int unaCol) {
        String retorno = "Posición del panel inválida";
        if (ponerPanelValido(unaFila, unaCol) && !(posColPanel >= 0 && posFilaPanel >= 0)) {
            posFilaPanel = unaFila;
            posColPanel = unaCol;
            retorno = "ok";
        }
        return retorno;
    }

    private boolean ponerPanelValido(int posFila, int posCol) {
        boolean retorno = false;
        int dentroRango = tablero.largoTablero() - panel.dimPanel();
        if (posFila >= 0 && posCol >= 0 && posFila <= dentroRango
                && posCol <= dentroRango) {
            retorno = true;
        }
        return retorno;
    }

    private boolean fichaDentroPanel(int posFila, int posCol) {
        boolean retorno = false;
        if (posFila >= posFilaPanel && posCol >= posColPanel
                && posFila <= posFilaPanel + panel.dimPanel() - 1
                && posCol <= posColPanel + panel.dimPanel() - 1) {
            retorno = true;
        }
        return retorno;
    }

    private void cambiarTurno() {
        if (jugadorDeTurno.equals(jugadorUno)) {
            jugadorDeTurno = jugadorDos;
        } else {
            jugadorDeTurno = jugadorUno;
        }
    }

    private Jugador conteoFichas() {
        Jugador jugadorGano = new Jugador();
        int cantNegras = 0;
        int cantBlancas = 0;
        for (int i = 0; i < tablero.largoTablero(); i++) {
            for (int j = 0; j < tablero.largoTablero(); j++) {
                if (obtenerFicha(i, j).getColor().equals(Ficha.Color.B)) {
                    cantBlancas++;
                }
                if (obtenerFicha(i, j).getColor().equals(Ficha.Color.N)) {
                    cantNegras++;
                }
            }
        }
        if (cantNegras > cantBlancas) {
            jugadorGano = jugadorDos;
            jugadorDos.setCantPartidasGanadas(jugadorDos.getCantPartidasGanadas() + 1);
        }
        if (cantBlancas > cantNegras) {
            jugadorGano = jugadorUno;
            jugadorUno.setCantPartidasGanadas(jugadorUno.getCantPartidasGanadas() + 1);
        }
        jugadorUno.setCantPartidasJugadas(jugadorUno.getCantPartidasJugadas() + 1);
        jugadorDos.setCantPartidasJugadas(jugadorDos.getCantPartidasJugadas() + 1);
        return jugadorGano;
    }

    private void reiniciarMatAux() {
        for (int i = 0; i < matAux.length; i++) {
            for (int j = 0; j < matAux.length; j++) {
                matAux[i][j].setColor(Ficha.Color.noHay);
            }
        }
    }

    private Ficha obtenerFicha(int posFila, int posCol) {
        Ficha ficha = new Ficha(Ficha.Color.noHay);
        if (posFila >= 0 && posCol >= 0 && posFila < tablero.largoTablero()
                && posCol < tablero.largoTablero()) {
            if (posFilaPanel > posFila || posColPanel > posCol
                    || posCol > (posColPanel + panel.dimPanel() - 1)
                    || posFila > (posFilaPanel + panel.dimPanel() - 1)) {
                //está en el tablero base
                ficha = tablero.obtenerFichaTablero(posFila, posCol);
            } else {
                //está en el panel
                ficha = panel.obtenerFichaPanel(posFila - posFilaPanel, posCol - posColPanel);
            }
        }
        return ficha;
    }

    public String entenderJugada(String jugada) {
        String retorno = "ok";
        if (validarJugada(jugada)) {
            int posFila = 0;
            char[] filaLetras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
            jugada = jugada.toUpperCase();
            char primerComando = jugada.charAt(0);
            if (jugada.equals("X")) {
                jugadorPerdedor = jugadorDeTurno;
                if (jugadorDeTurno.equals(jugadorUno)) {
                    jugadorDos.setCantPartidasGanadas(jugadorDos.getCantPartidasGanadas() + 1);
                    jugadorUno.setCantPartidasJugadas(jugadorUno.getCantPartidasJugadas() + 1);
                    jugadorDos.setCantPartidasJugadas(jugadorDos.getCantPartidasJugadas() + 1);
                } else {
                    jugadorUno.setCantPartidasGanadas(jugadorUno.getCantPartidasGanadas() + 1);
                    jugadorUno.setCantPartidasJugadas(jugadorUno.getCantPartidasJugadas() + 1);
                    jugadorDos.setCantPartidasJugadas(jugadorDos.getCantPartidasJugadas() + 1);
                }
                jugadorDeTurno = null;
            } else {
                char segundoComando = jugada.charAt(1);
                int tercerComando = ((int) (jugada.charAt(2))) - 49;
                if (primerComando == 'J') {
                    for (int i = 0; i < filaLetras.length; i++) {
                        if (filaLetras[i] == segundoComando) {
                            posFila = i;
                        }
                    }
                    retorno = validarFicha(posFila, tercerComando);
                    if (validarFicha(posFila, tercerComando).equals("ok")) {
                        if ((jugadorDeTurno.equals(jugadorUno) && cantidadFichasUno != 0)
                                || jugadorDeTurno.equals(jugadorDos) && cantidadFichasDos != 0) {
                            if (!fichaDentroPanel(posFila, tercerComando)) {
                                //Si no está dentro del panel
                                if (jugadorDeTurno.equals(jugadorUno)) {
                                    tablero.ponerFichaTablero(posFila, tercerComando, new Ficha(Ficha.Color.B));
                                    cantidadFichasUno--;
                                } else {
                                    tablero.ponerFichaTablero(posFila, tercerComando, new Ficha(Ficha.Color.N));
                                    cantidadFichasDos--;
                                }
                            } else {
                                //Si está dentro del panel
                                if (jugadorDeTurno.equals(jugadorUno)) {
                                    panel.ponerFichaPanel(posFila - posFilaPanel, tercerComando - posColPanel, new Ficha(Ficha.Color.B));
                                    cantidadFichasUno--;
                                } else {
                                    panel.ponerFichaPanel(posFila - posFilaPanel, tercerComando - posColPanel, new Ficha(Ficha.Color.N));
                                    cantidadFichasDos--;
                                }
                            }
                        }
                        else {
                            retorno ="No hay más fichas";
                        }

                    }
                    if (retorno.equals("ok")) {
                        hacerSimetrias(posFila, tercerComando, jugadorDeTurno, jugadorUno);
                    }
                    if (haySimetria) {
                        cambiarFichasDeColor();
                    }
                    if (retorno.equals("ok")) {
                        cambiarTurno();
                    }
                } else if (primerComando == 'P') {
                    for (int i = 0; i < filaLetras.length; i++) {
                        if (filaLetras[i] == segundoComando) {
                            posFila = i;
                        }
                    }
                    retorno = ponerPanel(posFila, tercerComando);
                    if (retorno.equals("ok")) {
                        cambiarTurno();
                    }
                } else if (primerComando == 'M') {
                    retorno = moverPanel(segundoComando, tercerComando);
                    if (retorno.equals("ok")) {
                        cambiarTurno();
                    }
                }
            }
        } else {
            //la jugada no es válida
            retorno = "Ingreso una jugada inválida ";
        }
        return retorno;
    }

    public boolean haySimetria() {
        boolean retorno = haySimetria;
        this.haySimetria = false;
        return retorno;
    }

    public String obtenerJugadorActual() {
        String retorno = "negro";
        if (jugadorDeTurno.equals(jugadorUno)) {
            retorno = "blanco";
        }
        return retorno;
    }

    public boolean seguirJugando() {
        boolean retorno = true;
        if ((cantidadFichasUno == 0 && cantidadFichasDos == 0) || jugadorDeTurno == null) {
            retorno = false;
        }
        return retorno;
    }

    public String resultadoJuego() {
        String resultado = "El jugador que gano es ";
        if (cantidadFichasDos == 0 && cantidadFichasUno == 0) {
            if (conteoFichas().equals(jugadorUno)) {
                resultado += jugadorUno.getAlias();
            } else if (conteoFichas().equals(jugadorDos)) {
                resultado += jugadorDos.getAlias();
            } else {
                resultado = "La partida ha terminado en empate";
            }
        } else {
            if (jugadorUno.equals(jugadorPerdedor)) {
                resultado += jugadorDos.getAlias();
            }
            if (jugadorDos.equals(jugadorPerdedor)) {
                resultado += jugadorUno.getAlias();
            }
        }
        return resultado;
    }

    public String imprimirTablero() {
        char[] filaLetras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        //imprimo cabecera números
        String retorno = "   ";
        for (int i = 1; i <= tablero.largoTablero(); i++) {
            retorno += " " + i;
        }
        // fin imprimo cabecera números

        // comienzo imprimo +-     
        retorno += "\n   ";
        for (int i = 0; i < tablero.largoTablero(); i++) {
            if (fichaDentroPanel(0, i)) {
                retorno += "##";
            } else if (fichaDentroPanel(0, i - 1)) {
                retorno += "#-";
            } else {
                if (i == tablero.largoTablero()) {
                    retorno += "#";
                } else {
                    retorno += "+-";
                }

            }
        }

        if (fichaDentroPanel(0, tablero.largoTablero() - 1)) {
            retorno += "#\n";
        } else {
            retorno += "+\n";
        }

        // fin imprimo +-
        //imprimo letras en fila y letras (or espacio)(+-)
        for (int i = 0; i < tablero.largoTablero(); i++) {
            retorno += String.valueOf(filaLetras[i]) + "  ";
            for (int j = 0; j < tablero.largoTablero(); j++) {

                if (fichaDentroPanel(i, j)) {
                    retorno += "#" + obtenerFicha(i, j);
                } else if (fichaDentroPanel(i, j - 1)) {
                    retorno += "#" + obtenerFicha(i, j);
                } else {
                    retorno += "|" + obtenerFicha(i, j);
                }

            }
            if (fichaDentroPanel(i, tablero.largoTablero() - 1)) {
                retorno += "#";
            } else {
                retorno += "|";
            }

            retorno += "\n   ";
            for (int k = 0; k < tablero.largoTablero(); k++) {
                if (fichaDentroPanel(i, k) || fichaDentroPanel(i + 1, k)) {
                    retorno += "##";
                } else if (fichaDentroPanel(i, k - 1) || fichaDentroPanel(i + 1, k - 1)) {
                    retorno += "#-";
                } else {
                    retorno += "+-";
                }
            }

            if (fichaDentroPanel(i, tablero.largoTablero() - 1)
                    || fichaDentroPanel(i + 1, tablero.largoTablero() - 1)) {
                retorno += "#\n";
            } else {
                retorno += "+\n";
            }
        }
        return retorno;
    }

    public String imprimirTableroAux() {
        char[] filaLetras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        //imprimo cabecera números
        String retorno = "   ";
        for (int i = 1; i <= tablero.largoTablero(); i++) {
            retorno += " " + i;
        }
        // fin imprimo cabecera números

        // comienzo imprimo +-     
        retorno += "\n   ";
        for (int i = 0; i < tablero.largoTablero(); i++) {
            if (fichaDentroPanel(0, i)) {
                retorno += "##";
            } else if (fichaDentroPanel(0, i - 1)) {
                retorno += "#-";
            } else {
                if (i == tablero.largoTablero()) {
                    retorno += "#";
                } else {
                    retorno += "+-";
                }

            }
        }

        if (fichaDentroPanel(0, tablero.largoTablero() - 1)) {
            retorno += "#\n";
        } else {
            retorno += "+\n";
        }

        // fin imprimo +-
        //imprimo letras en fila y letras (or espacio)(+-)
        for (int i = 0; i < matAux.length; i++) {
            retorno += String.valueOf(filaLetras[i]) + "  ";
            for (int j = 0; j < matAux.length; j++) {

                if (fichaDentroPanel(i, j)) {
                    retorno += "#" + matAux[i][j];
                } else if (fichaDentroPanel(i, j - 1)) {
                    retorno += "#" + matAux[i][j];
                } else {
                    retorno += "|" + matAux[i][j];
                }

            }
            if (fichaDentroPanel(i, matAux.length - 1)) {
                retorno += "#";
            } else {
                retorno += "|";
            }

            retorno += "\n   ";
            for (int k = 0; k < matAux.length; k++) {
                if (fichaDentroPanel(i, k) || fichaDentroPanel(i + 1, k)) {
                    retorno += "##";
                } else if (fichaDentroPanel(i, k - 1) || fichaDentroPanel(i + 1, k - 1)) {
                    retorno += "#-";
                } else {
                    retorno += "+-";
                }
            }

            if (fichaDentroPanel(i, matAux.length - 1)
                    || fichaDentroPanel(i + 1, matAux.length - 1)) {
                retorno += "#\n";
            } else {
                retorno += "+\n";
            }
        }
        reiniciarMatAux();
        return retorno;
    }

}
