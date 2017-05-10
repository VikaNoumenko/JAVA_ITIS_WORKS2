package ru.itis;

/**
 * 06.05.2017
 * CustomMessage
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class CustomMessage implements Message {
    private String text;

    public void setText(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }
}
