package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/Java-Pre-Project";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
            System.out.println("Connection OK!!!");
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection ERROR. Ara-Ara-Ara!");
            throw new RuntimeException(e);
        }
    }
}
