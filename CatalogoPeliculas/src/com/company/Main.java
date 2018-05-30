package com.company;

import com.company.negocio.CatalogoPeliculas;
import com.company.negocio.CatalogoPeliculasImpl;

import java.util.Scanner;

public class Main {

    private static int opcion = -1;
    private static final String nombreArchivo = "D:\\IntelliProjects\\catalogo_peliculas.txt";
    private static final Scanner scanner = new Scanner(System.in);
    private static final CatalogoPeliculas catalogoPeliculas = new CatalogoPeliculasImpl();

    public static void main(String[] args) {
        //initMenu();
        pruebaString();
    }

    private static void initMenu() {
        while (opcion != 0) {
            System.out.println("Elige opcion:\n1.- Iniciar catalogo peliculas"
                    + "\n2.- Agregar pelicula\n"
                    + "3.- Listar Peliculas\n"
                    + "4.- Buscar Pelicula\n"
                    + "0.- Salir");
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 1:
                    catalogoPeliculas.iniciarArchivo(nombreArchivo);
                    break;
                case 2:
                    System.out.println("Introduce el nombre de una pelicula a agregar:");
                    String nombre = scanner.nextLine();
                    catalogoPeliculas.agregarPeliculas(nombre, nombreArchivo);
                    break;
                case 3:
                    catalogoPeliculas.listarPeliculas(nombreArchivo);
                    break;
                case 4:
                    System.out.println("Introduce el nombre de una pelicula a buscar:");
                    String buscar = scanner.nextLine();
                    catalogoPeliculas.buscarPelicula(nombreArchivo, buscar);
                case 0:
                    System.out.println("!Hasta pronto!");
                    break;
                default:
                    System.out.println("Opcion no reconocida");
                    break;
            }
            System.out.println("\n");
        }
    }

    private static void pruebaString() {
        String s1 = "1001";
        Integer i = Integer.parseInt(s1);
        System.out.println(s1.equals(i));
    }
}
