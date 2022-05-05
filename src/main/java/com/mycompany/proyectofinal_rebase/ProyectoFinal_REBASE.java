package com.mycompany.proyectofinal_rebase;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class ProyectoFinal_REBASE {

    // Constructores auxiliares
    Random random = new Random();
    Scanner scan = new Scanner(System.in);

    Game game = new Game();
    String rpta;
    String probGened = game.gen_cod();

    ArrayList<String> cambio = new ArrayList<>();
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
            // Fin menu

            // Limpia la consola
            System.out.print("\033[H\033[2J");
            System.out.flush();
            //

            // Logica del juego
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
            String rpta = scan.next();
            rpta = rpta.toUpperCase();

            if ("RESET".equals(rpta)) {
                System.out.println("R E I N I C I A N D O...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
                continue;
            } // Fin reset

            // Volver a generar Cod
            game.setCod();
            probGened = game.gen_cod();
            System.out.println("     1  2  3  4  5");
            for (int x = 0; x < 5; x++) {
                System.out.print(game.letras[x] + " - ");
                for (int y = 0; y < 5; y++) {
                    System.out.print(" " + probGened.charAt((x * 5 + y)) + " ");
                }
            }

            while (true) {
                if (game.validar(rpta)) {
                    break;
                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }

                    System.out.println("- Tu respuesta es invalida -");
                    System.out.println("----------------------------");
                    System.out.println(" > Ingresa tu RPTA, primero LETRA Y NUMERO\n");
                    rpta = scan.next();
                }
            } // Fin de validacion

            // Procesamiento de respuesta
            System.out.println(" P R O C E S A N D O . . . ");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }

            // A
            if (rpta.charAt(0) == game.letras[0]) {
                cambio.add("1");

                // B
            } else if (rpta.charAt(0) == game.letras[1]) {
                cambio.add("2");

                // C
            } else if (rpta.charAt(0) == game.letras[2]) {
                cambio.add("3");

                // D
            } else if (rpta.charAt(0) == game.letras[3]) {
                cambio.add("4");
            } else if (rpta.charAt(0) == game.letras[4]) {
                cambio.add("5");

                // E
            }

            cambio.add(String.valueOf(rpta.charAt(1)));

            // Definir punto clave
            int k = (Integer.parseInt(cambio.get(0)) * 5) - (5 - (Integer.parseInt(cambio.get(1)))) - 1;

            // Definir la lista cambio a partir del punto clave
            cambio.clear();
            cambio.add(String.valueOf(k));

            if (!(k % 5 == 0)) {
                cambio.add(String.valueOf(k + 1));
            }
            if (k != 4 && k != 9 && k != 14 && k != 19 && k != 24) {
                cambio.add(String.valueOf(k + 1));
            }
            cambio.add(String.valueOf(k + 5));
            cambio.add(String.valueOf(k - 5));

            // Trabajar lista de cambio
            for (String n : cambio) {
                int nint = Integer.parseInt(n);
                if (nint >= 0 && nint <= 24) {
                    if (probGened.charAt(nint) == '1') {
                        // change the char at the nint position to 0
                        probGened = probGened.substring(0, nint) + "0" + probGened.substring(nint + 1);
                    } else {
                        // change the char at the nint position to 1
                        probGened = probGened.substring(0, nint) + "1" + probGened.substring(nint + 1);
                    }
                }
            } // Fin de trabajar la lista

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
