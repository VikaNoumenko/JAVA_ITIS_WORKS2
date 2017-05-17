package ru.itis.java.annotation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 16.05.2017
 * Auto
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component
public class Auto {
    @Autowired
    private Motor motor;

    public Auto() {
    }

    public Auto(Motor motor) {
        this.motor = motor;
    }

    public void run() {
        System.out.println("AUTO RUN");
        motor.start();
    }
}
