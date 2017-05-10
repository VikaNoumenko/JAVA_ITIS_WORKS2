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
    private Message message;

    public MessageRendererPrefixImpl(String prefix, Message message) {
        this.prefix = prefix;
        this.message = message;
    }

    public void render() {
        System.out.println(prefix + " " + message.getText());
    }
}
