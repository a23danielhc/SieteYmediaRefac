package sieteymedia;

import recursos.Baraja;
import recursos.Carta;

public class SieteYMedia {

    private Baraja baraja;
    Carta[] cartasJugador;
    Carta[] cartasBanca;

    SieteYMedia(){
        this.baraja = new Baraja();
        this.baraja.barajar();
        this.cartasJugador = new Carta[15];
        this.cartasBanca = new Carta[15];
    }

    double valorCartas(Carta[] cartas) {
        double total = 0.0;
        int val;
        int i = 0;
        while (cartas[i] != null) {
            val = cartas[i].getNumero();
            total += (val > 7) ? 0.5 : val;
            i++;
        }

        return total;
    }

    void insertarCartaEnArray(Carta[] cartas, Carta c) {
        // inserta al final detectando el primer null
        int i = 0;
        while (cartas[i] != null) {
            i++;
        }
        cartas[i] = c;

    }

    Carta[] getCartas(Boolean jugador){
        if (jugador){
            return this.cartasJugador;
        }
        else {
            return this.cartasBanca;
        }
    }

    boolean comprobarSiSePasa(boolean jugador){
        if (this.valorCartas(this.getCartas(jugador)) < 7.5){
            return true;
        } else {
            return false;
        }
    }

    Carta getCarta(){
        return this.baraja.darCartas(1)[0];
    }

}