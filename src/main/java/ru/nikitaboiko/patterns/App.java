package ru.nikitaboiko.patterns;

import ru.nikitaboiko.patterns.services.ViewController;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final ViewController viewController = new ViewController();
        viewController.openUserWindow();
    }
}
