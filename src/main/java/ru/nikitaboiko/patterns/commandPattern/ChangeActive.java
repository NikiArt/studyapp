package ru.nikitaboiko.patterns.commandPattern;

import ru.nikitaboiko.patterns.users.User;

public class ChangeActive implements Command {
    private User user;

    public ChangeActive(User user) {
        this.user = user;
    }

    @Override
    public void execute() {
        user.setActive();
    }
}
