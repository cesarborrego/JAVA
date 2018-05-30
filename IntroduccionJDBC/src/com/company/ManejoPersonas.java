package com.company;

import com.company.datos.PersonaJDBC;
import com.company.domain.Persona;

import java.util.List;

/**
 * @author Cesar Segura Granados
 * 25/05/2018
 * @version 1.0
 */
public class ManejoPersonas {

    static PersonaJDBC personaJDBC = new PersonaJDBC();

    public static void insert() {
        personaJDBC.insert("Cesar", "Segura");
    }

    public static void update() {
        personaJDBC.update(2,"Patsy", "Brenda");
    }

    public static void delete() {
        personaJDBC.delete(1);
    }

    public static void select() {
        List<Persona> personas = personaJDBC.select();
        for (Persona persona :
                personas) {
            System.out.println(persona);
        }
    }
}
