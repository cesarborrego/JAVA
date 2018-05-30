package com.company.datos;

import com.company.domain.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cesar Segura Granados
 * 25/05/2018
 * @version 1.0
 */
public class PersonaJDBC {
    //Create
    private final String SQL_INSERT = "INSERT INTO persona(nombre, apellido) VALUES (?,?)";
    //Read
    private final String SQL_SELECT = "SELECT * FROM persona";
    //Update
    private final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ? WHERE id_persona = ?";
    //Delete
    private final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";

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

    public List<Persona> select() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();
        try {
            connection = Conexion.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id_persona = resultSet.getInt(1);
                String nombre = resultSet.getString(2);
                String apellido = resultSet.getString(3);
                persona = new Persona();
                persona.setId_persona(id_persona);
                persona.setNombre(nombre);
                persona.setApellido(apellido);
                personas.add(persona);
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
