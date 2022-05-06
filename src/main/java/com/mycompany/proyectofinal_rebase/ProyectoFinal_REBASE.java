package com.mycompany.proyectofinal_rebase;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class ProyectoFinal_REBASE {

    // Constructores auxiliares
    Random random = new Random();
    Scanner scan = new Scanner(System.in);

    Game game = new Game();
    String probGened = game.gen_cod();

    ArrayList<String> cambio = new ArrayList<>();

    static void pause(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
        }
    }

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

            pause(2);
        }
        System.out.println("Listo?");
        pause(3);
    }

    public void menu() {
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
    }

    public void generar_array() {
        System.out.println("-_-_-_-_-_-_-_JUEGO DE ORDEN_-_-_-_-_-_-_-_-_-");
        System.out.println("     1  2  3  4  5");
        for (int x = 0; x < 5; x++) {
            System.out.print(game.letras[x] + " - ");
            for (int y = 0; y < 5; y++) {
                System.out.print(" " + probGened.charAt((x * 5 + y)) + " ");
            }
            System.out.println();
            // Fin generacion
        }
        System.out.println(" > Ingresa tu RPTA, primero LETRA Y NUMERO\n");
    }

    public void run(String[] args) throws Exception {
        // Aquí sólo ejecutaremos el juego y llamaremos a los objetos
        while (true) {
            menu();

            // Limpia la consola
            System.out.print("\033[H\033[2J");
            System.out.flush();
            //

            // Set Up
            generar_array();
            String rpta = scan.next();
            rpta = rpta.toUpperCase();

            if ("RESET".equals(rpta)) {
                System.out.println("R E I N I C I A N D O...");
                pause(2);
                game.setCod();
                probGened = game.gen_cod();
                generar_array();
                continue;
            } // Fin reset

            // Volver a generar Cod

            while (!(game.validar(rpta))) {
                pause(1);

                System.out.println("- Tu respuesta es invalida -");
                System.out.println("----------------------------");
                System.out.println(" > Ingresa tu RPTA, primero LETRA Y NUMERO\n");
                rpta = scan.next();
                rpta = rpta.toUpperCase();
            }

            // Procesamiento de respuesta
            System.out.println(" P R O C E S A N D O . . . ");
            pause(2);

            cambio.clear();

            if (rpta.charAt(0) == game.letras[0]) {
                cambio.add("1"); // A
            } else if (rpta.charAt(0) == game.letras[1]) {
                cambio.add("2"); // B
            } else if (rpta.charAt(0) == game.letras[2]) {
                cambio.add("3"); // C
            } else if (rpta.charAt(0) == game.letras[3]) {
                cambio.add("4"); // D
            } else if (rpta.charAt(0) == game.letras[4]) {
                cambio.add("5"); // E
            }

            cambio.add(String.valueOf(rpta.charAt(1)));

            // Definir punto clave
            int k = (Integer.parseInt(cambio.get(0)) * 5) - (5 - Integer.parseInt(cambio.get(1))) - 1;

            // Definir la lista cambio a partir del punto clave
            cambio.clear();
            cambio.add(String.valueOf(k));
            if (!(k % 5 == 0)) {
                cambio.add(String.valueOf(k - 1));
            }
            if (k != 4 && k != 9 && k != 14 && k != 19 && k != 24) {
                cambio.add(String.valueOf(k + 1));
            }
            cambio.add(String.valueOf(k + 5));
            cambio.add(String.valueOf(k - 5));

            // Trabajar lista de cambio
            for (int i = 0; i < cambio.size(); i++) {
                int n = Integer.parseInt(cambio.get(i));
                if (n >= 0 && n <= 24) {
                    if (probGened.charAt(n) == '1') {
                        probGened = probGened.substring(0, n) + "0" + probGened.substring(n + 1);
                    } else {
                        probGened = probGened.substring(0, n) + "1" + probGened.substring(n + 1);
                    }
                }
            }

            int ValP = 1;
            // Para cada letra en probGened
            for (int x = 0; x < probGened.length(); x++) {
                ValP *= Integer.parseInt(String.valueOf(probGened.charAt(x)));
            }
            if (ValP == 1) {
                break;
            } // Fin validar final del juego
        } // Fin del while true

        // Limpieza de consola
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("-_-_-_-_-_-_ FELICIDADES _-_-_-_-_-_-");
        System.out.println("\n");

        // generar Cod
        probGened = game.gen_cod();
        System.out.println("     1  2  3  4  5");
        for (int x = 0; x < 5; x++) {
            System.out.print(game.letras[x] + " - ");
            for (int y = 0; y < 5; y++) {
                System.out.print(" " + probGened.charAt((x * 5 + y)) + " ");
            }
            System.out.println();
        }
    }// Fin generacion

    public static void main(String[] args) {
        try {
            ProyectoFinal_REBASE obj = new ProyectoFinal_REBASE();
            obj.run(args);
        } catch (Exception e) {
        }
    }

}
