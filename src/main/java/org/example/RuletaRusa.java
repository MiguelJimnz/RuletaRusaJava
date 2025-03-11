package org.example;

import java.util.ArrayList;
import java.util.Random;

public class RuletaRusa {
    private ArrayList<String> tambor;
    private int posicionActual;
    private int posicionBala;
    private Random random;

    public RuletaRusa() {
    }

    public RuletaRusa(ArrayList<String> tambor, int posicionActual, int posicionBala, Random random) {

        this.tambor = tambor;
        this.posicionActual = posicionActual;
        this.posicionBala = posicionBala;
        this.random = random;
    }

    public RuletaRusa(ArrayList<String> jugadores) {

        this.tambor = new ArrayList<>(jugadores);
        this.random = new Random();
        this.posicionActual = 0;
        this.posicionBala = random.nextInt(tambor.size());
    }

    public ArrayList<String> getTambor() {
        return tambor;
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public int getPosicionBala() {
        return posicionBala;
    }

    public Random getRandom() {
        return random;
    }

    public void setTambor(ArrayList<String> tambor) {
        this.tambor = tambor;
    }

    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }

    public void setPosicionBala(int posicionBala) {
        this.posicionBala = posicionBala;
    }

    public void setRandom(Random random) {
        this.random = random;
    }


    public boolean disparar() {
        System.out.println("Apuntando a: " + tambor.get(posicionActual));
        if (posicionActual==posicionBala) {
            System.out.println(tambor.get(posicionActual) + " Se ha disparado la bala");
            tambor.remove(posicionActual);

            if(tambor.size()==1){
                System.out.println("El jugador "+ tambor.get(0)+" es el ultimo sobreviviente");

                return true;
            }



            posicionBala = random.nextInt(tambor.size());

            if(posicionActual>=tambor.size()){
                posicionActual=0;
            }
        }else {
            System.out.println("No se dispar[o la bala ");
            avanzarTambor();
        }
        return false;

    }


    private void avanzarTambor() {
        posicionActual = (posicionActual + 1) % tambor.size();
    }

    public void jugar() {
        System.out.println("Inicio del juego de la Ruleta");
        while (tambor.size() > 1) {
            if (disparar()) {
                break;
            }
        }
        System.out.println("El juego ha terminado");
    }
}
