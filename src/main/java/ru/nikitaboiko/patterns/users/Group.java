package ru.nikitaboiko.patterns.users;

import ru.nikitaboiko.patterns.database.DataControl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Group implements PersonModel {
    private List<PersonModel> students = new ArrayList<>();
    private Date date;
    private String theme;

    public Group() {
    }

    public Group(String... users) {
        for (int i = 0; i < users.length; i++) {
            final User user = new User(users[i]);
            this.students.add(user);
        }
    }

    public Group(User... users) {
        this.students.addAll(Arrays.asList(users));
    }

    public void addDate(Date date) {
        this.date = date;
    }

    public void addTheme(String theme) {
        this.theme = theme;
    }

    public void addStudent(User user) {
        this.students.add(user);
    }

    @Override
    public void addToDb() {
        for (PersonModel student : students) {
            DataControl.getInstance().addUser((User) student);
        }
    }

    @Override
    public void printOn() {
        for (PersonModel student : students) {
            student.printOn();
        }
    }
}
