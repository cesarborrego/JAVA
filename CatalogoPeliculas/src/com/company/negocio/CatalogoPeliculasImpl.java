package com.company.negocio;

import com.company.datos.AccesoDatos;
import com.company.datos.AccesoDatosImpl;
import com.company.domain.Pelicula;
import com.company.excepciones.AccesoDatosEx;
import com.company.excepciones.LecturaDatosEx;

import java.util.List;

/**
 * @author Cesar Segura Granados
 * 18/04/2018
 * @version 1.0
 */
public class CatalogoPeliculasImpl implements CatalogoPeliculas {
    AccesoDatos accesoDatos;

    public CatalogoPeliculasImpl() {
        this.accesoDatos = new AccesoDatosImpl();
    }

    @Override
    public void agregarPeliculas(String nombrePelicula, String nombreArchivo) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = accesoDatos.isExiste(nombreArchivo);
            accesoDatos.escribir(pelicula, nombreArchivo, anexar);
        } catch (AccesoDatosEx accesoDatosEx) {
            System.out.println("Error de acceso a datos");
            accesoDatosEx.printStackTrace();
        }
    }

    @Override
    public void listarPeliculas(String nombreArchivo) {
        try {
            List<Pelicula> peliculaList = accesoDatos.listar(nombreArchivo);
            for (Pelicula pelicula : peliculaList) {
                System.out.println("Pelicula " + pelicula);
            }
        } catch (LecturaDatosEx lecturaDatosEx) {
            System.out.println("Error de lectura de datos");
            lecturaDatosEx.printStackTrace();
        }
    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) {
        String resultado = null;
        try {
            resultado = accesoDatos.buscar(nombreArchivo, buscar);
        } catch (LecturaDatosEx lecturaDatosEx) {
            System.out.println("Error de acceso a datos");
            lecturaDatosEx.printStackTrace();
        }
        System.out.println("Resultado de búsqueda " + resultado);
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
        try {
            if (accesoDatos.isExiste(nombreArchivo)) {
                accesoDatos.borrar(nombreArchivo);
                accesoDatos.crear(nombreArchivo);
            } else {
                accesoDatos.crear(nombreArchivo);
            }
        } catch (AccesoDatosEx accesoDatosEx) {
            accesoDatosEx.printStackTrace();
            System.out.println("Error de acceso a datos");
        }
    }
}
