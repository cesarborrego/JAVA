package com.company.domain;

/**
 * Creado por
 *
 * @author Cesar Segura Granados
 * 18/04/2018
 * @version 1.0
 */
public class Pelicula {
    private String nombre;

    public Pelicula(){

    }

    public Pelicula(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
