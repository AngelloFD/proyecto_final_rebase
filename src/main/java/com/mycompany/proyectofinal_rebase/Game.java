package com.mycompany.proyectofinal_rebase;

import java.util.Random;
import java.util.Scanner;

public class Game {

    // Constructores auxiliares
    Scanner scan = new Scanner(System.in);

    // Atributos
    public char[] letras = { 'A', 'B', 'C', 'D', 'E' };
    public char[] numeros = { '1', '2', '3', '4', '5' };
    String Cod = "";

    // Constructor

    // Métodos del juego
    public String gen_cod() {
        int radix = 10;
        for (int i = 0; i < 25; i++) {
            int n = new Random().nextInt(2);
            this.Cod += Character.forDigit(n, radix);
        }

        return Cod;
    }

    public String setCod() {
        return this.Cod = "";
    }

    public boolean validar(String rpta) {
        rpta = rpta.toUpperCase();
        boolean vera = false;

        for (int i = 0; i < this.letras.length; i++) {
            if (rpta.charAt(0) == this.letras[i]) {
                vera = true;
                break;
            } else {
                vera = false;
            }
        }

        if (vera) {
            for (int j = 0; j < this.letras.length; j++) {
                if (rpta.charAt(1) == this.numeros[j]) {
                    vera = true;
                    break;
                } else {
                    vera = false;
                }
            }
        }
        return vera;
    }

}
