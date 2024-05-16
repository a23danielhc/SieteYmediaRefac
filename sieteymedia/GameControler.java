// package sieteymedia;

// import java.util.Scanner;
// import recursos.Baraja;
// import recursos.Carta;

// public class GameControler {
//     Baraja baraja;
//     Carta[] cartasJugador;
//     Carta[] cartasBanca;
//     Scanner sc = new Scanner(System.in);

//     public GameControler() {
//         baraja = new Baraja();
//         baraja.barajar();
//         // se van pidiendo cartas al jugar pero matemáticamente a partir de 15 siempre
//         // nos pasamos
//         // hay 12 cartas de medio puntos, si sacara estas 12 luego cartas con valor 1
//         // vemos que a partir de 15 cartas siempre se pasas
//         cartasJugador = new Carta[15];
//         cartasBanca = new Carta[15];
//         presentarJuego();
//         jugar();
//     }

//     public static void main(String[] args) {
//         new GameControler();
//     }

//     void presentarJuego() {
//         System.out.println("- El usuario es el jugador y el ordenador la  banca.");
//         System.out.println("- No hay en la baraja 8s y 9s. El 10 es la sota, el 11 el caballo y el 12 el Rey.");
//         System.out.println("- las figuras (10-sota, 11-caballo y 12-rey) valen medio punto y, el resto, su valor.");
//         System.out.println(
//                 "- Hay dos turnos de juego: el turno del jugador y el turno de la banca. Se comienza por el turno del jugador.");
//         System.out.println("- El jugador va pidiendo cartas a la banca de una en una.");
//         System.out.println("- El jugador puede plantarse en cualquier momento.");
//         System.out.print("- Si la suma de los valores de las cartas sacadas es superior ");
//         System.out.println("a 7 y medio, el jugador 'se pasa de siete y medio' y  pierde.");
//         System.out.println(
//                 "- Si el jugador no se pasa, comienza a sacar cartas la banca y ésta  está obligada a sacar cartas hasta empatar o superar al jugador.");
//         System.out.println(
//                 "- Si la banca consigue empatar o superar la puntuación del jugador 'sin pasarse de siete y medio', gana la banca.");
//         System.out.println(
//                 "- La banca no se puede plantar y tiene que empatar o superar la puntuación del  jugador sin pasarse.");
//         System.out.println(
//                 "- En este proceso puede ocurrir que la banca 'se pase' y entonces pierde la banca y gana el jugador.");
//         System.out.println("\nEmpecemos!!!\n");
//     }

//     void jugar() {
//         turnoJugador();
//         turnoBanca();
//         System.out.println("Adios");
//     }

//     void turnoJugador() {
//         char opc = 'C';
//         // obligamos a que como mínimo se tenga 1 carta
//         System.out.println("Como mínimo recibes una carta, luego puedes decidir si seguir o plantarte");
//         while (valorCartas(cartasJugador) < 7.5 && opc == 'C') {
//             Carta c = baraja.darCartas(1)[0];
//             // insertamos c en las cartas del jugador
//             insertarCartaEnArray(cartasJugador, c);
//             // mostramos cartas y su valor, si se pasa se sale del bucle
//             System.out.println("Éstas son tus cartas jugador:");
//             mostrarCartas(cartasJugador);
//             double valor = valorCartas(cartasJugador);
//             System.out.println("\n\tValor de cartas: " + valor);
//             if (valor < 7.5) {
//                 // suponemos que el usuario teclea bien !!!
//                 System.out.println("\n¿Pides [C]arta o te [P]lantas?");
//                 opc = sc.next().trim().toUpperCase().charAt(0);
//             }

//         }

//     }

//     void turnoBanca() {
//         // lo primero es consultar el valor que alcanzó el jugador en su turno
//         double valorCartasJugador = valorCartas(cartasJugador);
//         if (valorCartasJugador > 7.5) {
//             System.out.println("Jugador, te has pasado en tu jugada anterior, gana la banca");
//             return;
//         }
//         System.out.println("\n\nTurno de banca ...");

//         // juega hasta empatar o superar
//         while (valorCartas(cartasBanca) < valorCartasJugador) {
//             Carta c = baraja.darCartas(1)[0];
//             insertarCartaEnArray(cartasBanca, c);
//         }
//         System.out.println("Éstas son mis cartas:");
//         mostrarCartas(cartasBanca);
//         System.out.println("\nValor de  mis cartas(banca): " + valorCartas(cartasBanca));
//         if (valorCartas(cartasBanca) > 7.5) {
//             System.out.println("me pasé, ganas tú,jugador");
//         } else {
//             System.out.println("Gana la banca");
//         }
//     }

//     double valorCartas(Carta[] cartas) {
//         double total = 0.0;
//         int val;
//         int i = 0;
//         while (cartas[i] != null) {
//             val = cartas[i].getNumero();
//             total += (val > 7) ? 0.5 : val;
//             i++;
//         }

//         return total;
//     }

//     void insertarCartaEnArray(Carta[] cartas, Carta c) {
//         // inserta al final detectando el primer null
//         int i = 0;
//         while (cartas[i] != null) {
//             i++;
//         }
//         cartas[i] = c;

//     }

//     void mostrarCartas(Carta[] cartas) {
//         int i = 0;
//         while (cartas[i] != null) {
//             System.out.print("\t" + cartas[i]);
//             i++;
//         }
//     }

// }
