package ru.itis.threadpool.tasks;

public class DigitsTask implements Runnable {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread() + "1");
        }
    }
}
