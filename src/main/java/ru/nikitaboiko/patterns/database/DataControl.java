package ru.nikitaboiko.patterns.database;

import ru.nikitaboiko.patterns.users.User;

public class DataControl {
    private static DataControl instance;

    private DataControl() {
    }

    public static synchronized DataControl getInstance() {
        if (instance == null) {
            instance = new DataControl();
        }
        return instance;
    }

    public void addUser(User user) {
        System.out.println(user + " was add to database");
    }
}
