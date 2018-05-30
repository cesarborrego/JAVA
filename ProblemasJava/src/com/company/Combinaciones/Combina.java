package com.company.Combinaciones;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cesar Segura Granados
 * 18/05/2018
 * @version 1.0
 */
public class Combina {
    static List<Double> list = new ArrayList<>();

    public static void Perm2(String[] elem, String act, int n, int r) {
        if (n == 0) {
            System.out.println(act);
            String [] pts = act.split(",");
            list.add(calcularDistancia(Integer.parseInt(pts[0]),
                    Integer.parseInt(pts[1]),
                    Integer.parseInt(pts[2]),
                    Integer.parseInt(pts[3])));
        } else {
            for (int i = 0; i < r; i++) {
                if (!act.contains(elem[i])) { // Controla que no haya repeticiones
                    Perm2(elem, act + elem[i] + "," , n - 1, r);
                }
            }
        }
    }

    private static double calcularDistancia(int x1, int y1, int x2, int y2) {
        int [] p1 = {x2 , x1};
        int [] p2 = {y2 , y1};
        int x = p1[0]-p1[1];
        int y = p2[0]-p2[1];
        double result = (Math.pow(x,2)) + (Math.pow(y,2));
        System.out.println("Distancia " + Math.sqrt(result) +"\n");
        return Math.sqrt(result);
    }

    public static void obtieneMaximo() {
        double maximo = list.get(0); // Declaramos e inicializamos el máximo.
        double minimo = list.get(0); // Declaramos e inicializamos el máximo.

        for (int i = 0; i < list.size(); i++){
            if (maximo < list.get(i)) {
                maximo = list.get(i);
            }
            if (minimo > list.get(i)) {
                minimo = list.get(i);
            }
        }

        // Al finalizar el bucle, las variables contienen los valores máximos y mínimos.
        System.out.println("El valor máximo de la lista es " + maximo);
        System.out.println("El valor mínimo de la lista es " + minimo);
    }
}
