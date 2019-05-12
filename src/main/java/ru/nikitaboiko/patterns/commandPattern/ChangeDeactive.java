package ru.nikitaboiko.patterns.commandPattern;

import ru.nikitaboiko.patterns.users.User;

public class ChangeDeactive implements Command {
    private User user;

    public ChangeDeactive(User user) {
        this.user = user;
    }

    @Override
    public void execute() {
        user.setNotActive();
    }
}
