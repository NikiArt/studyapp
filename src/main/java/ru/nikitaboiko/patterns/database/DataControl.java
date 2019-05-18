package ru.nikitaboiko.patterns.database;

import lombok.SneakyThrows;
import ru.nikitaboiko.patterns.users.IdentityMapUsers;
import ru.nikitaboiko.patterns.users.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataControl {
    private static DataControl instance;
    private Connection connection;
    private Statement statement;

    private DataControl() {
    }

    public static synchronized DataControl getInstance() {
        if (instance == null) {
            instance = new DataControl();
        }
        return instance;
    }

    @SneakyThrows
    public void addUser(User user) {
        connection = DriverManager.getConnection("jdbc:mysql://localhost/studyapp?serverTimezone=Europe/Moscow&useSSL=false", "root", "1234");
        statement = connection.createStatement();
        String sqlComand = "INSERT INTO users(id, name, status) VALUES('" + user.getId() + "', '" + user.getName() + "', '" + (user.getStatus() ? 1 : 0) + "')";
        statement.executeUpdate(sqlComand);
        System.out.println(user + " was add to database");
        connection.close();
    }

    /**
     * @param name - считаем уникальным в БД
     */
    @SneakyThrows
    public User getUser(String name) {
        if (IdentityMapUsers.getInstance().checkUser(name) != null) {
            return IdentityMapUsers.getInstance().checkUser(name);
        }


        String idDb = "";
        String nameDb = "";
        Boolean status = false;
        connection = DriverManager.getConnection("jdbc:mysql://localhost/studyapp?serverTimezone=Europe/Moscow&useSSL=false", "root", "1234");
        statement = connection.createStatement();
        String sqlComand = "SELECT * FROM users WHERE name = '" + name + "'";
        ResultSet resultSet = statement.executeQuery(sqlComand);
        while (resultSet.next()) {

            idDb = resultSet.getString("id");
            nameDb = resultSet.getString("name");
            status = resultSet.getInt("status") == 1;

        }
        connection.close();

        if (idDb.isEmpty()) {
            return null;
        }

        User user = new User(nameDb, idDb);
        if (status) user.setActive();
        IdentityMapUsers.getInstance().getUserList().put(user.getName(), user);
        return user;
    }
}
