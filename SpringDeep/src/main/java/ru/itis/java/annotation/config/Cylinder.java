package ru.itis.java.annotation.config;

import org.springframework.stereotype.Component;

/**
 * 16.05.2017
 * Cylinder
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component
public class Cylinder {
    public void work() {
        System.out.println("CYLINDER WORK");
    }
}
