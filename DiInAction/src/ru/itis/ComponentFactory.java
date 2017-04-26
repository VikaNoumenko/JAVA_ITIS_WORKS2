package ru.itis;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Properties;

/**
 * 25.04.2017
 * ComponentFactory
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class ComponentFactory {

    private Properties properties;

    public ComponentFactory() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("resources\\app.properties"));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public <T> T getComponent(Class<T> tClass) {
        if (tClass.getName().equals("ru.itis.Message")) {
            return (T)getMessage();
        } else if (tClass.getName().equals("ru.itis.MessageRenderer")) {
            return (T)getMessageRenderer();
        } else {
            throw new IllegalArgumentException("Not find class instance");
        }
    }
    /**
     * В записимости от конфигурации приложения
     * возвращает необходимый экземпляр Сообщения
     * @return
     */
    private Message getMessage() {
        try {
            String messageClassName = properties.getProperty("message.class");
            Class<Message> messageClass = (Class<Message>)Class.forName(messageClassName);
            Message instance = messageClass.newInstance();
            return instance;
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException(e);
        }
    }
    private MessageRenderer getMessageRenderer() {
        try {
            String messageRendererClassName = properties.getProperty("message.renderer.class");
            Class<MessageRenderer> messageRendererClass =
                    (Class<MessageRenderer>)Class.forName(messageRendererClassName);
            Constructor<MessageRenderer> constructor =
                    messageRendererClass.getConstructor(String.class);
            String prefix = properties.getProperty("message.prefix");
            MessageRenderer instance = constructor.newInstance(prefix);
            return instance;
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException(e);
        }
    }


}
