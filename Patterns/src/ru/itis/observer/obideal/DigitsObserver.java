package ru.itis.observer.obideal;

/**
 * 25.04.2017
 * DigitsObserver
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class DigitsObserver implements Observer {

    @Override
    public void handle(Object... args) {
        char character = (Character)args[0];
        int position = (Integer)args[1];
        if (Character.isDigit(character)) {
            System.out.println("It's Digit at " + position);
        }
    }
}
