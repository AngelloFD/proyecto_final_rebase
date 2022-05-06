package com.mycompany.proyectofinal_rebase;

import java.util.Random;

public class Game {

    // Atributos
    public final char[] letras = { 'A', 'B', 'C', 'D', 'E' };
    public final char[] numeros = { '1', '2', '3', '4', '5' };
    String Cod = "";

    // Constructores auxiliares
    StringBuilder strBuilder = new StringBuilder(Cod);

    // Métodos del juego
    public String gen_cod() {
        int radix = 10;
        for (int i = 0; i < 25; i++) {
            int n = new Random().nextInt(2);
            strBuilder.append(n);
        }

        return Cod = strBuilder.toString();
    }

    public boolean validar(String rpta) {
        rpta = rpta.toUpperCase();
        boolean vera = false;

        for (char letra : this.letras) {
            if (rpta.charAt(0) == letra) {
                vera = true;
                break;
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
