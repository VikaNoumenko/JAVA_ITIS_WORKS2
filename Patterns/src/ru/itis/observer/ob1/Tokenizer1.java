package ru.itis.observer.ob1;

/**
 * 25.04.2017
 * Tokenizer1
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Tokenizer1 {
    public void tokenize(String text) {
        char[] textAsCharArray = text.toCharArray();

        for (int i = 0; i < textAsCharArray.length; i++) {
            if (textAsCharArray[i] =='A') {
                System.out.println("It's A-letter");
            }
        }
    }
}
