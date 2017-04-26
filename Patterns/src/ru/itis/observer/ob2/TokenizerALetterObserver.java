package ru.itis.observer.ob2;

/**
 * 25.04.2017
 * TokenizerALetterObserver
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class TokenizerALetterObserver {
    public void handle(char character) {
        if (character == 'A') {
            System.out.println("It' A");
        }
    }
}
