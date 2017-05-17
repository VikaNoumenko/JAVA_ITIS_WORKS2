package ru.itis.java.annotation.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 16.05.2017
 * Motor
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component
public class Motor {

    @Autowired
    private Cylinder cylinder;

    public Motor() {
    }

    public Motor(Cylinder cylinder) {
        this.cylinder = cylinder;
    }

    public void start() {
        System.out.println("WROOM WROOM");
        cylinder.work();
    }
}
