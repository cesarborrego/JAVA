package com.company.datos;

import com.company.domain.Pelicula;
import com.company.excepciones.AccesoDatosEx;
import com.company.excepciones.EscrituraDatosEx;
import com.company.excepciones.LecturaDatosEx;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cesar Segura Granados
 * 18/04/2018
 * @version 1.0
 */
public class AccesoDatosImpl implements AccesoDatos {

    @Override
    public boolean isExiste(String nombreArchivo) throws AccesoDatosEx {
        File file = new File(nombreArchivo);
        return file.exists();
    }

    @Override
    public List<Pelicula> listar(String nombrePelicula) throws LecturaDatosEx {
        File file = new File(nombrePelicula);
        List<Pelicula> peliculaList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String linea = null;
            linea = bufferedReader.readLine();
            while (linea != null){
                Pelicula pelicula = new Pelicula(linea);
                peliculaList.add(pelicula);
                linea = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return peliculaList;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        File file = new File(nombreArchivo);
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(file), anexar);
            printWriter.println(pelicula.toString());
            printWriter.close();
            System.out.println("Se ha escrito correctamente el archivo");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar)throws LecturaDatosEx {
        File file = new File(nombreArchivo);
        String resultado = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String linea = null;
            linea = bufferedReader.readLine();
            int i = 0;
            while (linea != null){
                if (buscar !=null && buscar.equalsIgnoreCase(linea)) {
                    resultado = "Pelicula " + linea + "en indice " + i;
                    break;
                }
                linea = bufferedReader.readLine();
                i++;
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public void crear(String nombreArchivo)throws AccesoDatosEx {
        File file = new File(nombreArchivo);
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(file));
            printWriter.close();
            System.out.println("Se ha creado el archivo correctamente");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        archivo.delete();
        System.out.println("Se ha borrado el archivo correctamente");
    }
}
