package com.company.negocio;

/**
 * @author Cesar Segura Granados
 * 18/04/2018
 * @version 1.0
 */
public interface CatalogoPeliculas {
    void agregarPeliculas(String nombrePelicula, String nombreArchivo);
    void listarPeliculas(String nombreArchivo);
    void buscarPelicula(String nombreArchivo, String buscar);
    void iniciarArchivo(String nombreArchivo);
}
