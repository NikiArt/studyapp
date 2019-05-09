package ru.nikitaboiko.patterns.users;

import ru.nikitaboiko.patterns.database.DataControl;

import java.util.UUID;

public class User implements PersonModel {
    private String name;
    private String id;

    public User(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public void addToDb() {
        DataControl.getInstance().addUser(this);
    }

    @Override
    public void printOn() {
        System.out.println(id + " | " + name);
    }
}
