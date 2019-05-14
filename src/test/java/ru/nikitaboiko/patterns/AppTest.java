package ru.nikitaboiko.patterns;

import org.junit.Test;
import ru.nikitaboiko.patterns.commandPattern.ChangeActive;
import ru.nikitaboiko.patterns.commandPattern.ChangeDeactive;
import ru.nikitaboiko.patterns.commandPattern.Changer;
import ru.nikitaboiko.patterns.commandPattern.Command;
import ru.nikitaboiko.patterns.users.Group;
import ru.nikitaboiko.patterns.users.User;

import static org.junit.Assert.assertTrue;

public class AppTest {

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void compositeText() {
        final User usrOne = new User("Ivan");
        final User usrTwo = new User("Boris");
        final User usrThree = new User("Petr");
        final Group group = new Group("Kate", "Olga", "Maria");
        group.addStudent(usrThree);
        usrOne.addToDb();
        group.addToDb();
        usrTwo.printOn();
        group.printOn();

        Command changeActive = new ChangeActive(usrOne);
        Command changeDeactive = new ChangeDeactive(usrOne);

        Changer userOneActivity = new Changer(changeActive, changeDeactive);

        userOneActivity.activate();
        userOneActivity.deactivate();
    }
}
