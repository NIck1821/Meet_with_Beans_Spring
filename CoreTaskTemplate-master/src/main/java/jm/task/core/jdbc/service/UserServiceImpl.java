package jm.task.core.jdbc.service;


import jm.task.core.jdbc.model.User;


import java.sql.*;
import java.util.*;

public class UserServiceImpl implements UserService {
    private static final String url = "jdbc:mysql://localhost/store2?serverTimezone=Europe/Moscow&useSSL=false";
    private static final String username = "root";
    private static final String password = "password";

    public void createUsersTable() {
        try {
            String sqlCommand = "CREATE TABLE Users (Id INT PRIMARY KEY AUTO_INCREMENT, Name VARCHAR(20), LastName VARCHAR(20), Age TINYINT)";
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                try {
                    Statement statement = conn.createStatement();
                    statement.executeUpdate(sqlCommand);
                } catch (Exception e) {
                }
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
    }

    public void dropUsersTable() {
        try {
            String sqlCommand = "DROP TABLE Users";
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                try {
                    Statement statement = conn.createStatement();
                    statement.executeUpdate(sqlCommand);
                } catch (Exception e) {

                }
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                Statement statement = conn.createStatement();
                statement.executeUpdate("INSERT Users (Name, LastName, Age) VALUES " +
                        "(" + "'" + name + "'" + "," + "'" + lastName + "'" + "," + age + ")");
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
    }

    public void removeUserById(long id) {
        try {
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                Statement statement = conn.createStatement();
                int rows = statement.executeUpdate("DELETE FROM Users WHERE Id = " + id);
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
    }


    public List<User> getAllUsers() {
        List<User> listUsers = new ArrayList<>();
        try {
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");
                while (resultSet.next()) {
                    String name = resultSet.getString(2);
                    String lastname = resultSet.getString(3);
                    Byte age = (byte) resultSet.getInt(4);
                    listUsers.add(new User(name, lastname, age));
                }
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
        return listUsers;
    }

    public void cleanUsersTable() {
        try {
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                try {
                    String sqlCommand = "delete from Users";
                    Statement statement = conn.createStatement();
                    statement.executeUpdate(sqlCommand);
                } catch (Exception e) {

                }
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
    }
}
