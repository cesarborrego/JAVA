package com.company.datos;

import com.company.domain.Pelicula;
import com.company.excepciones.AccesoDatosEx;
import com.company.excepciones.EscrituraDatosEx;
import com.company.excepciones.LecturaDatosEx;

import java.util.List;

/**
 * @author Cesar Segura Granados
 * 18/04/2018
 * @version 1.0
 */
public interface AccesoDatos {
    boolean isExiste(String nombreArchivo) throws AccesoDatosEx;
    List<Pelicula> listar(String nombrePelicula) throws LecturaDatosEx;
    void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;
    String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;
    void crear(String nombreArchivo) throws AccesoDatosEx;
    void borrar(String nombreArchivo) throws AccesoDatosEx;
}
