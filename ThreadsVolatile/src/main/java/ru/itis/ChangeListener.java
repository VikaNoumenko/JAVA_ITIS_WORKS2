package ru.itis;

import static ru.itis.Main.MY_INT;

public class ChangeListener extends Thread {
    public void run() {
        int localValue = MY_INT;

        while (localValue < 5) {
            if (localValue != MY_INT) {
                System.out.println("CHANGED " + MY_INT);
                localValue = MY_INT;
            }
        }
    }
}
