package com.company.jdbc;

import com.company.dto.PersonaDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cesar Segura Granados
 * 04/06/2018
 * @version 1.0
 */
public class PersonaDaoJdbc implements PersonaDao {

    private Connection connection;
    private final String SQL_INSERT = "INSERT INTO persona (nombre, apellido) VALUES (?,?);";
    private final String SQL_UPDATE = "UPDATE persona SET nombre=?, apellido=? WHERE id_persona=?;";
    private final String SQL_DELETE = "DELETE FROM persona WHERE id_persona=?;";
    private final String SQL_SELECT = "SELECT * FROM persona;";

    public PersonaDaoJdbc() {

    }

    public PersonaDaoJdbc(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insert(PersonaDTO personaDTO)
            throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        int rows = 0;
        try {
            conn = (this.connection != null) ? this.connection : Conexion.getConnection();
            preparedStatement = conn.prepareStatement(SQL_INSERT);
            int index = 1;
            preparedStatement.setString(index++, personaDTO.getNombre());
            preparedStatement.setString(index++, personaDTO.getApellido());
            rows = preparedStatement.executeUpdate();
        } finally {
            Conexion.close(preparedStatement);
            if (connection == null) {
                Conexion.close(conn);
            }
        }
        return rows;
    }

    @Override
    public int update(PersonaDTO personaDTO) throws
            SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rows = 0;
        try {
            connection = (this.connection != null) ? this.connection :
                    Conexion.getConnection();
            System.out.println("Ejecutando query " + SQL_UPDATE);
            preparedStatement = connection.prepareStatement(SQL_UPDATE);
            int index = 1;
            preparedStatement.setString(index++, personaDTO.getNombre());
            preparedStatement.setString(index++, personaDTO.getApellido());
            preparedStatement.setInt(index, personaDTO.getId_persona());
            rows = preparedStatement.executeUpdate();
            System.out.println("Registros actualizados " + rows);
        } finally {
            Conexion.close(preparedStatement);
            if (this.connection == null) {
                Conexion.close(connection);
            }
        }
        return rows;
    }

    @Override
    public int delete(PersonaDTO personaDTO)
            throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rows = 0;
        try {
            connection = (this.connection != null) ? this.connection :
                    Conexion.getConnection();
            System.out.println("Ejecutando query " + SQL_DELETE);
            preparedStatement = connection.prepareStatement(SQL_DELETE);
            preparedStatement.setInt(1, personaDTO.getId_persona());
            rows = preparedStatement.executeUpdate();
            System.out.println("Registros actualizados " + rows);
        } finally {
            Conexion.close(preparedStatement);
            if (this.connection == null) {
                Conexion.close(connection);
            }
        }
        return 0;
    }

    @Override
    public List<PersonaDTO> select()
            throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        PersonaDTO personaDTO = null;
        List<PersonaDTO> personaDTOList = new ArrayList<>();
        try {
            connection = (this.connection != null) ? this.connection :
            Conexion.getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                personaDTO = new PersonaDTO(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3));
                personaDTOList.add(personaDTO);
            }
        } finally {
            Conexion.close(resultSet);
            Conexion.close(preparedStatement);
            if(this.connection == null) {
                Conexion.close(connection);
            }
        }
        return personaDTOList;
    }
}
