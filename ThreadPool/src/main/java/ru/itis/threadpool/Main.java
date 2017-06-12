package ru.itis.threadpool;

import ru.itis.threadpool.pool.WorkQueue;
import ru.itis.threadpool.tasks.DigitsTask;
import ru.itis.threadpool.tasks.LettersTask;

public class Main {
    public static void main(String[] args) {
        WorkQueue queue = new WorkQueue(4);
        LettersTask lettersTask = new LettersTask();
        DigitsTask digitsTask = new DigitsTask();
        // анонимный класс
        Runnable helloTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread() + "Hello");
                }
            }
        };
        // лямбда выражение
        Runnable byeTask = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread() + "Bye");
            }
        };

        queue.submit(lettersTask);
        queue.submit(digitsTask);
        queue.submit(helloTask);
        queue.submit(byeTask);
    }
}
