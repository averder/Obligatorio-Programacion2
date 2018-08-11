package interfaz;

import dominio.Jugador;
import java.util.*;
import dominio.Sistema;
import dominio.Partida;
import dominio.Tablero;

public class Interfaz {

    //Atributo sistema
    private Sistema sistema;

    public Interfaz(Sistema sistema) {
        this.setSistema(sistema);
    }

    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

    public void menu() {
        int opcion = 0;
        do {
            opcion = pedirNumeroRestringido(1, 4,
                    "\n+-+-+-+-+-+-+-+-+-+-+\n"
                    + "|P|E|R|F|E|C|C|I|Ó|N|\n"
                    + "+-+-+-+-+-+-+-+-+-+-+"
                    + "\nIngresar número de la opción deseada "
                    + "\n1- Ingresar jugador "
                    + "\n2- Jugar a Perfección "
                    + "\n3- Consulta de jugadores "
                    + "\n4- Salir del juego "
                    + "\n ---------------------------------");

            switch (opcion) {

                case 1:

                    sistema.registrarJugador(
                            ingresarTextoNoVacio("\nIngresar nombre del jugador: "),
                            pedirNumero("\nIngresar edad del jugador: "),
                            validarAlias());
                    break;

                case 2:
                    if (sistema.getListaJugadores().size() >= 2) {
                        Partida partida = inicioJuego();
                        while (partida.seguirJugando()) {
                            System.out.println(partida.imprimirTablero());
                            System.out.println("Es turno del jugador " + partida.obtenerJugadorActual());
                            String jugada = ingresarTextoNoVacio("Ingrese una jugada");
                            String retorno = partida.entenderJugada(jugada);
                            if (!retorno.equals("ok")) {
                                System.out.println("Error: " + retorno);
                            }
                            if (partida.haySimetria()) {
                                System.out.println(partida.imprimirTableroAux());
                            }
                        }
                        System.out.println(partida.resultadoJuego());
                    } else {
                        System.out.println("Primero debe registrar dos jugadores ");
                    }
                    break;

                case 3:
                    if (!sistema.getListaJugadores().isEmpty()) {
                        Collections.sort(sistema.getListaJugadores());
                        mostrarListaJugadores(sistema.getListaJugadores());
                    } else {
                        System.out.println("La lista de jugadores esta vacía");
                    }
                    break;

                case 4:
                    System.out.println("Fin del juego ");
                    break;

            }

        } while (opcion != 4);

    }

    public int pedirNumero(String mensaje) {
        Scanner in = new Scanner(System.in);
        System.out.println(mensaje);
        int num = 0;
        boolean estaOk = true;
        while (estaOk) {
            try {
                num = in.nextInt();
                if (num <= 0) {
                    System.out.println("Ingrese una edad positiva");
                } else {
                    estaOk = false;
                }
            } catch (Exception e) {
                System.out.println("\nDebe ingresar un número ");
                System.out.println("Ingrese nuevamente");
                in.nextLine();
            }
        }

        return num;
    }

    public static String ingresarPalabra() {
        Scanner in = new Scanner(System.in);
        String texto;
        texto = in.nextLine();
        return texto;
    }

    public static String ingresarTextoNoVacio(String mensaje) {
        String texto;
        System.out.println(mensaje);
        texto = ingresarPalabra();
        while (texto.equals("")) {
            System.out.print("Ingrese un texto no vacío: ");
            texto = ingresarPalabra();
        }
        return texto;
    }

    public int pedirNumeroRestringido(int min, int max, String mensaje) {
        Scanner in = new Scanner(System.in);
        System.out.println(mensaje);
        int num = Integer.MIN_VALUE;
        boolean nroValido = false;
        while (!nroValido) {
            try {
                num = in.nextInt();
                if (num < min || num > max) {
                    System.out.println("Ingrese un número entre " + (min) + " y " + (max));
                } else {
                    nroValido = true;
                }
            } catch (Exception e) {
                System.out.println("Debe ingresar un número ");
                System.out.println("Ingrese nuevamente");
                nroValido = false;
                in.nextLine();
            }
        }
        return num;
    }

