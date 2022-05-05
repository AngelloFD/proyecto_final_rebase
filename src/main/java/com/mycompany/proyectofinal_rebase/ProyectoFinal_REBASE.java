package com.mycompany.proyectofinal_rebase;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class ProyectoFinal_REBASE {

    // Constructores auxiliares
    Random random = new Random();
    Scanner scan = new Scanner(System.in);

    Game game = new Game();

    ArrayList<String> probL = new ArrayList<>();

    static void tutorial() {
        for (int i = 0; i < 4; i++) {
            // Limpia la consola
            System.out.print("\033[H\033[2J");
            System.out.flush();

            if (i % 2 == 0) {
                System.out.println("-_-_-_-_-_-_-_JUEGO DE ORDEN_-_-_-_-_-_-_-_-_-");
                System.out.println("En el juego de orden tienes");
                System.out.print("que conseguir que todos los");
                System.out.println("        1 2 3");
                System.out.print("los numeros en la caja sean");
                System.out.println("      A 1 1 1");
                System.out.print("1, indicando el punto segun");
                System.out.println("      B 1 1 1");
                System.out.print("la FILA y COLUMNA, como el");
                System.out.println("       C 1 1 1");
                System.out.print("ejemplo de la derecha");
                System.out.println("             -B2-");
            } else {
                System.out.println("-_-_-_-_-_-_-_JUEGO DE ORDEN_-_-_-_-_-_-_-_-_-");
                System.out.println("En el juego de orden tienes");
                System.out.print("que conseguir que todos los");
                System.out.println("        1 2 3");
                System.out.print("los numeros en la caja sean");
                System.out.println("      A 1 0 1");
                System.out.print("1, indicando el punto segun");
                System.out.println("      B 0 0 0");
                System.out.print("la FILA y COLUMNA, como el");
                System.out.println("       C 1 0 1");
                System.out.print("ejemplo de la derecha");
                System.out.println("             -B2-");
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Listo?");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
    }

    public void run(String[] args) throws Exception {
        // Aquí sólo ejecutaremos el juego y llamaremos a los objetos
        while (true) {
            // Menu
            System.out.println("-_-_-_-_-_-_-_JUEGO DE ORDEN_-_-_-_-_-_-_-_-_-");
            System.out.println("  Ingresa cualquier tecla para empezar...");
            System.out.println("\n");
            System.out.println("               O ingrese X para ir al tutorial");
            System.out.println("\n");
            var ini = scan.nextLine();
            ini = ini.toUpperCase();
            if ("X".equals(ini)) {
                tutorial();
            }
            System.out.println("\n\n\n\n");
            //

            // Logica del juego
            String probGened = game.gen_cod();

            System.out.println("    1  2  3  4  5");
            for (int x = 0; x < 5; x++) {
                System.out.print(game.letras[x] + " - ");
                for (int y = 0; y < 5; y++) {
                    System.out.print(probGened.charAt((x * 5 + y)) + " ");
                }
                System.out.println();
            }

            System.out.println(" > Ingresa tu RPTA, primero LETRA Y NUMERO\n");
        }

    }

    public static void main(String[] args) {
        try {
            ProyectoFinal_REBASE obj = new ProyectoFinal_REBASE();
            obj.run(args);
        } catch (Exception e) {
        }
    }

}
