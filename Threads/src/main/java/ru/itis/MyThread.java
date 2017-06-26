package ru.itis;

public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 50; i++) {
            System.out.println("ВТОРОЙ ПОТОК" + "A" + i);
        }
    }
}
