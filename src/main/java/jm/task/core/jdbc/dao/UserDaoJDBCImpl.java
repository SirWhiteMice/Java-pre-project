package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Connection connection = Util.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS USERS " +
                "(id bigint not null auto_increment PRIMARY KEY , name varchar(45) not null, lastName varchar(45) not null, age tinyint not null)")){
            preparedStatement.executeUpdate();
            System.out.println("Table is created!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        try (Connection connection = Util.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("DROP TABLE IF EXISTS USERS")){
            preparedStatement.executeUpdate();
            System.out.println("Table is DELETE");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (Connection connection = Util.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO USERS (name, lastName, age) VALUES (?, ?, ?)")){
            preparedStatement.setString(1,name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3,age);

            preparedStatement.executeUpdate();
            System.out.println("User is saved!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        try (Connection connection = Util.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM USERS WHERE id = ?")){
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            System.out.println("The user with ID = |" + id + "| has been deleted.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = Util.getConnection(); Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT id, name, lastName, age from USERS");

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastname"));
                user.setAge(resultSet.getByte("age"));

                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cleanUsersTable() {
        try (Connection connection = Util.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM USERS")){
            preparedStatement.executeUpdate();
            System.out.println("Table is cleaned!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
