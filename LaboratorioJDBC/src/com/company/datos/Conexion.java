package com.company.datos;

import java.sql.*;

/**
 * @author Cesar Segura Granados
 * 30/05/2018
 * @version 1.0
 */
public class Conexion {
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static String JDBC_URL = "jdbc:mysql://localhost:3306/sga?useSSL=false";
    private static String JDBC_USER = "root";
    private static String JDBC_PASSWORD = "admin";
    private static Driver driver = null;

    public static synchronized Connection getConnection()
            throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (driver == null) {
            Class jdbcDriver = Class.forName(JDBC_DRIVER);
            driver = (Driver) jdbcDriver.newInstance();
            DriverManager.registerDriver(driver);
        }
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

    }

    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
