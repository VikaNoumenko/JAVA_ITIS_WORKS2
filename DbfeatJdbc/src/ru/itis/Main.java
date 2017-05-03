package ru.itis;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        Connection connection = null;

        try {
            // forName - сканирует classpath (путь, где лежат классы, доступные текущей программе)
            // находит класс с названием указанным в методе
            // и загружает его в виртуальную машину
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }

        try {
            connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/itis",
                            "postgres", "postgres");

            Statement statement = connection.createStatement();
            // resultSet - указывает на начало результирующих строк
            // прежде, чем воспользоваться, нужно сдвинуть на начало
            ResultSet resultSet =
                    statement.executeQuery("SELECT * FROM group_user");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
