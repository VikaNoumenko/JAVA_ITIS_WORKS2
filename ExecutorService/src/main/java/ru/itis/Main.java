package ru.itis;

import ru.itis.tasks.DigitsTask;
import ru.itis.tasks.LettersTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        LettersTask lettersTask = new LettersTask();
        DigitsTask digitsTask = new DigitsTask();

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

        ExecutorService service = Executors.newFixedThreadPool(5);
        service.submit(lettersTask);
        service.submit(digitsTask);
        service.submit(helloTask);
        service.submit(byeTask);
    }
}
