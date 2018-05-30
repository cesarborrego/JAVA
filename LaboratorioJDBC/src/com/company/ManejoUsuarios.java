package com.company;

import com.company.datos.UsuarioJDBC;
import com.company.domain.Usuario;

import java.util.List;


/**
 * @author Cesar Segura Granados
 * 30/05/2018
 * @version 1.0
 */
public class ManejoUsuarios {
    static UsuarioJDBC usuarioJDBC = new UsuarioJDBC();

    public static void insert() {
        usuarioJDBC.insert("Cesar", "Segura");
    }

    public static void delete() {
        usuarioJDBC.delete(2);
    }

    public static void update() {
        usuarioJDBC.update(1, "Patsy", "Alcántara");
    }

    public static void select() {
        List<Usuario> usuarioList = usuarioJDBC.select();
        for (Usuario usuario: usuarioList) {
            System.out.println(usuario);
        }
    }
}
