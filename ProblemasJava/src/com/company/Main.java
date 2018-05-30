package com.company;

import com.company.Combinaciones.Combina;

public class Main {

    public static void main(String[] args) {
        //permutaciones(3,2,5,6);
        pruebaFor();
    }

    private static void permutaciones(int a, int b, int c, int d) {
        String[] elementos = {String.valueOf(a),
                String.valueOf(b),
                String.valueOf(c),
                String.valueOf(d)};
        int n = 4;                  //Tipos para escoger
        int r = elementos.length;   //Elementos elegidos
        Combina.Perm2(elementos, "", n, r);
        Combina.obtieneMaximo();
    }

    private static void pruebaFor() {
        for(;;) {
            System.out.println("Foo");
        }
    }
}
