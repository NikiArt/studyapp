package ru.nikitaboiko.patterns.users;

import ru.nikitaboiko.patterns.database.DataControl;

import java.util.UUID;

public class User implements PersonModel {
    private String name;
    private String email;
    private String id;
    private Boolean active;

    public User(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
        this.active = false;
    }

    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public User(String name, String email, String id) {
        this.name = name;
        this.id = id;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Boolean getStatus() {
        return active;
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
