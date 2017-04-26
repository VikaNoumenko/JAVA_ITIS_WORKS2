package ru.itis.observer.ob2;

/**
 * 25.04.2017
 * Main2
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main2 {
    public static void main(String[] args) {
        String hello = "Hello, MARSELKA!!!!";
        Tokenizer2 tokenizer2 = new Tokenizer2();
        TokenizerALetterObserver observer = new TokenizerALetterObserver();
        tokenizer2.setObserver(observer);
        tokenizer2.tokenize(hello);
    }
}
