package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        ManejoPersonas.select();
    }

    private void pruebaConexion() {
        String url = "jdbc:mysql://localhost:3306/sga?useSSL=false";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = (Connection) DriverManager.getConnection(url, "root", "admin");
            Statement statement = connection.createStatement();
            String sql = "Select * from persona";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println("Id " + resultSet.getInt(1));
                System.out.println("Nombre " + resultSet.getString(2));
                System.out.println("Apellido " + resultSet.getString(3));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
