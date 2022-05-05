package com.mycompany.proyectofinal_rebase;

import java.util.Random;
import java.util.Scanner;

public class Game {

    // Constructores auxiliares
    Scanner scan = new Scanner(System.in);

    // Atributos
    public char[] letras = {'A', 'B', 'C', 'D', 'E'};
    public char[] numeros = {'1', '2', '3', '4', '5'};
    String Cod = "";

    // Constructor
    
    // Métodos del juego
    public String gen_cod(int num) {
        if (num == 1){
            String temp = "";
            for (int i = 0; i < 25; i++) {
                int n = new Random().nextInt(2);
                temp += (char)n;
            }
            this.Cod = temp;
        } else if (num == 2) {
            String temp = "";
            for (int i = 0; i < 25; i++) {
                int n = new Random().nextInt(2);
                temp += (char)n;
            }
            this.Cod = temp;
        } else if (num == 3) {
           String temp = "";
            for (int i = 0; i < 25; i++) {
                int n = new Random().nextInt(2);
                temp += (char)n;
            }
            this.Cod = temp;
        } else if (num == 4) {
            String temp = "";
            for (int i = 0; i < 25; i++) {
                int n = new Random().nextInt(2);
                temp += (char)n;
            }
            this.Cod = temp;
        } else if (num == 5) {
            String temp = "";
            for (int i = 0; i < 25; i++) {
                int n = new Random().nextInt(2);
                temp += (char)n;
            }
            this.Cod = temp;
        }
        return Cod;
    }

    public boolean validar(String rpta) {
        rpta = rpta.toUpperCase();
        boolean vera = false;

        for (int i = 0; i < this.letras.length; i++) {
            if (rpta.charAt(0) == this.letras[i]) {
                vera = true;
            }
        }

        if (vera) {
            for (int j = 0; j < this.letras.length; j++) {
                if (!(rpta.charAt(0) == this.numeros[j])) {
                    vera = false;
                }
            }
        }
        return vera;
    }
    
}
