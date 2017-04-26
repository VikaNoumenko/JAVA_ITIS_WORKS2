package ru.itis.observer.obideal;

/**
 * 25.04.2017
 * Main
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        Tokenizer tokenizer = new Tokenizer();
        tokenizer.addObserver(new LettersObserver());
        tokenizer.addObserver(new DigitsObserver());

        tokenizer.tokenize("Hello 123");
    }
}
