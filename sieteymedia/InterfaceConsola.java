package sieteymedia;

import java.util.Scanner;
import recursos.Carta;

public class InterfaceConsola {

    Scanner sc;
    SieteYMedia sieteYMedia;

    InterfaceConsola(){
        this.sc = new Scanner(System.in);
        sieteYMedia = new SieteYMedia();
        this.presentarJuego();
        this.jugar();
    }

    void presentarJuego() {
        System.out.println("- El usuario es el jugador y el ordenador la  banca.");
        System.out.println("- No hay en la baraja 8s y 9s. El 10 es la sota, el 11 el caballo y el 12 el Rey.");
        System.out.println("- las figuras (10-sota, 11-caballo y 12-rey) valen medio punto y, el resto, su valor.");
        System.out.println("- Hay dos turnos de juego: el turno del jugador y el turno de la banca. Se comienza por el turno del jugador.");
        System.out.println("- El jugador va pidiendo cartas a la banca de una en una.");
        System.out.println("- El jugador puede plantarse en cualquier momento.");
        System.out.print("- Si la suma de los valores de las cartas sacadas es superior ");
        System.out.println("a 7 y medio, el jugador 'se pasa de siete y medio' y  pierde.");
        System.out.println("- Si el jugador no se pasa, comienza a sacar cartas la banca y ésta  está obligada a sacar cartas hasta empatar o superar al jugador.");
        System.out.println("- Si la banca consigue empatar o superar la puntuación del jugador 'sin pasarse de siete y medio', gana la banca.");
        System.out.println("- La banca no se puede plantar y tiene que empatar o superar la puntuación del  jugador sin pasarse.");
        System.out.println("- En este proceso puede ocurrir que la banca 'se pase' y entonces pierde la banca y gana el jugador.");
        System.out.println("\nEmpecemos!!!\n");
    }

    void mostrarCartas(boolean jugador){
        Carta[] cartasParaMostrar = sieteYMedia.getCartas(jugador);
        for (int i = 0; i < cartasParaMostrar.length; i++){
                if (cartasParaMostrar[i] != null){
                        System.out.print(cartasParaMostrar[i].toString() + " ");
                }
        }
    }

    void jugar(){
        this.turnoJugador();
        this.turnoBanca();
        System.out.println("Adios");
    }


    void turnoJugador() {
        char opc = 'C';
        // obligamos a que como mínimo se tenga 1 carta
        System.out.println("Como mínimo recibes una carta, luego puedes decidir si seguir o plantarte");
        while (sieteYMedia.comprobarSiSePasa(true) && opc == 'C') {
            Carta c = sieteYMedia.getCarta();
            // insertamos c en las cartas del jugador
            sieteYMedia.insertarCartaEnArray(sieteYMedia.cartasJugador, c);
            // mostramos cartas y su valor, si se pasa se sale del bucle
            System.out.println("Éstas son tus cartas jugador:");
            this.mostrarCartas(true);
            double valor = sieteYMedia.valorCartas(sieteYMedia.cartasJugador);
            System.out.println("\n\tValor de cartas: " + valor);
            if (valor < 7.5) {
                // suponemos que el usuario teclea bien !!!
                System.out.println("\n¿Pides [C]arta o te [P]lantas?");
                opc = sc.next().trim().toUpperCase().charAt(0);
            }
        }
    }

    void turnoBanca() {
        // lo primero es consultar el valor que alcanzó el jugador en su turno
        double valorCartasJugador = sieteYMedia.valorCartas(sieteYMedia.cartasJugador);
        if (valorCartasJugador > 7.5) {
            System.out.println("Jugador, te has pasado en tu jugada anterior, gana la banca");
            return;
        }
        System.out.println("\n\nTurno de banca ...");

        // juega hasta empatar o superar
        while (sieteYMedia.valorCartas(sieteYMedia.cartasBanca) < valorCartasJugador) {
            Carta c = sieteYMedia.getCarta();
            sieteYMedia.insertarCartaEnArray(sieteYMedia.cartasBanca, c);
        }
        System.out.println("Éstas son mis cartas:");
        this.mostrarCartas(false);
        System.out.println("\nValor de  mis cartas(banca): " + sieteYMedia.valorCartas(sieteYMedia.cartasBanca));
        if (sieteYMedia.valorCartas(sieteYMedia.cartasBanca) > 7.5) {
            System.out.println("me pasé, ganas tú,jugador");
        } else {
            System.out.println("Gana la banca");
        }
    }

    public static void main(String[] args) {
        new InterfaceConsola();
    }


}