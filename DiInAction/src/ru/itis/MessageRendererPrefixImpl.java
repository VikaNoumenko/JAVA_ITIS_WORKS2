package ru.itis;

/**
 * 25.04.2017
 * MessageRendererPrefixImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MessageRendererPrefixImpl implements MessageRenderer {
    private String prefix;

    public MessageRendererPrefixImpl(String prefix) {
        this.prefix = prefix;
    }

    public void render(Message message) {
        System.out.println(prefix + " " + message.getText());
    }
}
