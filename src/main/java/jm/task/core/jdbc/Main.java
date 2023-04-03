package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();

        userService.saveUser("John", "Smith", (byte) 28);
        userService.saveUser("Emily", "Brown", (byte) 32);
        userService.saveUser("Michael", "Johnson", (byte)45);
        userService.saveUser("Sarah", "Davis", (byte)19);

        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();

        /*

        userDaoJDBC.saveUser("Daniel", "Garcia", (byte)52);
        userDaoJDBC.saveUser("Lauren", "Martinez", (byte)37);
        userDaoJDBC.saveUser("Matthew", "Wilson", (byte)24);
        userDaoJDBC.saveUser("Samantha", "Anderson", (byte)29);
        userDaoJDBC.saveUser("David", "Thomas", (byte)31);
        userDaoJDBC.saveUser("Elizabeth", "Thompson", (byte)42);

         */

    }
}
