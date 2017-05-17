package ru.itis;

import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 16.05.2017
 * MainPrimitive
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("ru.itis\\context.xml");

        Info info = context.getBean(Info.class);

        System.out.println(info.getInfo());

        info.setInfo("Bye");

        Info info1 = context.getBean(Info.class);

        System.out.println(info1.getInfo());
    }
}
