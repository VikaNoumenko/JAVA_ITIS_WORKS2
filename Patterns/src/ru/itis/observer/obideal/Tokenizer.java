package ru.itis.observer.obideal;

import java.util.ArrayList;
import java.util.List;

/**
 * 25.04.2017
 * Tokenizer
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Tokenizer extends AbstractObservable {

    public void tokenize(String text) {
        char[] textAsCharArray = text.toCharArray();

        for (int i = 0; i < textAsCharArray.length; i++) {
            notifyObserver(textAsCharArray[i], i);
        }
    }
}
