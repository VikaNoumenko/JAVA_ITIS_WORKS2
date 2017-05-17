package ru.itis.autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 16.05.2017
 * MainWithSimpleSpringContext
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainWithSimpleSpringContext {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ru.itis\\auto_context.xml");
        Auto auto = context.getBean(Auto.class);
        auto.run();
    }
}
