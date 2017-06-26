package ru.ivmiit;

import sun.awt.windows.ThemeReader;

import java.util.Random;
import java.util.Scanner;

public class Main {
    volatile static int result = 0;
    static int array[];

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int numbersCount = scanner.nextInt();

        array = new int[numbersCount];

        Random random = new Random();

        for (int i = 0; i < numbersCount; i++) {
            array[i] = random.nextInt(100);
        }

        int sum = 0;
        for (int i = 0; i < numbersCount; i++) {
            sum += array[i];
        }

        System.out.println(sum);

        int threadsCount = scanner.nextInt();

        MyThread threads[] = new MyThread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            int start = i * (numbersCount / threadsCount);
            int end = start + numbersCount / threadsCount;
            threads[i] = new MyThread(start, end, i);
        }

        int lastThreadIndex = threadsCount - 1;
        threads[lastThreadIndex] = new MyThread(lastThreadIndex * (numbersCount / threadsCount),
                array.length, lastThreadIndex);

        long begin = System.nanoTime();

        for (MyThread thread : threads) {
            thread.start();
        }

        for (MyThread thread : threads) {
            thread.join();
        }

        System.out.println(((System.nanoTime() - begin) / 1000000000.0));
        System.out.println(result);
    }
}
