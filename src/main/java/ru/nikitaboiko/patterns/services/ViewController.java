package ru.nikitaboiko.patterns.services;

import ru.nikitaboiko.patterns.database.DataControl;
import ru.nikitaboiko.patterns.gui.AddUserWindow;
import ru.nikitaboiko.patterns.users.User;

import javax.swing.*;
import java.util.UUID;

public class ViewController {
    private AddUserWindow addUserWindow;

    public ViewController() {
        addUserWindow = new AddUserWindow(this);
    }

    public Boolean openUserWindow() {
        addUserWindow.setVisible(true);
        return addUserWindow.isVisible();
    }

    public void addNewUserToDb() {
        if (addUserWindow.getJTextFieldName().getText().isEmpty()) {
            JOptionPane.showMessageDialog(addUserWindow, "Поле 'имя' обязательно для заполнения");
            return;
        }
        if (addUserWindow.getJTextFieldEmail().getText().isEmpty()) {
            JOptionPane.showMessageDialog(addUserWindow, "Поле 'e-mail' обязательно для заполнения");
            return;
        }

        String id = UUID.randomUUID().toString();
        String name = addUserWindow.getJTextFieldName().getText();
        String email = addUserWindow.getJTextFieldEmail().getText();
        User user = new User(name, email, id);
        DataControl.getInstance().addUser(user);
        addUserWindow.setVisible(false);
    }

}
