package com.company.excepciones;

/**
 * @author Cesar Segura Granados
 * 18/04/2018
 * @version 1.0
 */
public class AccesoDatosEx extends Exception {
    String mensaje;

    public AccesoDatosEx(String mensaje) {
        this.mensaje = mensaje;
    }
}
