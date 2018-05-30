package com.company.datos;

import java.sql.*;

/**
 * @author Cesar Segura Granados
 * 25/05/2018
 * @version 1.0
 */
public class Conexion {
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/sga?useSSL=false";
    private static String USER = "root";
    private static String PASS = "admin";
    private static Driver driver = null;

    public static synchronized Connection getConnection()
            throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (driver == null) {
            Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
            driver = (Driver) jdbcDriverClass.newInstance();
            DriverManager.registerDriver(driver);
        }
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static void close(ResultSet resultSet) {
        try {
            if(resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(PreparedStatement preparedStatement) {
        try {
            if(preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  static void close(Connection connection) {
        try {
            if(connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