    public Partida inicioJuego() {
        int cantidadFichasUno = 0;
        int cantidadFichasDos = 0;
        int dimPanel = 0;
        int dimTablero = 0;
        System.out.println("Ingrese el número del jugador deseado");
        mostrarListaJugadores(sistema.getListaJugadores());
        int numJugadorUno = pedirNumeroRestringido(1, sistema.getListaJugadores().size(), "");
        numJugadorUno--;
        Jugador jugadorUno = sistema.getListaJugadores().get(numJugadorUno);
        sistema.getListaJugadores().remove(numJugadorUno);

        System.out.println("Ingrese el número del jugador deseado");
        mostrarListaJugadores(sistema.getListaJugadores());
        int numJugadorDos = pedirNumeroRestringido(1, sistema.getListaJugadores().size(), "");
        numJugadorDos--;
        Jugador jugadorDos = sistema.getListaJugadores().get(numJugadorDos);
        sistema.getListaJugadores().add(jugadorUno);

        int opcionTablero = pedirNumeroRestringido(1, 3, "\nIngrese la opción del tablero que desea: "
                + "\n1-Tablero 4x4" + "\n2-Tablero 6x6 " + "\n3-Tablero 8x8");

        switch (opcionTablero) {
            case 1:
                dimTablero = 4;
                break;
            case 2:
                dimTablero = 6;
                break;
            case 3:
                dimTablero = 8;
                break;
        }

        if (dimTablero == 4) {
            System.out.println("Su panel es de 2x2 ");
            dimPanel = 2;
            cantidadFichasUno = pedirNumeroRestringido(1, 10,
                    "Ingrese la cantidad de fichas por jugador ");
            cantidadFichasDos = cantidadFichasUno;

        }
        if (dimTablero == 6) {
            int opcionPanel = pedirNumeroRestringido(1, 2, "\nIngrese la opción del panel que desea: "
                    + "\n1-Panel 2x2" + "\n2-Panel 3x3 ");
            switch (opcionPanel) {
                case 1:
                    dimPanel = 2;
                    break;
                case 2:
                    dimPanel = 3;
                    break;
            }
            if (dimPanel == 2) {
                cantidadFichasUno = pedirNumeroRestringido(1, 20,
                        "Ingrese la cantidad de fichas por jugador");
                cantidadFichasDos = cantidadFichasUno;
            } else if (dimPanel == 3) {
                cantidadFichasUno = pedirNumeroRestringido(1, 22,
                        "Ingrese la cantidad de fichas por jugador");
                cantidadFichasDos = cantidadFichasUno;
            }
        }
        if (dimTablero == 8) {
            int opcionPanel = pedirNumeroRestringido(1, 3, "\nIngrese la opción del panel que desea: "
                    + "\n1-Panel 2x2" + "\n2-Panel 3x3 " + "\n2-Panel 4x4");
            switch (opcionPanel) {
                case 1:
                    dimPanel = 2;
                    break;
                case 2:
                    dimPanel = 3;
                    break;
                case 3:
                    dimPanel = 4;
                    break;
            }
            if (dimPanel == 2) {
                cantidadFichasUno = pedirNumeroRestringido(1, 34,
                        "Ingrese la cantidad de fichas por jugador ");
                cantidadFichasDos = cantidadFichasUno;

            } else if (dimPanel == 3) {
                cantidadFichasUno = pedirNumeroRestringido(1, 37,
                        "Ingrese la cantidad de fichas por jugador");
                cantidadFichasDos = cantidadFichasUno;
            } else if (dimPanel == 4) {
                cantidadFichasUno = pedirNumeroRestringido(1, 40,
                        "Ingrese la cantidad de fichas por jugador");
                cantidadFichasDos = cantidadFichasUno;
            }
        }
        return new Partida(jugadorUno, jugadorDos, dimTablero, dimPanel, cantidadFichasUno, cantidadFichasDos);
    }

    private void mostrarListaJugadores(ArrayList<Jugador> jugadores) {
        for (int i = 0; i < jugadores.size(); i++) {
            System.out.println("\nJugador " + (i + 1));
            System.out.println(jugadores.get(i));
        }
    }

    private String validarAlias() {
        Jugador jugador = new Jugador();
        boolean correcto = false;
        String alias = "";
        while (!correcto) {
            alias = ingresarTextoNoVacio("\nIngrese un alias para el jugador");
            jugador.setAlias(alias);
            if (sistema.getListaJugadores().contains(jugador)) {
                System.out.println("\nError: ese alias ya está ingresado ");
            } else {
                correcto = true;
            }
        }
        return alias;
    }
}
