package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String url = "jdbc:mysql://localhost/store2?serverTimezone=Europe/Moscow&useSSL=false";
    private static final String username = "root";
    private static final String password = "password";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e){
            System.out.println("Connection failed ...");
        }
        return connection;
    }
}
