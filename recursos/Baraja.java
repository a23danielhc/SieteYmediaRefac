package recursos;

import java.util.Random;

public class Baraja {

    //baraja española de 40 cartas. No hay 8 y 9.
    private final int NUM_CARTAS = 40;
    private Carta[] cartas = new Carta[NUM_CARTAS];
    int primeraMazo;//el indice de la primera carta sin dar. A las cartas sin dar le llamo mazo.

   public Baraja() {
        //crea una baraja ordenada por palos y números
        int ultimaCarta=0;
        for (Palo p:Palo.values()) {
            for (int j = 0; j < 12; j++) {
                if((j==7 || j==8)){
                    continue;
                }
                cartas[ultimaCarta] = new Carta(p,j+1);
                ultimaCarta++;
            }
        }
    }

  
    public void barajar() {
        //baraja el mazo, es decir, la cartas sin dar
        Random r = new Random();
        for (int i = primeraMazo; i < cartas.length; i++) {
            int posicionAzar = r.nextInt(cartas.length-primeraMazo)+primeraMazo;
            Carta temp = cartas[i];
            cartas[i] = cartas[posicionAzar];
            cartas[posicionAzar] = temp;
        }

    }


   

    public Carta[] darCartas(int numCartasDar) {
        //coge cartas del mazo para dar 
        //si no hay suficientes cartas o el mazo está vacío se devuelve array vacio
        Carta[] cartasParaDar;
        
        int cartasEnMazo = cartas.length - primeraMazo;

        if (cartasEnMazo < numCartasDar) {
            cartasParaDar = new Carta[0];
        } else {
            cartasParaDar = new Carta[numCartasDar];
            int i = 0;
            for (; i < cartasParaDar.length; i++) {
                cartasParaDar[i] = cartas[i + primeraMazo];
            }
            primeraMazo = i + primeraMazo;
        }
        return cartasParaDar;
    }
}
