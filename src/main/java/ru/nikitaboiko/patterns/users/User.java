package ru.nikitaboiko.patterns.users;

import ru.nikitaboiko.patterns.database.DataControl;

import java.util.UUID;

public class User implements PersonModel {
    private String name;
    private String id;
    private Boolean active;

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

    public void setActive() {
        this.active = true;
        System.out.println(name + " переведен в статус 'Активный'");
    }

    public void setNotActive() {
        this.active = false;
        System.out.println(name + " переведен в статус 'В архиве'");
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
