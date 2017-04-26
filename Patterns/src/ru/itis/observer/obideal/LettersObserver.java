package ru.itis.observer.obideal;

/**
 * 25.04.2017
 * LettersObserver
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class LettersObserver implements Observer {

    @Override
    public void handle(Object ... args) {
        char character = (Character)args[0];
        int position = (Integer)args[1];
        if (Character.isLetter(character)) {
            System.out.println("It's Letter at " + position);
        }
    }
}
