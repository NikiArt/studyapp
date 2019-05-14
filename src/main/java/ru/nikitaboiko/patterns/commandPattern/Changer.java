package ru.nikitaboiko.patterns.commandPattern;

public class Changer {
    private Command activateUser;
    private Command deactivateUser;

    public Changer(Command activateUser, Command deactivateUser) {
        this.activateUser = activateUser;
        this.deactivateUser = deactivateUser;
    }

    public void activate() {
        activateUser.execute();
    }

    public void deactivate() {
        deactivateUser.execute();
    }
}
