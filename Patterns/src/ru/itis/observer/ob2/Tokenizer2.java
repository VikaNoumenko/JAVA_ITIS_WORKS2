package ru.itis.observer.ob2;

/**
 * 25.04.2017
 * Tokenizer2
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Tokenizer2 {
    private TokenizerALetterObserver observer;

    public void setObserver(TokenizerALetterObserver observer) {
        this.observer = observer;
    }

    public void tokenize(String text) {
        char[] textAsCharArray = text.toCharArray();

        for (int i = 0; i < textAsCharArray.length; i++) {
            observer.handle(textAsCharArray[i]);
        }
    }
}
