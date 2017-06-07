package ru.itis;

import static ru.itis.Main.MY_INT;

public class ChangeMaker extends Thread {

    public void run() {
        int localVariable = MY_INT;

        while (MY_INT < 5) {
            System.out.println("INCREMENT " + (localVariable + 1));
            // сначала увеличиваем localVariable на 1, а потом
            // кладем в MY_INT;
            MY_INT = ++localVariable;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }
    }
}
