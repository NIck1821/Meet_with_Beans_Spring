package jm.task.core.jdbc;


import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        String[] name  = new String [] {"Winter", " Spring", " Summer", "Autumn"};
        for (int i1 = 0; i1 < 4; i1++) {
            userService.saveUser(name[i1], "alex", (byte) 1);
            System.out.println("User с именем – " + name[i1] + " добавлен в базу данных ");
        }
        for (int i = 0; i < 4; i++) {
            String Name = userService.getAllUsers().get(i).toString();
            System.out.println(Name);
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
