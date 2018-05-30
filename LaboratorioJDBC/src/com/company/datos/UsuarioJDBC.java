package com.company.datos;

import com.company.domain.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cesar Segura Granados
 * 30/05/2018
 * @version 1.0
 */
public class UsuarioJDBC {
    //Create
    private final String SQL_INSERT = "INSERT INTO usuario(usuario, password) VALUES (?,?)";
    //Read
    private final String SQL_SELECT = "SELECT * FROM usuario";
    //Update
    private final String SQL_UPDATE = "UPDATE usuario SET usuario = ?, password = ? WHERE id_usuario = ?";
    //Delete
    private final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario = ?";

    public int insert(String nombre, String apellido) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int rows = 0; //registros afectados
        try {
            connection = Conexion.getConnection();
            preparedStatement = connection.prepareStatement(SQL_INSERT);
            int index = 1; //contador de columnas

            preparedStatement.setString(index++, nombre);
            preparedStatement.setString(index++, apellido);
            System.out.println("Ejecutando query " + SQL_INSERT);
            rows = preparedStatement.executeUpdate();
            System.out.println("Registros afectados " + rows);
        } catch (IllegalAccessException | ClassNotFoundException | SQLException | InstantiationException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(connection);
            Conexion.close(preparedStatement);
        }
        return rows;
    }

    public int update(int id_persona, String nombre, String apellido) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int rows = 0; //registros afectados
        try {
            connection = Conexion.getConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE);
            int index = 1; //contador de columnas
            preparedStatement.setString(index++, nombre);
            preparedStatement.setString(index++, apellido);
            preparedStatement.setInt(index, id_persona);
            System.out.println("Ejecutando query " + SQL_UPDATE);
            rows = preparedStatement.executeUpdate();
            System.out.println("Registros actualizados " + rows);
        } catch (IllegalAccessException | ClassNotFoundException | SQLException | InstantiationException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(connection);
            Conexion.close(preparedStatement);
        }
        return rows;
    }

    public int delete(int id_persona) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rows = 0;
        try {
            connection = Conexion.getConnection();
            System.out.println("Ejecutando query " + SQL_DELETE);
            preparedStatement = connection.prepareStatement(SQL_DELETE);
            preparedStatement.setInt(1, id_persona);
            rows = preparedStatement.executeUpdate();
            System.out.println("Registros eliminados " + rows);
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(preparedStatement);
            Conexion.close(connection);
        }
        return rows;
    }

    public List<Usuario> select() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Usuario usuario = null;
        List<Usuario> personas = new ArrayList<>();
        try {
            connection = Conexion.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id_usuario = resultSet.getInt(1);
                String user = resultSet.getString(2);
                String password = resultSet.getString(3);
                usuario = new Usuario(id_usuario,
                        user,
                        password);
                personas.add(usuario);
            }
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(resultSet);
            Conexion.close(preparedStatement);
            Conexion.close(connection);
        }
        return personas;
    }

}
