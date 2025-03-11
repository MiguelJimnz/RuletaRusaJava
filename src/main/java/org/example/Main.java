package org.example;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        while (true) {
            ArrayList<String> jugadores = new ArrayList<>();

            int numJugadores;


            do {
                System.out.println("Ingrese el número de jugadores, maximo 6 :");
                numJugadores = scanner.nextInt();
                scanner.nextLine();

                if (numJugadores < 1 || numJugadores > 6) {
                    System.out.println("Número inválido. Debe ser entre 1 y 6.");
                }
            } while (numJugadores < 1 || numJugadores > 6);

            for (int i = 1; i <= numJugadores; i++) {
                System.out.println("Ingrese el nombre del jugador " + i + ":");
                jugadores.add(scanner.nextLine());
            }

            RuletaRusa juego = new RuletaRusa(jugadores);
            juego.jugar();





            System.out.println("¿Desea jugar otra vez? (si/no): ");
            String respuesta = scanner.nextLine().toLowerCase();
            if (!respuesta.equals("si")) {
                System.out.println("Gracias por jugar. ¡Hasta la próxima!");
                break;
            }
        }
    }

}