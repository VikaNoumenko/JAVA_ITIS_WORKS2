package ru.itis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ru.itis\\context.xml");

        // MessageRenderer renderer = (MessageRenderer)context.getBean("renderer");
        MessageRenderer messageRenderer = context.getBean(MessageRenderer.class);
        messageRenderer.render();
    }
}
